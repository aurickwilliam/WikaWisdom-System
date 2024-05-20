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
        setVisible(true);

        JPanel mainBackground = new JPanel();
        mainBackground.setLayout(new CardLayout());
        mainBackground.setBackground(mainColorDarkGreen);

        JPanel registerPanel = Register();
        mainBackground.add(registerPanel, "REGISTER");

        this.add(mainBackground);
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
        FormPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        regPanel.add(FormPanel);

        JLabel SignUpTitle = new JLabel("Sign Up");
        SignUpTitle.setForeground(mainColorBlackTxt);
        SignUpTitle.setFont(ArialBold);
        SignUpTitle.setAlignmentX(LEFT_ALIGNMENT);
        FormPanel.add(SignUpTitle);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(mainColorBlackTxt);
        emailLabel.setFont(Arial);
        emailLabel.setAlignmentX(LEFT_ALIGNMENT);
        emailLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        FormPanel.add(emailLabel);


        
        return registerPanel;
    }

    public void Login(){

    }
}
