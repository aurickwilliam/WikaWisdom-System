import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginRegisterFrame extends JFrame {
    // Images
    private ImageIcon WikaLogo = new ImageIcon("src/img/WikaLogo.png");
    private ImageIcon WikaLogoTrans = new ImageIcon("src/img/WikaLogoTrans.png");

    // Colors
    private Color mainColorDarkGreen = new Color(0x004e64);
    private Color mainColorWhiteBG = new Color(0xF3F3F3);
    private Color mainColorBlackTxt = new Color(0x3B3B3B);
    private Color mainColorYellowBG = new Color(0xF5C529);
    private Color YellowColorClick = new Color(0xD9BD64);
    private Color YellowColorOver = new Color(0xB68F10);
    private Color mainColorWhithy = new Color(0xFFFFFF);

    // Fonts
    private Font ArialTitle = new Font("Arial Black", Font.PLAIN, 24);
    private Font ArialBold = new Font("Arial", Font.BOLD, 20);
    private Font Arial = new Font("Arial", Font.PLAIN, 16);

    public LoginRegisterFrame(){
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("WikaWisdom");
        setLocationRelativeTo(null);
        setIconImage(WikaLogo.getImage());
        setResizable(false);


        JPanel mainBackground = new JPanel();
        mainBackground.setLayout(new CardLayout());
        mainBackground.setBackground(mainColorDarkGreen);

        JPanel registerPanel = Register();
        mainBackground.add(registerPanel, "REGISTER");

        this.add(mainBackground);
        setVisible(true);
    }

    public JPanel Register(){
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(1, 2));

        // Panel with the Logo
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(mainColorDarkGreen);
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS));
        registerPanel.add(logoPanel);

        JPanel TopPanel = new JPanel();
        TopPanel.setBackground(null);
        TopPanel.setLayout(new BoxLayout(TopPanel, BoxLayout.Y_AXIS));
        logoPanel.add(TopPanel);

        JLabel logo = new JLabel();
        logo.setIcon(WikaLogoTrans);
        logo.setAlignmentX(CENTER_ALIGNMENT);
        TopPanel.add(logo);

        JLabel appName = new JLabel("Wika Wisdom");
        appName.setFont(ArialTitle);
        appName.setAlignmentX(CENTER_ALIGNMENT);
        appName.setForeground(mainColorWhiteBG);
        TopPanel.add(appName);

        JPanel BottomPanel = new JPanel();
        BottomPanel.setBackground(null);
        BottomPanel.setLayout(new BorderLayout());
        logoPanel.add(BottomPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(0, 0, 50, 0)); // Padding
        buttonPanel.setBackground(null);
        BottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        RoundedButton btn_ToLogin = new RoundedButton();
        btn_ToLogin.setText("Sign In");
        btn_ToLogin.setFocusable(false);
        btn_ToLogin.setFont(ArialBold);
        btn_ToLogin.setForeground(mainColorWhiteBG);
        btn_ToLogin.setColor(mainColorYellowBG);
        btn_ToLogin.setRadius(20);
        btn_ToLogin.setColorClick(YellowColorClick);
        btn_ToLogin.setBorderColor(mainColorDarkGreen);
        btn_ToLogin.setColorOver(YellowColorOver);
        btn_ToLogin.setBorder(null);
        btn_ToLogin.setPreferredSize(new Dimension(180, 50));
        buttonPanel.add(btn_ToLogin);

        // Panel with register form
        JPanel regPanel = new JPanel();
        regPanel.setBackground(mainColorWhiteBG);
        regPanel.setLayout(new BorderLayout());
        regPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        registerPanel.add(regPanel);

        RoundedPanel FormPanel = new RoundedPanel(20, 20, 20, 20);
        FormPanel.setBackground(mainColorWhithy);
        FormPanel.setLayout(new BoxLayout(FormPanel, BoxLayout.Y_AXIS));
        FormPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        regPanel.add(FormPanel);

        JPanel signUpTitlePanel = new JPanel();
        signUpTitlePanel.setBackground(null);
        signUpTitlePanel.setLayout(new BorderLayout());
        FormPanel.add(signUpTitlePanel);

        JLabel SignUpTitle = new JLabel("Sign Up");
        SignUpTitle.setForeground(mainColorBlackTxt);
        SignUpTitle.setBackground(null);
        SignUpTitle.setFont(ArialBold);
        SignUpTitle.setBorder(new EmptyBorder(20, 0, 0, 0));
        SignUpTitle.setOpaque(true);
        SignUpTitle.setVerticalTextPosition(JLabel.CENTER);
        signUpTitlePanel.add(SignUpTitle, BorderLayout.WEST);

        JPanel emailTitlePanel = new JPanel();
        emailTitlePanel.setBackground(null);
        emailTitlePanel.setLayout(new BorderLayout());
        FormPanel.add(emailTitlePanel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(mainColorBlackTxt);
        emailLabel.setFont(Arial);
        emailLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        emailTitlePanel.add(emailLabel, BorderLayout.WEST);

        JTextField emailTextField = new JTextField();
        emailTextField.setFont(Arial);
        emailTextField.setBorder(BorderFactory.createLineBorder(mainColorDarkGreen, 2));
        emailTextField.setPreferredSize(new Dimension(getWidth(), 40));
        emailTextField.setForeground(mainColorBlackTxt);
        emailTextField.setMaximumSize(emailTextField.getPreferredSize());
        FormPanel.add(emailTextField);

        JPanel nameTitlePanel = new JPanel();
        nameTitlePanel.setBackground(null);
        nameTitlePanel.setLayout(new BorderLayout());
        FormPanel.add(nameTitlePanel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(mainColorBlackTxt);
        nameLabel.setFont(Arial);
        nameLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        nameTitlePanel.add(nameLabel, BorderLayout.WEST);

        JTextField nameTextField = new JTextField();
        nameTextField.setFont(Arial);
        nameTextField.setBorder(BorderFactory.createLineBorder(mainColorDarkGreen, 2));
        nameTextField.setPreferredSize(new Dimension(getWidth(), 40));
        nameTextField.setMaximumSize(emailTextField.getPreferredSize());
        nameTextField.setForeground(mainColorBlackTxt);
        FormPanel.add(nameTextField);

        JPanel passTitlePanel = new JPanel();
        passTitlePanel.setBackground(null);
        passTitlePanel.setLayout(new BorderLayout());
        FormPanel.add(passTitlePanel);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(mainColorBlackTxt);
        passwordLabel.setFont(Arial);
        passwordLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        passTitlePanel.add(passwordLabel);

        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setFont(Arial);
        passwordTextField.setBorder(BorderFactory.createLineBorder(mainColorDarkGreen, 2));
        passwordTextField.setPreferredSize(new Dimension(getWidth(), 40));
        passwordTextField.setMaximumSize(emailTextField.getPreferredSize());
        passwordTextField.setForeground(mainColorBlackTxt);
        FormPanel.add(passwordTextField);

        JPanel conPassTitlePanel = new JPanel();
        conPassTitlePanel.setBackground(null);
        conPassTitlePanel.setLayout(new BorderLayout());
        FormPanel.add(conPassTitlePanel);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setForeground(mainColorBlackTxt);
        confirmPasswordLabel.setFont(Arial);
        confirmPasswordLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        conPassTitlePanel.add(confirmPasswordLabel);

        JPasswordField confirmPasswordTextField = new JPasswordField();
        confirmPasswordTextField.setFont(Arial);
        confirmPasswordTextField.setBorder(BorderFactory.createLineBorder(mainColorDarkGreen, 2));
        confirmPasswordTextField.setPreferredSize(new Dimension(getWidth(), 40));
        confirmPasswordTextField.setForeground(mainColorBlackTxt);
        confirmPasswordTextField.setMaximumSize(emailTextField.getPreferredSize());
        FormPanel.add(confirmPasswordTextField);

        JPanel signupButtonPanel = new JPanel();
        signupButtonPanel.setLayout(new BorderLayout());
        signupButtonPanel.setBackground(null);
        signupButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        FormPanel.add(signupButtonPanel);

        RoundedButton btn_submitSignUp = new RoundedButton();
        btn_submitSignUp.setText("Sign Up");
        btn_submitSignUp.setPreferredSize(new Dimension(150, 50));
        btn_submitSignUp.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn_submitSignUp.setMaximumSize(btn_submitSignUp.getPreferredSize());
        btn_submitSignUp.setColor(mainColorYellowBG);
        btn_submitSignUp.setRadius(20);
        btn_submitSignUp.setColorClick(YellowColorClick);
        btn_submitSignUp.setBorderColor(mainColorWhiteBG);
        btn_submitSignUp.setColorOver(YellowColorOver);
        btn_submitSignUp.setForeground(mainColorWhiteBG);
        btn_submitSignUp.setBorder(null);
        btn_submitSignUp.setFocusable(false);
        btn_submitSignUp.setFont(ArialBold);
        signupButtonPanel.add(btn_submitSignUp, BorderLayout.SOUTH);
        
        return registerPanel;
    }

    public void Login(){

    }
}
