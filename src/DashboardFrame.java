import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardFrame extends JFrame implements ActionListener {
    Assets assets = new Assets();

    // Side Panel Buttons
    private RoundedButton btn_dictionary, btn_flashCard, btn_Level;

    // Layout
    private CardLayout mainPanelCardLayout;

    // Panel
    private JPanel mainPanel, flashCard, level, dictionary;

    // Label
    private JLabel accountTitle;

    public DashboardFrame(String user_name){
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("WikaWisdom");
        setLocationRelativeTo(null);
        setIconImage(assets.getWikaLogo().getImage());
        setResizable(false);

        JPanel mainBackground = new JPanel();
        mainBackground.setBackground(assets.getMainColorWhiteBG());
        mainBackground.setLayout(new BorderLayout());
        this.add(mainBackground);

        RoundedPanel sidePanel = sidePanel(user_name);
        mainBackground.add(sidePanel, BorderLayout.WEST);

        mainPanelCardLayout = new CardLayout();
        mainPanel = new JPanel();
        mainPanel.setBackground(assets.getMainColorWhiteBG());
        mainPanel.setLayout(mainPanelCardLayout);
        mainBackground.add(mainPanel, BorderLayout.CENTER);

        dictionary = new DictionaryPanel();
        mainPanel.add(dictionary, "DICTIONARY");

        flashCard = new FlashCardPanel();
        mainPanel.add(flashCard, "FLASHCARD");

        level = new LevelPanel();
        mainPanel.add(level, "LEVEL");

        mainPanelCardLayout.show(mainPanel, "LEVEL");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btn_dictionary){
            System.out.println("Click Dictionary");
            DictionaryPanel.getDictionaryCardLayout().show(dictionary, DictionaryPanel.getMainOptionPanel().getName());
            mainPanelCardLayout.show(mainPanel, "DICTIONARY");
        }else if (actionEvent.getSource() == btn_flashCard){
            System.out.println("Click FlashCard");
            FlashCardPanel.getFlashCardLayout().show(flashCard, FlashCardPanel.getMainCategoryPanel().getName());
            mainPanelCardLayout.show(mainPanel, "FLASHCARD");
        }else if (actionEvent.getSource() == btn_Level){
            System.out.println("Click Level");
            LevelPanel.getLevelCardLayout().show(level, LevelPanel.getMainLevelPanel().getName());
            mainPanelCardLayout.show(mainPanel, "LEVEL");
        }
    }


    public RoundedPanel sidePanel(String user_name){
        RoundedPanel sidePanel = new RoundedPanel(0, 20, 20, 0);
        sidePanel.setPreferredSize(new Dimension( 250, sidePanel.getHeight()));
        sidePanel.setBackground(assets.getMainColorDarkGreen());

        // Panel for Account
        JPanel accountTitlePanel = new JPanel();
        accountTitlePanel.setBackground(null);
        accountTitlePanel.setLayout(new BorderLayout());
        accountTitlePanel.setPreferredSize(new Dimension(240, 80));
        accountTitlePanel.setBorder(new EmptyBorder(0, 20, 0, 20));
        sidePanel.add(accountTitlePanel);

        accountTitle = new JLabel(user_name);
        accountTitle.setFont(assets.getArialBold());
        Image iconImage = assets.getWhiteProfileIcon().getImage();
        Image resizeIcon = iconImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon ProfileIcon = new ImageIcon(resizeIcon);
        accountTitle.setIcon(ProfileIcon);
        accountTitle.setForeground(assets.getMainColorWhithy());
        accountTitle.setHorizontalAlignment(JLabel.LEFT);
        accountTitlePanel.add(accountTitle, BorderLayout.CENTER);


        // Buttons
        JPanel button1Panel = new JPanel();
        button1Panel.setBackground(null);
        button1Panel.setBorder(new EmptyBorder(30, 0, 10, 0));
        sidePanel.add(button1Panel);

        btn_dictionary = new RoundedButton();
        btn_dictionary.setText("Dictionary");
        btn_dictionary.setFocusable(false);
        btn_dictionary.setForeground(assets.getMainColorWhithy());
        btn_dictionary.setFont(assets.getArialBold());
        btn_dictionary.setColor(assets.getMainColorDarkGreen());
        btn_dictionary.setBorder(null);
        btn_dictionary.setRadius(10);
        btn_dictionary.setPreferredSize(new Dimension(200, 50));
        btn_dictionary.setColorClick(assets.getDarkGreenColorClick());
        btn_dictionary.setBorderColor(assets.getMainColorWhithy());
        btn_dictionary.setColorOver(assets.getDarkGreenColorOver());
        Image dicImage = assets.getBookIcon().getImage();
        Image resizeDic = dicImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon DictionaryIcon = new ImageIcon(resizeDic);
        btn_dictionary.setIcon(DictionaryIcon);
        btn_dictionary.setHorizontalAlignment(JButton.LEFT);
        btn_dictionary.setBorder(new EmptyBorder(0, 10, 0, 0));
        btn_dictionary.addActionListener(this);
        button1Panel.add(btn_dictionary);

        JPanel button2Panel = new JPanel();
        button2Panel.setBackground(null);
        button2Panel.setBorder(new EmptyBorder(10, 0, 10, 0));
        sidePanel.add(button2Panel);

        btn_flashCard = new RoundedButton();
        btn_flashCard.setText("Flash Cards");
        btn_flashCard.setFocusable(false);
        btn_flashCard.setForeground(assets.getMainColorWhithy());
        btn_flashCard.setFont(assets.getArialBold());
        btn_flashCard.setColor(assets.getMainColorDarkGreen());
        btn_flashCard.setBorder(null);
        btn_flashCard.setRadius(10);
        btn_flashCard.setPreferredSize(new Dimension(200, 50));
        btn_flashCard.setColorClick(assets.getDarkGreenColorClick());
        btn_flashCard.setBorderColor(assets.getMainColorWhithy());
        btn_flashCard.setColorOver(assets.getDarkGreenColorOver());
        Image cardsImage = assets.getFlashCardIcon().getImage();
        Image resizeCards = cardsImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon FlashCardIcon = new ImageIcon(resizeCards);
        btn_flashCard.setIcon(FlashCardIcon);
        btn_flashCard.setHorizontalAlignment(JButton.LEFT);
        btn_flashCard.setBorder(new EmptyBorder(0, 10, 0, 0));
        btn_flashCard.addActionListener(this);
        button2Panel.add(btn_flashCard);

        JPanel button3Panel = new JPanel();
        button3Panel.setBackground(null);
        button3Panel.setBorder(new EmptyBorder(10, 0, 10, 0));
        sidePanel.add(button3Panel);

        btn_Level = new RoundedButton();
        btn_Level.setText("Level");
        btn_Level.setFocusable(false);
        btn_Level.setForeground(assets.getMainColorWhithy());
        btn_Level.setFont(assets.getArialBold());
        btn_Level.setColor(assets.getMainColorDarkGreen());
        btn_Level.setBorder(null);
        btn_Level.setRadius(10);
        btn_Level.setPreferredSize(new Dimension(200, 50));
        btn_Level.setColorClick(assets.getDarkGreenColorClick());
        btn_Level.setBorderColor(assets.getMainColorWhithy());
        btn_Level.setColorOver(assets.getDarkGreenColorOver());
        Image levelImage = assets.getLevelIcon().getImage();
        Image resizeLevel = levelImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon LevelIcon = new ImageIcon(resizeLevel);
        btn_Level.setIcon(LevelIcon);
        btn_Level.setHorizontalAlignment(JButton.LEFT);
        btn_Level.setBorder(new EmptyBorder(0, 10, 0, 0));
        btn_Level.addActionListener(this);
        button3Panel.add(btn_Level);

        return sidePanel;
    }

}
