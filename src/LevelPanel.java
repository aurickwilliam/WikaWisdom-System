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

public class LevelPanel extends JPanel implements ActionListener {
    Assets assets = new Assets();
    // Layout
    private static CardLayout levelCardLayout, lessonCardLayout;

    // Strings
    private String currentCard = "";
    private String previousCard = "";

    // Buttons
    private JButton btn_back;
    private RoundedButton btn_right, btn_left;

    // Label
    private JLabel title;

    // Panels
    private static JPanel mainLevelPanel;
    private static JPanel mainLevelInProcess;
    private static JPanel lessonPanel;

    public LevelPanel(){
        // TODO: Start this shit
        levelCardLayout = new CardLayout();
        setBackground(assets.getMainColorWhiteBG());
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(levelCardLayout);

        //main level page
        mainLevelPanel = new JPanel();
        mainLevelPanel.setName("LEVEL PAGE");
        mainLevelPanel.setBackground(null);
        currentCard = mainLevelPanel.getName();
        add(mainLevelPanel, mainLevelPanel.getName());

        Header(mainLevelPanel, "Journey Page", "Learn Filipino Language Step by Step in the Journey Page");

        // Hides the back button when it is in option panel
        if (currentCard.equals("LEVEL PAGE")){
            btn_back.setVisible(false);
        }

        JPanel levelPage = levelPage();
        levelPage.setPreferredSize(new Dimension(700, 470));
        mainLevelPanel.add(levelPage);

        // In Process of Level
        mainLevelInProcess = new JPanel();
        mainLevelInProcess.setName("IN PROCESS");
        add(mainLevelInProcess, mainLevelInProcess.getName());

        Header(mainLevelInProcess, "", "");

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btn_right){
            lessonCardLayout.next(lessonPanel);
        }
    }

    public JPanel levelPage(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(null);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(0, 0, 0, 150));
        contentPanel.setBackground(assets.getMainColorWhiteBG());

        // Get the list of category
        String[] levels = getEachLine(assets.getLevel_names());
        contentPanel.setLayout(new GridLayout(levels.length, 1, 20, 20));

        JScrollPane scrollPane = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(null);
        scrollPane.setBackground(null);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        System.out.println(Arrays.toString(levels));
        for (int i = 0; i < levels.length; i++) {
            String name = levels[i].split(",")[0];
            int isComplete = Integer.parseInt(levels[i].split(",")[1]);

            JButton level = new Level(name, i + 1, isComplete);
            level.addActionListener(e -> {
                System.out.println(name);
                title.setText(name);

                JPanel lessonPanel = new MasterPanel();
                mainLevelInProcess.add(lessonPanel);

                currentCard = mainLevelInProcess.getName();
                levelCardLayout.show(this, currentCard);
            });
            contentPanel.add(level);
        }

        return mainPanel;
    }

    public JPanel levelContent(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(null);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BorderLayout());

        lessonCardLayout = new CardLayout();

        lessonPanel = new JPanel();
        lessonPanel.setBackground(null);
        lessonPanel.setLayout(lessonCardLayout);
        mainPanel.add(lessonPanel, BorderLayout.CENTER);

        // Add panels to the card layout
//        for (int i = 0; i < 3; i++) {
//            JPanel lesson = new LessonPanel(String.valueOf(i));
//            lessonPanel.add(lesson);
//        }

        JPanel navigationPanel = new JPanel();
        navigationPanel.setBackground(null);
        navigationPanel.setLayout(new BorderLayout());
        navigationPanel.setPreferredSize(new Dimension(0, 100));
        mainPanel.add(navigationPanel, BorderLayout.SOUTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));
        leftPanel.setBackground(null);
        leftPanel.setPreferredSize(new Dimension(70, 0));
        leftPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
        navigationPanel.add(leftPanel, BorderLayout.WEST);

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
        navigationPanel.add(rightPanel, BorderLayout.EAST);

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
        btn_right.addActionListener(this);
        rightPanel.add(btn_right);


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

        title = new JLabel(titleString);
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
            if (currentCard.equals("IN PROCESS")){
                previousCard = mainLevelPanel.getName();
            }

            currentCard = previousCard;
            levelCardLayout.show(this, previousCard);

        });
        backBtnPanel.add(btn_back, BorderLayout.CENTER);
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

    public static CardLayout getLevelCardLayout() {
        return levelCardLayout;
    }

    public static JPanel getMainLevelPanel() {
        return mainLevelPanel;
    }
}
