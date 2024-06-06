import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Profile extends JPanel {
    Assets assets = new Assets();

    public static RoundedButton btn_logout;

    public Profile(String username){
        setBackground(assets.getMainColorWhiteBG());
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(new BorderLayout());

        String[] records = getUserInfo(username);
        String email = records[0];
        String pass = records[1];
        String name = records[2];

        JPanel header = accountBar(name);
        add(header, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(assets.getMainColorWhiteBG());
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        add(infoPanel, BorderLayout.CENTER);

        JLabel title = new JLabel();
        title.setText("Personal Information: ");
        title.setFont(assets.getArialBold());
        title.setForeground(assets.getMainColorBlackTxt());
        infoPanel.add(title, BorderLayout.NORTH);

        JPanel personalInfo = new JPanel();
        personalInfo.setBackground(null);
        personalInfo.setLayout(new BorderLayout());
        infoPanel.add(personalInfo, BorderLayout.CENTER);

        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(null);
        tempPanel.setLayout(new BorderLayout());
        tempPanel.setBorder(new EmptyBorder(20, 30, 0, 0));
        personalInfo.add(tempPanel, BorderLayout.NORTH);

        JLabel emailLabel = new JLabel();
        emailLabel.setText("● Email Address: " + email);
        emailLabel.setFont(assets.getArial());
        emailLabel.setForeground(assets.getMainColorBlackTxt());
        tempPanel.add(emailLabel, BorderLayout.NORTH);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("● Password: " + pass);
        passwordLabel.setFont(assets.getArial());
        passwordLabel.setForeground(assets.getMainColorBlackTxt());
        tempPanel.add(passwordLabel, BorderLayout.SOUTH);

        JPanel logOutPanel = new JPanel();
        logOutPanel.setBackground(null);
        logOutPanel.setLayout(new BorderLayout());
        logOutPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        logOutPanel.setPreferredSize(new Dimension(0, 60));
        infoPanel.add(logOutPanel, BorderLayout.SOUTH);

        btn_logout = new RoundedButton();
        btn_logout.setText("Log Out");
        btn_logout.setBorder(null);
        btn_logout.setFocusable(false);
        btn_logout.setRadius(15);
        btn_logout.setFont(assets.getArialBold());
        btn_logout.setForeground(assets.getMainColorWhithy());
        btn_logout.setBorder(new EmptyBorder(20, 20, 20, 20));
        btn_logout.setColor(assets.getMainColorYellowBG());
        btn_logout.setColorOver(assets.getYellowColorOver());
        btn_logout.setColorClick(assets.getYellowColorClick());
        btn_logout.setBorderColor(assets.getMainColorYellowBG());
        logOutPanel.add(btn_logout, BorderLayout.EAST);
    }

    public JPanel accountBar(String name){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(null);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(0, 100));

        RoundedPanel accountPanel = new RoundedPanel(20, 20, 20, 20);
        accountPanel.setBackground(assets.getMainColorDarkGreen());
        accountPanel.setLayout(new BorderLayout());
        accountPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.add(accountPanel, BorderLayout.CENTER);

        JLabel user_name = new JLabel();
        user_name.setText(name);
        user_name.setForeground(assets.getMainColorWhithy());
        user_name.setFont(assets.getArialBoldTitle());
        user_name.setHorizontalAlignment(JLabel.LEFT);
        Image iconImage = assets.getWhiteProfileIcon().getImage();
        Image resizeIcon = iconImage.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon ProfileIcon = new ImageIcon(resizeIcon);
        user_name.setIcon(ProfileIcon);
        accountPanel.add(user_name, BorderLayout.CENTER);

        return mainPanel;
    }

    public String[] getUserInfo(String name){
        String[] info = new String[3];
        try {
            FileReader filePath = new FileReader(assets.getUsersFilePath());
            BufferedReader reader = new BufferedReader(filePath);
            String line;
            String[] record = null;
            while ((line = reader.readLine()) != null) {
                record = line.split(",");
                if (record[2].equals(name)){
                    info = record;
                    break;
                }
            }
            reader.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error Reading Data!",
                    "Reading Records Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return info;
    }

    public static RoundedButton getBtn_logout() {
        return btn_logout;
    }
}
