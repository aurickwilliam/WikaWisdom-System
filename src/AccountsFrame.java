import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AccountsFrame extends JFrame {
    Assets assets = new Assets();

    // Buttons
    private RoundedButton account;

    public AccountsFrame(){
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("WikaWisdom");
        setLocationRelativeTo(null);
        setIconImage(assets.getWikaLogo().getImage());
        setResizable(false);

        JPanel mainBackground = new JPanel();
        mainBackground.setBackground(assets.getMainColorDarkGreen());
        mainBackground.setLayout(new BorderLayout());

        JPanel mainPanel = listOfAccounts();
        mainBackground.add(mainPanel, BorderLayout.CENTER);

        this.add(mainBackground);
        setVisible(true);
    }

    public JPanel listOfAccounts(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(125, 300, 125, 300));
        mainPanel.setBackground(null);

        JPanel listPanel = new JPanel();
        listPanel.setBackground(null);
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        mainPanel.add(listPanel);

        JPanel accountTitlePanel = new JPanel();
        accountTitlePanel.setLayout(new BorderLayout());
        accountTitlePanel.setBackground(null);
        accountTitlePanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        listPanel.add(accountTitlePanel);

        JLabel accountTitle = new JLabel("Choose an Account:", SwingConstants.CENTER);
        accountTitle.setForeground(assets.getMainColorWhithy());
        accountTitle.setFont(assets.getArialTitle());
        accountTitle.setVerticalTextPosition(JLabel.CENTER);
        accountTitle.setHorizontalTextPosition(JLabel.CENTER);
        accountTitlePanel.add(accountTitle, BorderLayout.CENTER);

        // Names of each account
        String[] account_names = getListAccountName(assets.getUsersFilePath());

        RoundedPanel listAccountsPanel = new RoundedPanel(20, 20, 20, 20);
        listAccountsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        listAccountsPanel.setLayout(new GridLayout(account_names.length, 1, 20, 20));


        JScrollPane scrollPanel = new JScrollPane(listAccountsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        listPanel.add(scrollPanel);

        JPanel signUpPanel = new JPanel();
        signUpPanel.setLayout(new BorderLayout());
        signUpPanel.setBackground(null);
        signUpPanel.setBorder(new EmptyBorder(20, 50, 20, 50));
        listPanel.add(signUpPanel);

        RoundedButton btn_signUp = new RoundedButton();
        btn_signUp.setText("Register");
        btn_signUp.setRadius(15);
        btn_signUp.setFocusable(false);
        btn_signUp.setColorOver(assets.getYellowColorOver());
        btn_signUp.setColorClick(assets.getYellowColorClick());
        btn_signUp.setBorderColor(assets.getMainColorYellowBG());
        btn_signUp.setBorder(null);
        btn_signUp.setFont(assets.getArialBold());
        btn_signUp.setForeground(assets.getMainColorWhithy());
        btn_signUp.setColor(assets.getMainColorYellowBG());
        btn_signUp.setPreferredSize(new Dimension(0, 40));
        btn_signUp.addActionListener(e -> {
            dispose();
            new LoginRegisterFrame();
        });
        signUpPanel.add(btn_signUp, BorderLayout.CENTER);

        for (String name : account_names){
            JButton account = new AccountPanel(name);
            account.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Click " + account.getText());
                    dispose();
                    new DashboardFrame(account.getText());
                }
            });
            listAccountsPanel.add(account);
        }

        return mainPanel;
    }

    public String[] getListAccountName(String filePath){
        String[] names = new String[0];
        ArrayList<String> temp_names = null;
        try {
            FileReader path = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(path);
            String line;
            temp_names = new ArrayList<>();
            String[] record = null;
            while ((line = reader.readLine()) != null) {
                record = line.split(",");
                temp_names.add(record[2]);
            }
            reader.close();
        }catch (IOException exception){
            JOptionPane.showMessageDialog(this,
                    "Error Reading Data!",
                    "Reading Records Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        names = temp_names.toArray(new String[temp_names.size()]);
        return names;
    }
}
