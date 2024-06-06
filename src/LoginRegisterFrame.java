import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginRegisterFrame extends JFrame implements ActionListener {
    private Assets assets = new Assets();

    // String vars
    private int CHAR_NAME_LIMIT = 12;

    // Buttons
    private RoundedButton btn_ToLogin, btn_ToRegister, btn_submitSignUp, btn_submitSignIn;

    // JTextField
    private JTextField reg_emailTextField, nameTextField, log_emailTextField;

    // JPasswordField
    private JPasswordField reg_passwordTextField, confirmPasswordTextField, log_passwordTextField;

    // Layout
    private CardLayout cardLayoutLoginRegister;

    // Panel
    private JPanel mainBackground;

    // Regex for email
    private final Pattern emailPattern = Pattern.compile("^[a-z0-9._+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");

    // Regex for password
    private final Pattern passwordPattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[~@#$^*()_+=\\[\\]{}|,.?/!%&:-]).{8,}$");

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // Switch to Log in and to Register
        if (actionEvent.getSource() == btn_ToLogin){
            System.out.println("TO LOGIN");
            cardLayoutLoginRegister.show(mainBackground, "LOGIN");
        }

        if (actionEvent.getSource() == btn_ToRegister){
            System.out.println("TO REGISTER");
            cardLayoutLoginRegister.show(mainBackground, "REGISTER");
        }

        // Get the values for Register
        String reg_emailValue = reg_emailTextField.getText();
        String reg_nameValue = nameTextField.getText();
        String reg_passwordValue = new String(reg_passwordTextField.getPassword());
        String reg_conPasswordValue = new String(confirmPasswordTextField.getPassword());

        // Submit Sign Up
        if (actionEvent.getSource() == btn_submitSignUp){
            boolean isEmpty = false;
            boolean isInfoValid = true;
            if (reg_emailValue.isEmpty() || reg_nameValue.isEmpty() || reg_passwordValue.isEmpty() || reg_conPasswordValue.isEmpty()){
                JOptionPane.showMessageDialog(this,
                        "Please fill up each text field!",
                        "Empty Input",
                        JOptionPane.ERROR_MESSAGE);
                isEmpty = true;
                isInfoValid = false;
            }

            if (!isEmpty){
                // Check Email
                if (!checkEmailValue(reg_emailValue)){
                    JOptionPane.showMessageDialog(this,
                            "Invalid Email!",
                            "Incorrect Email",
                            JOptionPane.ERROR_MESSAGE);
                    isInfoValid = false;
                }

                // Check password validity
                if (!checkPasswordValue(reg_passwordValue)){
                    JOptionPane.showMessageDialog(this,
                            "Password is Weak!\n- 8 minimum characters\n- Has Uppercase and Lowercase\n- Has Special Char\n- Has numerical digit",
                            "Incorrect Password",
                            JOptionPane.ERROR_MESSAGE);
                    isInfoValid = false;
                }

                // Check password if equals
                if (!reg_passwordValue.equals(reg_conPasswordValue)){
                    JOptionPane.showMessageDialog(this,
                            "Passwords does not match!",
                            "Incorrect Password",
                            JOptionPane.ERROR_MESSAGE);
                    isInfoValid = false;
                }

                // Check if the email already exist
                if (checkIfEmailAlreadyExist(reg_emailValue)){
                    JOptionPane.showMessageDialog(this,
                            "Email Already Exist!",
                            "Email Error",
                            JOptionPane.ERROR_MESSAGE);
                    isInfoValid = false;
                }

                // Check if the name is below 12 char
                if (reg_nameValue.length() > CHAR_NAME_LIMIT){
                    JOptionPane.showMessageDialog(this,
                            "Name is Too Long!",
                            "Name Error",
                            JOptionPane.ERROR_MESSAGE);
                    isInfoValid = false;
                }
            }

            if (isInfoValid){
                int lastIndex = reg_emailValue.indexOf("@");
                String fileName = reg_emailValue.substring(0, lastIndex) + "-" + reg_nameValue;
                try {
                    File individual_file = new File("src/textfiles/UsersFile/" + fileName + ".txt");
                    if (individual_file.createNewFile()){
                        System.out.println("File Created: " + individual_file.getName());
                    }else {
                        JOptionPane.showMessageDialog(this,
                                "User File is not created!",
                                "User File",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this,
                            "Error Creating User File!",
                            "User File",
                            JOptionPane.ERROR_MESSAGE);
                }

                insertUser(reg_emailValue, reg_nameValue, reg_passwordValue);

                this.dispose();
                DashboardFrame dashboardFrame = new DashboardFrame(reg_nameValue);
            }

            System.out.println();
            System.out.println(reg_emailValue);
            System.out.println(reg_nameValue);
            System.out.println(reg_passwordValue);
            System.out.println(reg_conPasswordValue);
        }

        // Get Values for Log In
        String log_emailValue = log_emailTextField.getText();
        String log_passValue = new String(log_passwordTextField.getPassword());

        // Submit Sign In
        if (actionEvent.getSource() == btn_submitSignIn){
            boolean isEmpty = checkIfUserFileIsEmpty(assets.getUsersFilePath());
            if (isEmpty){
                JOptionPane.showMessageDialog(this,
                        "No Available Accounts",
                        "Sign In",
                        JOptionPane.ERROR_MESSAGE);
            }else {
                String[] userData = getUserInfo(log_emailValue);
                System.out.println(userData[0]);
                System.out.println(userData[1]);
                System.out.println(userData[2]);

                if (userData[0] != null){
                    if (userData[1].equals(log_passValue)){
                        this.dispose();
                        DashboardFrame dashboardFrame = new DashboardFrame(userData[2]);
                    }else {
                        JOptionPane.showMessageDialog(this,
                                "Incorrect Password",
                                "Sign In",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    public boolean checkIfEmailAlreadyExist(String email){
        try{
            FileReader filePath = new FileReader(assets.getUsersFilePath());
            BufferedReader reader = new BufferedReader(filePath);
            String line;
            String[] record;
            while ((line = reader.readLine()) != null){
                record = line.split(",");
                if (record[0].equals(email)){
                    return true;
                }
            }
        }catch (IOException exception){
            JOptionPane.showMessageDialog(this,
                    "Error Reading Data!",
                    "Reading Records Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    // Check if the User File is Empty
    public boolean checkIfUserFileIsEmpty(String filePath){
        try{
            FileReader file = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(file);
            return reader.readLine() == null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Get the email and password for checking
    public String[] getUserInfo(String email){
        String[] info = new String[3];
        boolean isUserExist = true;
        try {
            FileReader filePath = new FileReader(assets.getUsersFilePath());
            BufferedReader reader = new BufferedReader(filePath);
            String line;
            String[] record = null;
            while ((line = reader.readLine()) != null) {
                record = line.split(",");
                if (record[0].equals(email)){
                    isUserExist = true;
                    break;
                }else {
                    isUserExist = false;
                }
            }
            reader.close();

            if (isUserExist){
                info = record;
            }else {
                JOptionPane.showMessageDialog(this,
                        "User Doesn't Exist!",
                        "Reading Records",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error Reading Data!",
                    "Reading Records Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return info;
    }

    // Method for adding account to the text file
    public void insertUser(String email, String name, String password){
        try{
            FileWriter path = new FileWriter(assets.getUsersFilePath(), true);
            BufferedWriter writer = new BufferedWriter(path);

            String combineData = email + "," + password + "," + name;

            if (FileLength(assets.getUsersFilePath()) == 0){
                writer.write(combineData);
            }else {
                writer.append("\n").append(combineData);
            }

            writer.close();
            System.out.println("ADDED!");
        }catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error Adding Data!",
                    "Insert User Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public int FileLength(String path){
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while (reader.readLine() != null) lines++;
            reader.close();

        }catch (IOException exception){
            System.out.println("\nError Reading the Length of the file...\n");
        }

        return lines;
    }

    public boolean checkPasswordValue(String password){
        Matcher match = passwordPattern.matcher(password);
        return match.find();
    }

    public boolean checkEmailValue(String email){
        Matcher match = emailPattern.matcher(email);
        return match.matches();
    }

    public LoginRegisterFrame(){
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("WikaWisdom");
        setLocationRelativeTo(null);
        setIconImage(assets.getWikaLogo().getImage());
        setResizable(false);

        cardLayoutLoginRegister = new CardLayout();
        mainBackground = new JPanel();
        mainBackground.setLayout(cardLayoutLoginRegister);
        mainBackground.setBackground(assets.getMainColorDarkGreen());

        JPanel registerPanel = Register();
        mainBackground.add(registerPanel, "REGISTER");

        JPanel loginPanel = Login();
        mainBackground.add(loginPanel, "LOGIN");

        this.add(mainBackground);
        setVisible(true);
    }

    public JPanel Register(){
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(1, 2));

        // Panel with the Logo
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(assets.getMainColorDarkGreen());
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS));
        registerPanel.add(logoPanel);

        JPanel TopPanel = new JPanel();
        TopPanel.setBackground(null);
        TopPanel.setLayout(new BoxLayout(TopPanel, BoxLayout.Y_AXIS));
        logoPanel.add(TopPanel);

        JLabel logo = new JLabel();
        logo.setIcon(assets.getWikaLogoTrans());
        logo.setAlignmentX(CENTER_ALIGNMENT);
        TopPanel.add(logo);

        JLabel appName = new JLabel("Wika Wisdom");
        appName.setFont(assets.getArialTitle());
        appName.setAlignmentX(CENTER_ALIGNMENT);
        appName.setForeground(assets.getMainColorWhiteBG());
        TopPanel.add(appName);

        JPanel BottomPanel = new JPanel();
        BottomPanel.setBackground(null);
        BottomPanel.setLayout(new BorderLayout());
        logoPanel.add(BottomPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(0, 0, 50, 0)); // Padding
        buttonPanel.setBackground(null);
        BottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        btn_ToLogin = new RoundedButton();
        btn_ToLogin.setText("Sign In");
        btn_ToLogin.setFocusable(false);
        btn_ToLogin.setFont(assets.getArialBold());
        btn_ToLogin.setForeground(assets.getMainColorWhiteBG());
        btn_ToLogin.setColor(assets.getMainColorYellowBG());
        btn_ToLogin.setRadius(20);
        btn_ToLogin.setColorClick(assets.getYellowColorClick());
        btn_ToLogin.setBorderColor(assets.getMainColorDarkGreen());
        btn_ToLogin.setColorOver(assets.getYellowColorOver());
        btn_ToLogin.setBorder(null);
        btn_ToLogin.setPreferredSize(new Dimension(180, 50));
        btn_ToLogin.addActionListener(this);
        buttonPanel.add(btn_ToLogin);

        /*
        * ===========================================================================
        * ===========================================================================
        */

        // Panel with register form
        JPanel regPanel = new JPanel();
        regPanel.setBackground(assets.getMainColorWhiteBG());
        regPanel.setLayout(new BorderLayout());
        regPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        registerPanel.add(regPanel);

        RoundedPanel FormPanel = new RoundedPanel(20, 20, 20, 20);
        FormPanel.setBackground(assets.getMainColorWhithy());
        FormPanel.setLayout(new BoxLayout(FormPanel, BoxLayout.Y_AXIS));
        FormPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        regPanel.add(FormPanel);

        JPanel signUpTitlePanel = new JPanel();
        signUpTitlePanel.setBackground(null);
        signUpTitlePanel.setLayout(new BorderLayout());
        FormPanel.add(signUpTitlePanel);

        JLabel SignUpTitle = new JLabel("Sign Up");
        SignUpTitle.setForeground(assets.getMainColorBlackTxt());
        SignUpTitle.setBackground(null);
        SignUpTitle.setFont(assets.getArialBold());
        SignUpTitle.setBorder(new EmptyBorder(20, 0, 0, 0));
        SignUpTitle.setVerticalTextPosition(JLabel.CENTER);
        signUpTitlePanel.add(SignUpTitle, BorderLayout.WEST);

        JPanel emailTitlePanel = new JPanel();
        emailTitlePanel.setBackground(null);
        emailTitlePanel.setLayout(new BorderLayout());
        FormPanel.add(emailTitlePanel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(assets.getMainColorBlackTxt());
        emailLabel.setFont(assets.getArial());
        emailLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        emailTitlePanel.add(emailLabel, BorderLayout.WEST);

        reg_emailTextField = new JTextField();
        reg_emailTextField.setFont(assets.getArial());
        reg_emailTextField.setBorder(BorderFactory.createLineBorder(assets.getMainColorDarkGreen(), 2));
        reg_emailTextField.setPreferredSize(new Dimension(getWidth(), 40));
        reg_emailTextField.setForeground(assets.getMainColorBlackTxt());
        reg_emailTextField.setMaximumSize(reg_emailTextField.getPreferredSize());
        FormPanel.add(reg_emailTextField);

        JPanel nameTitlePanel = new JPanel();
        nameTitlePanel.setBackground(null);
        nameTitlePanel.setLayout(new BorderLayout());
        FormPanel.add(nameTitlePanel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(assets.getMainColorBlackTxt());
        nameLabel.setFont(assets.getArial());
        nameLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        nameTitlePanel.add(nameLabel, BorderLayout.WEST);

        nameTextField = new JTextField();
        nameTextField.setFont(assets.getArial());
        nameTextField.setBorder(BorderFactory.createLineBorder(assets.getMainColorDarkGreen(), 2));
        nameTextField.setPreferredSize(new Dimension(getWidth(), 40));
        nameTextField.setMaximumSize(reg_emailTextField.getPreferredSize());
        nameTextField.setForeground(assets.getMainColorBlackTxt());
        FormPanel.add(nameTextField);

        JPanel passTitlePanel = new JPanel();
        passTitlePanel.setBackground(null);
        passTitlePanel.setLayout(new BorderLayout());
        FormPanel.add(passTitlePanel);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(assets.getMainColorBlackTxt());
        passwordLabel.setFont(assets.getArial());
        passwordLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        passTitlePanel.add(passwordLabel);

        reg_passwordTextField = new JPasswordField();
        reg_passwordTextField.setFont(assets.getArial());
        reg_passwordTextField.setBorder(BorderFactory.createLineBorder(assets.getMainColorDarkGreen(), 2));
        reg_passwordTextField.setPreferredSize(new Dimension(getWidth(), 40));
        reg_passwordTextField.setMaximumSize(reg_emailTextField.getPreferredSize());
        reg_passwordTextField.setForeground(assets.getMainColorBlackTxt());
        FormPanel.add(reg_passwordTextField);

        JPanel conPassTitlePanel = new JPanel();
        conPassTitlePanel.setBackground(null);
        conPassTitlePanel.setLayout(new BorderLayout());
        FormPanel.add(conPassTitlePanel);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setForeground(assets.getMainColorBlackTxt());
        confirmPasswordLabel.setFont(assets.getArial());
        confirmPasswordLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        conPassTitlePanel.add(confirmPasswordLabel);

        confirmPasswordTextField = new JPasswordField();
        confirmPasswordTextField.setFont(assets.getArial());
        confirmPasswordTextField.setBorder(BorderFactory.createLineBorder(assets.getMainColorDarkGreen(), 2));
        confirmPasswordTextField.setPreferredSize(new Dimension(getWidth(), 40));
        confirmPasswordTextField.setForeground(assets.getMainColorBlackTxt());
        confirmPasswordTextField.setMaximumSize(reg_emailTextField.getPreferredSize());
        FormPanel.add(confirmPasswordTextField);

        JPanel signupButtonPanel = new JPanel();
        signupButtonPanel.setLayout(new BorderLayout());
        signupButtonPanel.setBackground(null);
        signupButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        FormPanel.add(signupButtonPanel);

        btn_submitSignUp = new RoundedButton();
        btn_submitSignUp.setText("Sign Up");
        btn_submitSignUp.setPreferredSize(new Dimension(150, 50));
        btn_submitSignUp.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn_submitSignUp.setMaximumSize(btn_submitSignUp.getPreferredSize());
        btn_submitSignUp.setColor(assets.getMainColorYellowBG());
        btn_submitSignUp.setRadius(20);
        btn_submitSignUp.setColorClick(assets.getYellowColorClick());
        btn_submitSignUp.setBorderColor(assets.getMainColorWhiteBG());
        btn_submitSignUp.setColorOver(assets.getYellowColorOver());
        btn_submitSignUp.setForeground(assets.getMainColorWhiteBG());
        btn_submitSignUp.setBorder(null);
        btn_submitSignUp.setFocusable(false);
        btn_submitSignUp.setFont(assets.getArialBold());
        btn_submitSignUp.addActionListener(this);
        signupButtonPanel.add(btn_submitSignUp, BorderLayout.SOUTH);
        
        return registerPanel;
    }

    public JPanel Login(){
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.blue);
        loginPanel.setLayout(new GridLayout(1, 2));

        // SIGN IN PANEL
        JPanel signinPanel = new JPanel();
        signinPanel.setBackground(assets.getMainColorWhiteBG());
        signinPanel.setLayout(new BorderLayout());
        signinPanel.setBorder(new EmptyBorder(150, 50, 150, 50));
        loginPanel.add(signinPanel);

        RoundedPanel FormPanel = new RoundedPanel(20, 20, 20, 20);
        FormPanel.setBackground(assets.getMainColorWhithy());
        FormPanel.setLayout(new BoxLayout(FormPanel, BoxLayout.Y_AXIS));
        FormPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
        signinPanel.add(FormPanel);

        JPanel signinTitlePanel = new JPanel();
        signinTitlePanel.setBackground(null);
        signinTitlePanel.setLayout(new BorderLayout());
        FormPanel.add(signinTitlePanel);

        JLabel signInTitle = new JLabel("Sign In");
        signInTitle.setFont(assets.getArialBold());
        signInTitle.setBorder(new EmptyBorder(20, 0, 0, 0));
        signInTitle.setForeground(assets.getMainColorBlackTxt());
        signInTitle.setHorizontalAlignment(JLabel.LEFT);
        signinTitlePanel.add(signInTitle, BorderLayout.WEST);

        JPanel emailTitlePanel = new JPanel();
        emailTitlePanel.setBackground(null);
        emailTitlePanel.setLayout(new BorderLayout());
        FormPanel.add(emailTitlePanel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(assets.getArial());
        emailLabel.setBorder(new EmptyBorder(10, 0, 0, 0));
        emailLabel.setForeground(assets.getMainColorBlackTxt());
        emailTitlePanel.add(emailLabel, BorderLayout.WEST);

        log_emailTextField = new JTextField();
        log_emailTextField.setForeground(assets.getMainColorBlackTxt());
        log_emailTextField.setFont(assets.getArial());
        log_emailTextField.setBorder(BorderFactory.createLineBorder(assets.getMainColorDarkGreen(), 2));
        log_emailTextField.setPreferredSize(new Dimension(getWidth(), 40));
        log_emailTextField.setMaximumSize(log_emailTextField.getPreferredSize());
        FormPanel.add(log_emailTextField);

        JPanel passwordTitlePanel = new JPanel();
        passwordTitlePanel.setBackground(null);
        passwordTitlePanel.setLayout(new BorderLayout());
        FormPanel.add(passwordTitlePanel);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(assets.getArial());
        passwordLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        passwordLabel.setForeground(assets.getMainColorBlackTxt());
        passwordTitlePanel.add(passwordLabel, BorderLayout.WEST);

        log_passwordTextField = new JPasswordField();
        log_passwordTextField.setForeground(assets.getMainColorBlackTxt());
        log_passwordTextField.setFont(assets.getArial());
        log_passwordTextField.setBorder(BorderFactory.createLineBorder(assets.getMainColorDarkGreen(), 2));
        log_passwordTextField.setPreferredSize(new Dimension(getWidth(), 40));
        log_passwordTextField.setMaximumSize(log_passwordTextField.getPreferredSize());
        FormPanel.add(log_passwordTextField);

        JPanel signinButtonPanel = new JPanel();
        signinButtonPanel.setLayout(new BorderLayout());
        signinButtonPanel.setBackground(null);
        signinButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        FormPanel.add(signinButtonPanel);

        btn_submitSignIn = new RoundedButton();
        btn_submitSignIn.setText("Sign In");
        btn_submitSignIn.setPreferredSize(new Dimension(150, 50));
        btn_submitSignIn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn_submitSignIn.setMaximumSize(btn_submitSignIn.getPreferredSize());
        btn_submitSignIn.setColor(assets.getMainColorYellowBG());
        btn_submitSignIn.setRadius(20);
        btn_submitSignIn.setColorClick(assets.getYellowColorClick());
        btn_submitSignIn.setBorderColor(assets.getMainColorWhiteBG());
        btn_submitSignIn.setColorOver(assets.getYellowColorOver());
        btn_submitSignIn.setForeground(assets.getMainColorWhiteBG());
        btn_submitSignIn.setBorder(null);
        btn_submitSignIn.setFocusable(false);
        btn_submitSignIn.setFont(assets.getArialBold());
        btn_submitSignIn.addActionListener(this);
        signinButtonPanel.add(btn_submitSignIn, BorderLayout.SOUTH);

        /*
        * ================================================================
        * ================================================================
        */

        // LOGO PANEL
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(assets.getMainColorDarkGreen());
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS));
        loginPanel.add(logoPanel);

        JPanel TopPanel = new JPanel();
        TopPanel.setBackground(null);
        TopPanel.setLayout(new BoxLayout(TopPanel, BoxLayout.Y_AXIS));
        logoPanel.add(TopPanel);

        JLabel logo = new JLabel();
        logo.setIcon(assets.getWikaLogoTrans());
        logo.setAlignmentX(CENTER_ALIGNMENT);
        TopPanel.add(logo);

        JLabel appName = new JLabel("Wika Wisdom");
        appName.setFont(assets.getArialTitle());
        appName.setAlignmentX(CENTER_ALIGNMENT);
        appName.setForeground(assets.getMainColorWhiteBG());
        TopPanel.add(appName);

        JPanel BottomPanel = new JPanel();
        BottomPanel.setBackground(null);
        BottomPanel.setLayout(new BorderLayout());
        logoPanel.add(BottomPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(0, 0, 50, 0)); // Padding
        buttonPanel.setBackground(null);
        BottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        btn_ToRegister = new RoundedButton();
        btn_ToRegister.setText("Sign Up");
        btn_ToRegister.setFocusable(false);
        btn_ToRegister.setFont(assets.getArialBold());
        btn_ToRegister.setForeground(assets.getMainColorWhiteBG());
        btn_ToRegister.setColor(assets.getMainColorYellowBG());
        btn_ToRegister.setRadius(20);
        btn_ToRegister.setColorClick(assets.getYellowColorClick());
        btn_ToRegister.setColorOver(assets.getYellowColorOver());
        btn_ToRegister.setBorder(null);
        btn_ToRegister.setBorderColor(assets.getMainColorYellowBG());
        btn_ToRegister.setPreferredSize(new Dimension(180, 50));
        btn_ToRegister.addActionListener(this);
        buttonPanel.add(btn_ToRegister);

        return loginPanel;

    }

}
