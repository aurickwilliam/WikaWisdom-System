import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LevelPanel extends JPanel implements ActionListener {
    Assets assets = new Assets();
    // Layout
    private static CardLayout levelCardLayout, lessonCardLayout;

    // Strings
    private String currentCard = "";
    private String previousCard = "";
    public static boolean isCompleted = false;

    // Buttons
    private JButton btn_back;

    // Label
    private static JLabel title, descriptionTitle;

    // Panels
    private static JPanel mainLevelPanel;
    private static JPanel mainLevelInProcess;
    private static JPanel lessonPanel;
    private static JPanel levelContent;

    public LevelPanel(){
        levelCardLayout = new CardLayout();

        setBackground(assets.getMainColorWhiteBG());
        setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setLayout(levelCardLayout);

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
        mainLevelInProcess.setBackground(null);
        add(mainLevelInProcess, mainLevelInProcess.getName());

        Header(mainLevelInProcess, "", "");

        levelContent = new JPanel();
        levelContent.setBackground(null);
        levelContent.setLayout(new BorderLayout());
        levelContent.setPreferredSize(new Dimension(700, 470));
        mainLevelInProcess.add(levelContent);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

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
            String score = levels[i].split(",")[2];

            JButton level = new Level(name, i + 1, isComplete, score);
            level.addActionListener(e -> {
                System.out.println(name);
                title.setText(name);

                // Disable the sidebar
                DashboardFrame.getBtn_dictionary().setEnabled(false);
                DashboardFrame.getBtn_flashCard().setEnabled(false);
                DashboardFrame.getBtn_Level().setEnabled(false);
                DashboardFrame.getAccountTitle().setEnabled(false);

                if (name.equals("Level 0:Novice")){
                    JPanel lessonPanel = new NovicePanel();
                    System.out.println("NOVICE");
                    levelContent.add(lessonPanel);
                }else if (name.equals("Level 1:Beginner")){
                    JPanel lessonPanel = new BeginnerPanel();
                    System.out.println("BEGINNER");
                    levelContent.add(lessonPanel);
                }else if (name.equals("Level 2:Apprentice")){
                    JPanel lessonPanel = new ApprenticePanel();
                    System.out.println("APPRENTICE");
                    levelContent.add(lessonPanel);
                }else if (name.equals("Level 3:Intermediate")){
                    JPanel lessonPanel = new IntermediatePanel();
                    System.out.println("INTERMEDIATE");
                    levelContent.add(lessonPanel);
                }else if (name.equals("Level 4:Adept")){
                    JPanel lessonPanel = new AdeptPanel();
                    System.out.println("ADEPT");
                    levelContent.add(lessonPanel);
                }else if (name.equals("Level 5:Skilled")){
                    JPanel lessonPanel = new SkilledPanel();
                    System.out.println("SKILLED");
                    levelContent.add(lessonPanel);
                }else if (name.equals("Level 6:Advanced")){
                    JPanel lessonPanel = new AdvancedPanel();
                    System.out.println("ADVANCED");
                    levelContent.add(lessonPanel);
                }else if (name.equals("Level 7:Expert")){
                    JPanel lessonPanel = new ExpertPanel();
                    System.out.println("EXPERT");
                    levelContent.add(lessonPanel);
                }else if (name.equals("Level 8:Master")){
                    JPanel lessonPanel = new MasterPanel();
                    System.out.println("MASTER");
                    levelContent.add(lessonPanel);
                }else if (name.equals("Level 9:Natural Filipino")){
                    JPanel lessonPanel = new Natural_FilipinoPanel();
                    System.out.println("FILIPINO");
                    levelContent.add(lessonPanel);
                }

                currentCard = mainLevelInProcess.getName();
                levelCardLayout.show(this, currentCard);
            });
            contentPanel.add(level);
        }

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

        descriptionTitle = new JLabel(descString);
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
            String mess = "";
            if (currentCard.equals("IN PROCESS")){
                if (isCompleted){
                    mess = "Level Completed";
                }else {
                    mess = "Do you want to go back?\nYou will lose your progress in this Level!";
                }
                response = JOptionPane.showConfirmDialog(null,
                        mess,
                        "Confirm Message", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION){
                    previousCard = mainLevelPanel.getName();
                    levelContent.removeAll();

                    // Enable the sidebar
                    DashboardFrame.getBtn_dictionary().setEnabled(true);
                    DashboardFrame.getBtn_flashCard().setEnabled(true);
                    DashboardFrame.getBtn_Level().setEnabled(true);
                    DashboardFrame.getAccountTitle().setEnabled(true);

                    currentCard = previousCard;
                    levelCardLayout.show(this, currentCard);
                }
            }

        });
        backBtnPanel.add(btn_back, BorderLayout.CENTER);
    }

    public void insertNewScore(String filePath, String score, int target_line){
        try{
            FileReader file = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(file);
            ArrayList<String> list = new ArrayList<>();
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null){
                if (index == target_line){
                    String[] record = line.split(",");
                    record[2] = "Score: " + score + "/10";
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

                }
            }
            reader.close();

        }catch (IOException exception){
            JOptionPane.showMessageDialog(this,
                    "Error Reading File!",
                    "Reading File",
                    JOptionPane.ERROR_MESSAGE);
        }
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

    public static JPanel getLevelContent() {
        return levelContent;
    }

    public static JLabel getDescriptionTitle() {
        return descriptionTitle;
    }

    public static JLabel getTitle() {
        return title;
    }
}
