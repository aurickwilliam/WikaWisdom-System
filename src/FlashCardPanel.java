import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlashCardPanel extends JPanel implements ActionListener {
    Assets assets = new Assets();

    // Layout
    private static CardLayout flashCardLayout;
    private static CardLayout cardPanelLayout;

    // Strings
    private String currentCard = "";
    private String previousCard = "";
    private String[] items_fc = new String[0];
    private String filWord = "";
    private String engWord = "";

    private int index = 0;

    // Labels
    private JLabel categoryLabel;

    // JButtons
    private JButton btn_back;

    // Rounded Buttons
    private static RoundedButton btn_left, btn_right, btn_filCard, btn_engCard,btn_done, btn_goBack;

    // Panels
    private static JPanel mainCategoryPanel;
    private static JPanel mainProcessPanel;
    private static JPanel filPanel;
    private static JPanel engPanel;
    private static JPanel cardPanel;
    private static JPanel mainDonePanel;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btn_filCard){
            cardPanelLayout.show(cardPanel, engPanel.getName());
        }else if (actionEvent.getSource() == btn_engCard){
            cardPanelLayout.show(cardPanel, filPanel.getName());
        }

        if (actionEvent.getSource() == btn_left){
            index--;
            filWord = items_fc[index].split("\\|")[0];
            engWord = items_fc[index].split("\\|")[1];
            cardPanelLayout.show(cardPanel, filPanel.getName());
            btn_filCard.setText("<html><center>" + filWord + "</center></html>");
            btn_engCard.setText("<html><center>" + engWord + "</center></html>");

            if (index == 0){
                btn_left.setVisible(false);
            }

            if(index < 9){
                btn_right.setVisible(true);
                btn_done.setVisible(false);
            }
            System.out.println("LEFT: " + index);
        }else if (actionEvent.getSource() == btn_right){
            index++;
            filWord = items_fc[index].split("\\|")[0];
            engWord = items_fc[index].split("\\|")[1];
            cardPanelLayout.show(cardPanel, filPanel.getName());
            btn_filCard.setText("<html><center>" + filWord + "</center></html>");
            btn_engCard.setText("<html><center>" + engWord + "</center></html>");

            if (index > 0){
                btn_left.setVisible(true);
            }

            if (index == 9){
                btn_right.setVisible(false);
                btn_done.setVisible(true);
            }
            System.out.println("RIGHT: " + index);
        }

        if (actionEvent.getSource() == btn_done){
            System.out.println("DONE");
            currentCard = mainDonePanel.getName();

            if (currentCard.equals("DONE")){
                btn_back.setVisible(false);
            }
            flashCardLayout.show(this, currentCard);
        }

        if (actionEvent.getSource() == btn_goBack){
            btn_left.removeActionListener(this);
            btn_right.removeActionListener(this);

            currentCard = mainCategoryPanel.getName();
            flashCardLayout.show(this, currentCard);
        }
    }

    public FlashCardPanel(){
        flashCardLayout = new CardLayout();
        setLayout(flashCardLayout);
        setBackground(assets.getMainColorWhiteBG());
        setBorder(new EmptyBorder(20, 20, 20, 20));

        // mainCategoryPanel
        mainCategoryPanel = new JPanel();
        mainCategoryPanel.setName("CATEGORY");
        currentCard = mainCategoryPanel.getName();
        add(mainCategoryPanel, mainCategoryPanel.getName());

        Header(mainCategoryPanel, "Flash Card", "Categories");

        // Hides the back button when it is in option panel
        if (currentCard.equals("CATEGORY")){
            btn_back.setVisible(false);
        }

        JPanel categoryPanel = categoryPanel();
        categoryPanel.setPreferredSize(new Dimension(700, 470));
        mainCategoryPanel.add(categoryPanel);

        // In Process of Flash Card
        mainProcessPanel = new JPanel();
        mainProcessPanel.setName("IN PROCESS");
        add(mainProcessPanel, mainProcessPanel.getName());

        Header(mainProcessPanel, "Flash Card", "Try and Memorize!");

        JPanel inProcessPanel = CardInProcess();
        inProcessPanel.setPreferredSize(new Dimension(700, 470));
        mainProcessPanel.add(inProcessPanel);

        // Done of Flash Card
        mainDonePanel = new JPanel();
        mainDonePanel.setName("DONE");
        add(mainDonePanel, mainDonePanel.getName());

        Header(mainDonePanel, "Flash Card", "Excellent");

        JPanel donePanel = CardDone();
        donePanel.setPreferredSize(new Dimension(700, 470));
        mainDonePanel.add(donePanel);

    }

    public JPanel categoryPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(null);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(0, 0, 0, 250));
        contentPanel.setBackground(assets.getMainColorWhiteBG());

        // Get the list of category
        String[] categories = getEachLine(assets.getFlashCardCategories());
        contentPanel.setLayout(new GridLayout(categories.length, 1, 20, 20));
        
        JScrollPane scrollPane = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(null);
        scrollPane.setBackground(null);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        for (int i = 0; i < categories.length; i++) {
            JButton category = new FlashCardCategory(categories[i]);
            category.addActionListener(e -> {
                categoryLabel.setText(category.getText());
                String filePath = getFilePath(category.getText());
                System.out.println(category.getText());
                items_fc = getEachLine(filePath);

                // Shuffle the array using Collections Class
                List<String> shuffled_items = Arrays.asList(items_fc);
                Collections.shuffle(shuffled_items);
                shuffled_items.toArray(items_fc);

                btn_left.removeActionListener(this);
                btn_right.removeActionListener(this);

                index = 0;

                System.out.println(Arrays.toString(items_fc));
                System.out.println("Initial: " + index);
                filWord = items_fc[index].split("\\|")[0];
                engWord = items_fc[index].split("\\|")[1];

                btn_filCard.setText("<html><center>" + filWord + "</center></html>");
                btn_engCard.setText("<html><center>" + engWord + "</center></html>");

                if (index == 0){
                    btn_left.setVisible(false);
                }else if (index > 0){
                    btn_left.setVisible(true);
                }

                btn_left.addActionListener(this);
                btn_right.addActionListener(this);

                if (index < 9){
                    btn_done.setVisible(false);
                    btn_right.setVisible(true);
                }

                currentCard = mainProcessPanel.getName();
                flashCardLayout.show(this, currentCard);
            });
            contentPanel.add(category);
        }

        return mainPanel;
    }

    public JPanel CardInProcess(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(null);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(50, 50, 50, 50));

        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new BorderLayout());
        categoryPanel.setBackground(null);
        mainPanel.add(categoryPanel, BorderLayout.NORTH);

        categoryLabel = new JLabel();
        categoryLabel.setFont(assets.getArialTitle());
        categoryLabel.setForeground(assets.getMainColorBlackTxt());
        categoryLabel.setHorizontalAlignment(JLabel.CENTER);
        categoryPanel.add(categoryLabel, BorderLayout.CENTER);

        cardPanelLayout = new CardLayout();

        cardPanel = new JPanel();
        cardPanel.setBackground(null);
        cardPanel.setLayout(cardPanelLayout);
        cardPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.add(cardPanel, BorderLayout.CENTER);

        filPanel = new JPanel();
        filPanel.setName("FIL");
        filPanel.setLayout(new BorderLayout());
        cardPanelLayout.show(cardPanel, filPanel.getName());
        cardPanel.add(filPanel, filPanel.getName());

        btn_filCard = new RoundedButton();
        btn_filCard.setText("FILIPINO");
        btn_filCard.setRadius(20);
        btn_filCard.setColor(assets.getMainColorDarkGreen());
        btn_filCard.setColorOver(assets.getDarkGreenColorOver());
        btn_filCard.setColorClick(assets.getDarkGreenColorClick());
        btn_filCard.setBorderColor(assets.getMainColorDarkGreen());
        btn_filCard.addActionListener(this);
        btn_filCard.setFocusable(false);
        btn_filCard.setForeground(assets.getMainColorWhithy());
        btn_filCard.setFont(assets.getArialBold());
        btn_filCard.setHorizontalAlignment(JButton.CENTER);
        btn_filCard.setBorder(null);
        btn_filCard.setBorder(new EmptyBorder(15, 15, 15, 15));
        filPanel.add(btn_filCard, BorderLayout.CENTER);

        engPanel = new JPanel();
        engPanel.setName("ENG");
        engPanel.setLayout(new BorderLayout());
        cardPanel.add(engPanel, engPanel.getName());

        btn_engCard = new RoundedButton();
        btn_engCard.setText("ENGLISH");
        btn_engCard.setRadius(20);
        btn_engCard.setColor(assets.getMainColorYellowBG());
        btn_engCard.setColorOver(assets.getYellowColorOver());
        btn_engCard.setColorClick(assets.getYellowColorClick());
        btn_engCard.setBorderColor(assets.getMainColorYellowBG());
        btn_engCard.addActionListener(this);
        btn_engCard.setFocusable(false);
        btn_engCard.setForeground(assets.getMainColorWhithy());
        btn_engCard.setFont(assets.getArialBold());
        btn_engCard.setHorizontalAlignment(JButton.CENTER);
        btn_engCard.setBorder(null);
        btn_engCard.setBorder(new EmptyBorder(15, 15, 15, 15));
        engPanel.add(btn_engCard, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));
        leftPanel.setBackground(null);
        leftPanel.setPreferredSize(new Dimension(70, 0));
        leftPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
        mainPanel.add(leftPanel, BorderLayout.WEST);

        btn_left = new RoundedButton();
        Image LefticonImage = assets.getLeftIcon().getImage();
        Image LeftresizeIcon = LefticonImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon Lefticon = new ImageIcon(LeftresizeIcon);
        btn_left.setRadius(15);
        btn_left.setIcon(Lefticon);
        btn_left.setFocusable(false);;
        btn_left.setBorder(null);
        btn_left.setBorder(new EmptyBorder(5, 5, 5, 5));
        btn_left.setBorderColor(assets.getMainColorYellowBG());
        btn_left.setColorOver(assets.getYellowColorOver());
        btn_left.setColorClick(assets.getYellowColorClick());
        btn_left.setColor(assets.getMainColorYellowBG());
        leftPanel.add(btn_left);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));
        rightPanel.setPreferredSize(new Dimension(70, 0));
        rightPanel.setBackground(null);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        btn_right = new RoundedButton();
        Image RighticonImage = assets.getRightIcon().getImage();
        Image RightresizeIcon = RighticonImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon Righticon = new ImageIcon(RightresizeIcon);
        btn_right.setRadius(15);
        btn_right.setIcon(Righticon);
        btn_right.setFocusable(false);;
        btn_right.setBorder(null);
        btn_right.setBorder(new EmptyBorder(5, 5, 5, 5));
        btn_right.setBorderColor(assets.getMainColorYellowBG());
        btn_right.setColorOver(assets.getYellowColorOver());
        btn_right.setColorClick(assets.getYellowColorClick());
        btn_right.setColor(assets.getMainColorYellowBG());
        rightPanel.add(btn_right);

        JPanel donePanel = new JPanel();
        donePanel.setBackground(null);
        donePanel.setLayout(new BoxLayout(donePanel, BoxLayout.Y_AXIS));
        donePanel.setPreferredSize(new Dimension(0, 70));
        mainPanel.add(donePanel, BorderLayout.SOUTH);

        btn_done = new RoundedButton();
        btn_done.setText("DONE");
        btn_done.setRadius(15);
        btn_done.setFont(assets.getArial());
        btn_done.setFocusable(false);
        btn_done.setColor(assets.getMainColorDarkGreen());
        btn_done.setColorClick(assets.getDarkGreenColorClick());
        btn_done.setColorOver(assets.getDarkGreenColorOver());
        btn_done.setBorderColor(assets.getMainColorDarkGreen());
        btn_done.setForeground(assets.getMainColorWhithy());
        btn_done.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn_done.setBorder(null);
        btn_done.setHorizontalAlignment(JButton.CENTER);
        btn_done.addActionListener(this);
        btn_done.setBorder(new EmptyBorder(10, 10, 10, 10));
        donePanel.add(btn_done);

        return mainPanel;
    }

    public JPanel CardDone(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(null);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(100, 150, 100, 150));

        RoundedPanel contentPanel = new RoundedPanel(20, 20, 20, 20);
        contentPanel.setBackground(assets.getMainColorDarkGreen());
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JPanel greetingsPanel = new JPanel();
        greetingsPanel.setBackground(null);
        greetingsPanel.setBorder(new EmptyBorder(30, 0, 0, 0));
        greetingsPanel.setLayout(new BorderLayout());
        contentPanel.add(greetingsPanel, BorderLayout.NORTH);

        JLabel greetings = new JLabel("Good Job!");
        greetings.setFont(assets.getArialBoldTitle());
        greetings.setForeground(assets.getMainColorWhithy());
        greetings.setHorizontalAlignment(JLabel.CENTER);
        greetingsPanel.add(greetings, BorderLayout.CENTER);

        JPanel goBackPanel = new JPanel();
        goBackPanel.setBackground(null);
        goBackPanel.setBorder(new EmptyBorder(50, 70, 50, 70));
        goBackPanel.setLayout(new BorderLayout());
        contentPanel.add(goBackPanel, BorderLayout.CENTER);

        btn_goBack = new RoundedButton();
        btn_goBack.setText("Go Back");
        btn_goBack.setRadius(15);
        btn_goBack.setFont(assets.getArialBold());
        btn_goBack.setColor(assets.getMainColorYellowBG());
        btn_goBack.setForeground(assets.getMainColorWhithy());
        btn_goBack.setColorOver(assets.getYellowColorOver());
        btn_goBack.setColorClick(assets.getYellowColorClick());
        btn_goBack.setBorder(null);
        btn_goBack.setBorderColor(assets.getMainColorYellowBG());
        btn_goBack.setPreferredSize(new Dimension(100, 40));
        btn_goBack.setFocusable(false);
        btn_goBack.addActionListener(this);
        goBackPanel.add(btn_goBack, BorderLayout.CENTER);

        return mainPanel;
    }

    public void Header(JPanel parent, String titleString, String descString){
        // Title Bar
        JPanel headerPanel = new RoundedPanel(20, 20, 20, 20);
        headerPanel.setBackground(assets.getMainColorDarkGreen());
        headerPanel.setPreferredSize(new Dimension(700, 100));
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        parent.add(headerPanel);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(null);
        headerPanel.add(titlePanel, BorderLayout.CENTER);

        JLabel title = new JLabel(titleString);
        title.setFont(assets.getArialBoldTitle());
        title.setForeground(assets.getMainColorWhiteBG());
        titlePanel.add(title);

        JLabel descriptionTitle = new JLabel(descString);
        descriptionTitle.setFont(assets.getArial_desc());
        descriptionTitle.setForeground(assets.getMainColorWhiteBG());
        descriptionTitle.setBorder(new EmptyBorder(5, 0, 0, 0));
        titlePanel.add(descriptionTitle);

        JPanel backBtnPanel = new JPanel();
        backBtnPanel.setBackground(null);
        backBtnPanel.setLayout(new BorderLayout());
        headerPanel.add(backBtnPanel, BorderLayout.EAST);

        btn_back = new JButton();
        Image iconImage = assets.getBackBtn().getImage();
        Image resizeIcon = iconImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon BackIcon = new ImageIcon(resizeIcon);
        btn_back.setIcon(BackIcon);
        btn_back.setBackground(null);
        btn_back.setFocusable(false);
        btn_back.setBorder(null);

        btn_back.addActionListener(e -> {
            //If-else for back btn
            int response = 3;
            if (currentCard.equals("IN PROCESS")){
                response = JOptionPane.showConfirmDialog(null,
                        "Do you want to go back?\nYou will lose your progress in this flash card!",
                        "Confirm Message", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION){
                    previousCard = mainCategoryPanel.getName();
                    index = 0;
                    System.out.println("BACK: " + index);
                    cardPanelLayout.show(cardPanel, filPanel.getName());
                    btn_left.removeActionListener(this);
                    btn_right.removeActionListener(this);

                    currentCard = previousCard;
                    flashCardLayout.show(this, previousCard);
                }
            }

        });
        backBtnPanel.add(btn_back, BorderLayout.CENTER);
    }

    public String getFilePath(String name){
        return switch (name) {
            case "Foods" -> assets.getFoods_FC();
            case "Time/Numbers" -> assets.getNumbers_FC();
            case "Transportation" -> assets.getTransportation_FC();
            case "Money" -> assets.getMoney_FC();
            case "Greetings/Introduction" -> assets.getGreetings_FC();
            case "Describe People" -> assets.getDescPeople_FC();
            default -> null;
        };
    }

    public String[] getEachLine(String filePath){
        try{
            FileReader file = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(file);
            ArrayList<String> list = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null){
                list.add(line);
            }
            reader.close();
            return list.toArray(new String[list.size()]);
        }catch (IOException exception){
            JOptionPane.showMessageDialog(this,
                    "Error Reading File!",
                    "Reading File",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static CardLayout getFlashCardLayout() {
        return flashCardLayout;
    }

    public static JPanel getMainCategoryPanel() {
        return mainCategoryPanel;
    }

}
