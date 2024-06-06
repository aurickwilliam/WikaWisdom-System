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

public class AdeptPanel extends JPanel implements ActionListener {
    Assets assets = new Assets();
    // Layout
    private static CardLayout lessonCardLayout, quizCardLayout;

    // Strings
    private String currentCard = "";
    private String previousCard = "";
    private String[] questions = new String[0];
    private int index = 0;
    private int score = 0;
    private String correct_answer = "";
    private JPanel resultPanel, quizMainPanel;

    // Label
    private JLabel questionLabel, greetings, scoreLabel;

    // Buttons
    private RoundedButton btn_right, btn_left, choice1, choice2, choice3, choice4, btn_goBack;

    // Panels
    private static JPanel lessonPanel;
    private static JPanel page1;
    private static JPanel page2;
    private static JPanel page3;
    private static JPanel page4;
    private static JPanel page5;

    public AdeptPanel(){
        setBackground(null);
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(700, 470));

        LevelPanel.getDescriptionTitle().setText("Common Adjectives and Descriptions");
        LevelPanel.isCompleted = false;

        lessonCardLayout = new CardLayout();

        lessonPanel = new JPanel();
        lessonPanel.setBackground(null);
        lessonPanel.setLayout(lessonCardLayout);
        lessonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(lessonPanel, BorderLayout.CENTER);

        page1 = Page1();
        page1.setName("P1");
        lessonPanel.add(page1, page1.getName());

        page2 = Page2();
        page2.setName("P2");
        lessonPanel.add(page2, page2.getName());

        page3 = Page3();
        page3.setName("P3");
        lessonPanel.add(page3, page3.getName());

        page4 = Page4();
        page4.setName("P4");
        lessonPanel.add(page4, page4.getName());

        page5 = Page5();
        page5.setName("P5");
        lessonPanel.add(page5, page5.getName());

        JPanel navigationPanel = NavigationPanel();
        add(navigationPanel, BorderLayout.SOUTH);

        currentCard = page1.getName();

        if (currentCard.equals("P1")){
            btn_left.setVisible(false);
        }
        lessonCardLayout.show(lessonPanel, currentCard);
    }

    public RoundedPanel Page1(){
        RoundedPanel mainPanel = new RoundedPanel(15, 15, 15, 15);
        mainPanel.setBackground(assets.getMainColorDarkGreen());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(null);
        titlePanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JLabel title = new JLabel("Basic Adjectives");
        title.setFont(assets.getArialBold());
        title.setForeground(assets.getMainColorYellowBG());
        title.setHorizontalAlignment(JLabel.LEFT);
        titlePanel.add(title, BorderLayout.CENTER);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(null);
        textPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        mainPanel.add(textPanel, BorderLayout.CENTER);

        JLabel text1 = new JLabel();
        text1.setText("<html><br>• " + "<b>Big:</b> Malaki" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel subPanel = new JPanel();
        subPanel.setBackground(null);
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(subPanel);

        JLabel text2 = new JLabel();
        text2.setText("<html>• " + "<b>Pronounced:</b> /ma-la-kee/" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        subPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>• " + "<b>Small:</b> Maliit" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        textPanel.add(text3);

        JPanel sub2Panel = new JPanel();
        sub2Panel.setBackground(null);
        sub2Panel.setLayout(new BoxLayout(sub2Panel, BoxLayout.Y_AXIS));
        sub2Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub2Panel);

        JLabel text4 = new JLabel();
        text4.setText("<html>• " + "<b>Pronounced:</b> /ma-lee-eet/" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text4);

        JLabel text5 = new JLabel();
        text5.setText("<html><br>• " + "<b>Good:</b> Mabuti" + "</html>");
        text5.setFont(assets.getArial());
        text5.setForeground(assets.getMainColorWhithy());
        textPanel.add(text5);

        JPanel sub3Panel = new JPanel();
        sub3Panel.setBackground(null);
        sub3Panel.setLayout(new BoxLayout(sub3Panel, BoxLayout.Y_AXIS));
        sub3Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub3Panel);

        JLabel text6 = new JLabel();
        text6.setText("<html>• " + "<b>Pronounced:</b> //ma-boo-tee/" + "</html>");
        text6.setFont(assets.getArial());
        text6.setForeground(assets.getMainColorWhithy());
        sub3Panel.add(text6);

        JLabel text7 = new JLabel();
        text7.setText("<html><br>• " + "<b>Bad:</b> Masama" + "</html>");
        text7.setFont(assets.getArial());
        text7.setForeground(assets.getMainColorWhithy());
        textPanel.add(text7);

        JPanel sub4Panel = new JPanel();
        sub4Panel.setBackground(null);
        sub4Panel.setLayout(new BoxLayout(sub4Panel, BoxLayout.Y_AXIS));
        sub4Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub4Panel);

        JLabel text8 = new JLabel();
        text8.setText("<html>• " + "<b>Pronounced:</b> /ma-sa-ma/" + "</html>");
        text8.setFont(assets.getArial());
        text8.setForeground(assets.getMainColorWhithy());
        sub4Panel.add(text8);

        return mainPanel;
    }

    public RoundedPanel Page2(){
        RoundedPanel mainPanel = new RoundedPanel(15, 15, 15, 15);
        mainPanel.setBackground(assets.getMainColorDarkGreen());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(null);
        titlePanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JLabel title = new JLabel("Basic Adjectives");
        title.setFont(assets.getArialBold());
        title.setForeground(assets.getMainColorYellowBG());
        title.setHorizontalAlignment(JLabel.LEFT);
        titlePanel.add(title, BorderLayout.CENTER);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(null);
        textPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        mainPanel.add(textPanel, BorderLayout.CENTER);

        JLabel text1 = new JLabel();
        text1.setText("<html><br>• " + "<b>Beautiful:</b> Maganda" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel sub1Panel = new JPanel();
        sub1Panel.setBackground(null);
        sub1Panel.setLayout(new BoxLayout(sub1Panel, BoxLayout.Y_AXIS));
        sub1Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub1Panel);

        JLabel text2 = new JLabel();
        text2.setText("<html>• " + "<b>Pronounced:</b> /ma-gan-da/" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        sub1Panel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>• " + "<b>Ugly:</b> Pangit" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        textPanel.add(text3);

        JPanel sub2Panel = new JPanel();
        sub2Panel.setBackground(null);
        sub2Panel.setLayout(new BoxLayout(sub2Panel, BoxLayout.Y_AXIS));
        sub2Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub2Panel);

        JLabel text4 = new JLabel();
        text4.setText("<html>• " + "<b>Pronounced:</b> /pa-ngit/" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text4);

        JLabel text5 = new JLabel();
        text5.setText("<html><br>• " + "<b>Happy:</b> Masaya" + "</html>");
        text5.setFont(assets.getArial());
        text5.setForeground(assets.getMainColorWhithy());
        textPanel.add(text5);

        JPanel sub3Panel = new JPanel();
        sub3Panel.setBackground(null);
        sub3Panel.setLayout(new BoxLayout(sub3Panel, BoxLayout.Y_AXIS));
        sub3Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub3Panel);

        JLabel text6 = new JLabel();
        text6.setText("<html>• " + "<b>Pronounced:</b> /ma-sa-ya/" + "</html>");
        text6.setFont(assets.getArial());
        text6.setForeground(assets.getMainColorWhithy());
        sub3Panel.add(text6);

        JLabel text7 = new JLabel();
        text7.setText("<html><br>• " + "<b>Sad:</b> Malungkot" + "</html>");
        text7.setFont(assets.getArial());
        text7.setForeground(assets.getMainColorWhithy());
        textPanel.add(text7);

        JPanel sub4Panel = new JPanel();
        sub4Panel.setBackground(null);
        sub4Panel.setLayout(new BoxLayout(sub4Panel, BoxLayout.Y_AXIS));
        sub4Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub4Panel);

        JLabel text8 = new JLabel();
        text8.setText("<html>• " + "<b>Pronounced:</b> /ma-lung-kot/" + "</html>");
        text8.setFont(assets.getArial());
        text8.setForeground(assets.getMainColorWhithy());
        sub4Panel.add(text8);

        return mainPanel;
    }

    public RoundedPanel Page3(){
        RoundedPanel mainPanel = new RoundedPanel(15, 15, 15, 15);
        mainPanel.setBackground(assets.getMainColorDarkGreen());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(null);
        titlePanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JLabel title = new JLabel("Basic Adjectives");
        title.setFont(assets.getArialBold());
        title.setForeground(assets.getMainColorYellowBG());
        title.setHorizontalAlignment(JLabel.LEFT);
        titlePanel.add(title, BorderLayout.CENTER);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(null);
        textPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        mainPanel.add(textPanel, BorderLayout.CENTER);

        JLabel text1 = new JLabel();
        text1.setText("<html><br>• " + "<b>Hot:</b> Mainit" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel sub1Panel = new JPanel();
        sub1Panel.setBackground(null);
        sub1Panel.setLayout(new BoxLayout(sub1Panel, BoxLayout.Y_AXIS));
        sub1Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub1Panel);

        JLabel text2 = new JLabel();
        text2.setText("<html>• " + "<b>Pronounced:</b> /ma-ee-neet/" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        sub1Panel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>• " + "<b>Cold:</b> Malamig" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        textPanel.add(text3);

        JPanel sub2Panel = new JPanel();
        sub2Panel.setBackground(null);
        sub2Panel.setLayout(new BoxLayout(sub2Panel, BoxLayout.Y_AXIS));
        sub2Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub2Panel);

        JLabel text4 = new JLabel();
        text4.setText("<html>• " + "<b>Pronounced:</b> /ma-la-mig/" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text4);

        return mainPanel;
    }

    public RoundedPanel Page4(){
        RoundedPanel mainPanel = new RoundedPanel(15, 15, 15, 15);
        mainPanel.setBackground(assets.getMainColorDarkGreen());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(null);
        titlePanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JLabel title = new JLabel("Forming Descriptive Sentences");
        title.setFont(assets.getArialBold());
        title.setForeground(assets.getMainColorYellowBG());
        title.setHorizontalAlignment(JLabel.LEFT);
        titlePanel.add(title, BorderLayout.CENTER);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(null);
        textPanel.setBorder(new EmptyBorder(20, 20, 0, 0));
        mainPanel.add(textPanel, BorderLayout.CENTER);

        JLabel text1 = new JLabel();
        text1.setText("<html>" + "In Filipino, adjectives typically come after the noun they describe, unlike in English where adjectives precede the noun." + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JLabel text2 = new JLabel();
        text2.setText("<html><br>" + "<b>Examples:</b>" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        textPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>• " + "<b>Big house:</b> Malaking bahay" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        textPanel.add(text3);

        JPanel sub4Panel = new JPanel();
        sub4Panel.setBackground(null);
        sub4Panel.setLayout(new BoxLayout(sub4Panel, BoxLayout.Y_AXIS));
        sub4Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub4Panel);

        JLabel text4 = new JLabel();
        text4.setText("<html>• " + "<b>Breakdown:</b> Malaking (big) bahay (house)" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        sub4Panel.add(text4);

        JLabel text5 = new JLabel();
        text5.setText("<html><br>• " + "<b>Small cat:</b> Maliit na pusa" + "</html>");
        text5.setFont(assets.getArial());
        text5.setForeground(assets.getMainColorWhithy());
        textPanel.add(text5);

        JPanel sub5Panel = new JPanel();
        sub5Panel.setBackground(null);
        sub5Panel.setLayout(new BoxLayout(sub5Panel, BoxLayout.Y_AXIS));
        sub5Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub5Panel);

        JLabel text6 = new JLabel();
        text6.setText("<html>• " + "<b>Breakdown:</b> Maliit (small) na (linker) pusa (cat)" + "</html>");
        text6.setFont(assets.getArial());
        text6.setForeground(assets.getMainColorWhithy());
        sub5Panel.add(text6);

        JLabel text7 = new JLabel();
        text7.setText("<html><br>• " + "<b>Beautiful flower:</b> Magandang bulaklak" + "</html>");
        text7.setFont(assets.getArial());
        text7.setForeground(assets.getMainColorWhithy());
        textPanel.add(text7);

        JPanel sub6Panel = new JPanel();
        sub6Panel.setBackground(null);
        sub6Panel.setLayout(new BoxLayout(sub6Panel, BoxLayout.Y_AXIS));
        sub6Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub6Panel);

        JLabel text8 = new JLabel();
        text8.setText("<html>• " + "<b>Breakdown:</b> Magandang (beautiful) bulaklak (flower)" + "</html>");
        text8.setFont(assets.getArial());
        text8.setForeground(assets.getMainColorWhithy());
        sub6Panel.add(text8);


        return mainPanel;
    }

    public RoundedPanel Page5(){
        RoundedPanel mainPanel = new RoundedPanel(15, 15, 15, 15);
        mainPanel.setBackground(assets.getMainColorDarkGreen());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(null);
        titlePanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JLabel title = new JLabel("Comparative and Superlative Forms");
        title.setFont(assets.getArialBold());
        title.setForeground(assets.getMainColorYellowBG());
        title.setHorizontalAlignment(JLabel.LEFT);
        titlePanel.add(title, BorderLayout.CENTER);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(null);
        textPanel.setBorder(new EmptyBorder(20, 20, 0, 0));
        mainPanel.add(textPanel, BorderLayout.CENTER);

        JLabel text1 = new JLabel();
        text1.setText("<html>" + "<b>Comparative:</b> \"Mas\" + adjective" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel subPanel = new JPanel();
        subPanel.setBackground(null);
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(subPanel);

        JLabel text2 = new JLabel();
        text2.setText("<html>• " + "<b>Bigger:</b> Mas malaki" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        subPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html>• " + "<b>Smaller:</b> Mas maliit" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        subPanel.add(text3);

        JLabel text4 = new JLabel();
        text4.setText("<html>• " + "<b>Happier:</b> Mas masaya" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        subPanel.add(text4);

        JLabel text5 = new JLabel();
        text5.setText("<html><br>" + "<b>Superlative:</b> \"Pinaka\" + adjective" + "</html>");
        text5.setFont(assets.getArial());
        text5.setForeground(assets.getMainColorWhithy());
        textPanel.add(text5);

        JPanel sub2Panel = new JPanel();
        sub2Panel.setBackground(null);
        sub2Panel.setLayout(new BoxLayout(sub2Panel, BoxLayout.Y_AXIS));
        sub2Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub2Panel);

        JLabel text6 = new JLabel();
        text6.setText("<html>• " + "<b>Bigger:</b> Pinakamalaki" + "</html>");
        text6.setFont(assets.getArial());
        text6.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text6);

        JLabel text7 = new JLabel();
        text7.setText("<html>• " + "<b>Smaller:</b> pinakamaliit" + "</html>");
        text7.setFont(assets.getArial());
        text7.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text7);

        JLabel text8 = new JLabel();
        text8.setText("<html>• " + "<b>Happier:</b> pinakamasaya" + "</html>");
        text8.setFont(assets.getArial());
        text8.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text8);

        return mainPanel;
    }


    public JPanel NavigationPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(null);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(0, 80));

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
        btn_left.addActionListener(this);
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
        btn_right.addActionListener(this);
        rightPanel.add(btn_right);

        return mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btn_right){
            if (currentCard.equals("P1")){
                currentCard = page2.getName();
                btn_left.setVisible(true);
            }else if (currentCard.equals("P2")){
                currentCard = page3.getName();
            }else if (currentCard.equals("P3")){
                currentCard = page4.getName();
            }else if (currentCard.equals("P4")){
                currentCard = page5.getName();
                btn_right.setText("Done");
                btn_right.setHorizontalTextPosition(JButton.LEFT);
                btn_right.setIcon(null);
                btn_right.setFont(assets.getArial());
                btn_right.setForeground(assets.getMainColorWhithy());
                btn_right.setBorder(new EmptyBorder(10, 20, 10, 20));
                btn_right.getParent().setPreferredSize(new Dimension(90, 0));
            }else if (currentCard.equals("P5")){
                this.setVisible(false);
                LevelPanel.getLevelContent().add(quizPanel("Level 4:Adept"), BorderLayout.CENTER);
            }

            lessonCardLayout.show(lessonPanel, currentCard);
        }else if (actionEvent.getSource() == btn_left){
            if (currentCard.equals("P1")){
                btn_left.setVisible(false);
            }else if (currentCard.equals("P2")){
                currentCard = page1.getName();
                btn_left.setVisible(false);
            }else if (currentCard.equals("P3")){
                currentCard = page2.getName();
            }else if (currentCard.equals("P4")){
                currentCard = page3.getName();
            }else if (currentCard.equals("P5")){
                currentCard = page4.getName();
                Image RighticonImage = assets.getRightIcon().getImage();
                Image RightresizeIcon = RighticonImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon Righticon = new ImageIcon(RightresizeIcon);
                btn_right.setIcon(Righticon);
                btn_right.setText(null);
                btn_right.setBorder(new EmptyBorder(5, 5, 5, 5));
                btn_right.getParent().setPreferredSize(new Dimension(70, 0));
            }

            lessonCardLayout.show(lessonPanel, currentCard);
        }

        //==========

        if (actionEvent.getSource() == choice1){
            System.out.println("A");
            if (correct_answer.equals("A")){
                score++;
            }
            index++;
            System.out.println("SCORE: " + score);

            if (index <= 9){
                String ques = questions[index].split("\\|")[0];
                String choice_A = questions[index].split("\\|")[1];
                String choice_B = questions[index].split("\\|")[2];
                String choice_C = questions[index].split("\\|")[3];
                String choice_D = questions[index].split("\\|")[4];
                String answer = questions[index].split("\\|")[5];

                questionLabel.setText("<html> " + ques + "</html>");
                choice1.setText("<html> " + choice_A + "</html>");
                choice2.setText("<html> " + choice_B + "</html>");
                choice3.setText("<html> " + choice_C + "</html>");
                choice4.setText("<html> " + choice_D + "</html>");

                correct_answer = answer;
            }else {
                currentCard = resultPanel.getName();
                quizCardLayout.show(quizMainPanel, currentCard);

                String final_score = score + "/10";
                String greet = "";
                scoreLabel.setText(final_score);

                if (score < 5){
                    greetings.setText("Not Bad");
//                greet = "Not Bad";
                }else if (score < 8){
                    greetings.setText("Good Job!");
//                greet = "Good Job!";
                }else {
                    greetings.setText("Excellent!");
//                greet = "Excellent";
                }

                LevelPanel.isCompleted = true;
//
//            JOptionPane.showMessageDialog(null,
//                    greet + "\n\nScore: " + final_score,
//                    "Score", JOptionPane.INFORMATION_MESSAGE);
//                if (actionEvent.getSource() == btn_goBack){
//                    System.out.println("DONE");
//                    JPanel level = new LevelPanel();
//                    LevelPanel.getLevelCardLayout().show(level, LevelPanel.getMainLevelPanel().getName());
//                }

                System.out.println("FINAL SCORE: " + score);

            }

        }else if (actionEvent.getSource() == choice2){
            System.out.println("B");
            if (correct_answer.equals("B")){
                score++;
            }
            index++;
            System.out.println("SCORE: " + score);

            if (index <= 9){
                String ques = questions[index].split("\\|")[0];
                String choice_A = questions[index].split("\\|")[1];
                String choice_B = questions[index].split("\\|")[2];
                String choice_C = questions[index].split("\\|")[3];
                String choice_D = questions[index].split("\\|")[4];
                String answer = questions[index].split("\\|")[5];

                questionLabel.setText("<html> " + ques + "</html>");
                choice1.setText("<html> " + choice_A + "</html>");
                choice2.setText("<html> " + choice_B + "</html>");
                choice3.setText("<html> " + choice_C + "</html>");
                choice4.setText("<html> " + choice_D + "</html>");

                correct_answer = answer;
            }else {
                currentCard = resultPanel.getName();
                quizCardLayout.show(quizMainPanel, currentCard);

                String final_score = score + "/10";
                String greet = "";
                scoreLabel.setText(final_score);

                if (score < 5){
                    greetings.setText("Not Bad");
//                greet = "Not Bad";
                }else if (score < 8){
                    greetings.setText("Good Job!");
//                greet = "Good Job!";
                }else {
                    greetings.setText("Excellent!");
//                greet = "Excellent";
                }

                LevelPanel.isCompleted = true;
//
//            JOptionPane.showMessageDialog(null,
//                    greet + "\n\nScore: " + final_score,
//                    "Score", JOptionPane.INFORMATION_MESSAGE);
//                if (actionEvent.getSource() == btn_goBack){
//                    System.out.println("DONE");
//                    JPanel level = new LevelPanel();
//                    LevelPanel.getLevelCardLayout().show(level, LevelPanel.getMainLevelPanel().getName());
//                }

                System.out.println("FINAL SCORE: " + score);
            }
        }else if (actionEvent.getSource() == choice3){
            System.out.println("C");
            if (correct_answer.equals("C")){
                score++;
            }
            index++;
            System.out.println("SCORE: " + score);

            if (index <= 9){
                String ques = questions[index].split("\\|")[0];
                String choice_A = questions[index].split("\\|")[1];
                String choice_B = questions[index].split("\\|")[2];
                String choice_C = questions[index].split("\\|")[3];
                String choice_D = questions[index].split("\\|")[4];
                String answer = questions[index].split("\\|")[5];

                questionLabel.setText("<html> " + ques + "</html>");
                choice1.setText("<html> " + choice_A + "</html>");
                choice2.setText("<html> " + choice_B + "</html>");
                choice3.setText("<html> " + choice_C + "</html>");
                choice4.setText("<html> " + choice_D + "</html>");

                correct_answer = answer;
            }else {
                currentCard = resultPanel.getName();
                quizCardLayout.show(quizMainPanel, currentCard);

                String final_score = score + "/10";
                String greet = "";
                scoreLabel.setText(final_score);

                if (score < 5){
                    greetings.setText("Not Bad");
//                greet = "Not Bad";
                }else if (score < 8){
                    greetings.setText("Good Job!");
//                greet = "Good Job!";
                }else {
                    greetings.setText("Excellent!");
//                greet = "Excellent";
                }

                LevelPanel.isCompleted = true;
//
//            JOptionPane.showMessageDialog(null,
//                    greet + "\n\nScore: " + final_score,
//                    "Score", JOptionPane.INFORMATION_MESSAGE);
//                if (actionEvent.getSource() == btn_goBack){
//                    System.out.println("DONE");
//                    JPanel level = new LevelPanel();
//                    LevelPanel.getLevelCardLayout().show(level, LevelPanel.getMainLevelPanel().getName());
//                }

                System.out.println("FINAL SCORE: " + score);
            }
        }else if (actionEvent.getSource() == choice4){
            System.out.println("D");
            if (correct_answer.equals("D")){
                score++;
            }
            index++;
            System.out.println("SCORE: " + score);

            if (index <= 9){
                String ques = questions[index].split("\\|")[0];
                String choice_A = questions[index].split("\\|")[1];
                String choice_B = questions[index].split("\\|")[2];
                String choice_C = questions[index].split("\\|")[3];
                String choice_D = questions[index].split("\\|")[4];
                String answer = questions[index].split("\\|")[5];

                questionLabel.setText("<html> " + ques + "</html>");
                choice1.setText("<html> " + choice_A + "</html>");
                choice2.setText("<html> " + choice_B + "</html>");
                choice3.setText("<html> " + choice_C + "</html>");
                choice4.setText("<html> " + choice_D + "</html>");

                correct_answer = answer;
            }else {
                currentCard = resultPanel.getName();
                quizCardLayout.show(quizMainPanel, currentCard);

                String final_score = score + "/10";
                String greet = "";
                scoreLabel.setText(final_score);

                if (score < 5){
                    greetings.setText("Not Bad");
//                greet = "Not Bad";
                }else if (score < 8){
                    greetings.setText("Good Job!");
//                greet = "Good Job!";
                }else {
                    greetings.setText("Excellent!");
//                greet = "Excellent";
                }

                LevelPanel.isCompleted = true;
//
//            JOptionPane.showMessageDialog(null,
//                    greet + "\n\nScore: " + final_score,
//                    "Score", JOptionPane.INFORMATION_MESSAGE);

//                if (actionEvent.getSource() == btn_goBack){
//                    System.out.println("DONE");
//                    JPanel level = new LevelPanel();
//                    LevelPanel.getLevelCardLayout().show(level, LevelPanel.getMainLevelPanel().getName());
//                }

                System.out.println("FINAL SCORE: " + score);
            }
        }
    }

    public static JPanel getPage1() {
        return page1;
    }

    public CardLayout getLessonCardLayout() {
        return lessonCardLayout;
    }

    public JPanel quizPanel(String level_name){
        quizMainPanel = new JPanel();
        quizCardLayout = new CardLayout() ;
        quizMainPanel.setBackground(null);
        quizMainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        quizMainPanel.setLayout(quizCardLayout);

        // Set description
        LevelPanel.getDescriptionTitle().setText("Quiz Time!");

        // Get the questions
        questions = listOfQuestions(level_name);
        System.out.println(Arrays.toString(questions));

        JPanel panel_quiz = new JPanel();
        panel_quiz.setName("QUIZ");
        currentCard = panel_quiz.getName();
        panel_quiz.setBackground(null);
        panel_quiz.setLayout(new BorderLayout());
        quizMainPanel.add(panel_quiz, panel_quiz.getName());

        JPanel quiz = quiz();
        quiz.setBackground(null);
        panel_quiz.add(quiz, BorderLayout.CENTER);

        resultPanel = result();
        resultPanel.setName("RESULT");
        resultPanel.setBackground(null);
        quizMainPanel.add(resultPanel, resultPanel.getName());

        // Get each variable
        String ques = questions[index].split("\\|")[0];
        String choice_A = questions[index].split("\\|")[1];
        String choice_B = questions[index].split("\\|")[2];
        String choice_C = questions[index].split("\\|")[3];
        String choice_D = questions[index].split("\\|")[4];
        String answer = questions[index].split("\\|")[5];

        questionLabel.setText("<html> " + ques + "</html>");
        choice1.setText("<html> " + choice_A + "</html>");
        choice2.setText("<html> " + choice_B + "</html>");
        choice3.setText("<html> " + choice_C + "</html>");
        choice4.setText("<html> " + choice_D + "</html>");
        correct_answer = answer;

        quizCardLayout.show(quizMainPanel, currentCard);

        return quizMainPanel;
    }

    public JPanel quiz(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        RoundedPanel questionPanel = new RoundedPanel(20, 20, 20, 20);
        questionPanel.setBackground(assets.getMainColorDarkGreen());
        questionPanel.setLayout(new BorderLayout());
        mainPanel.add(questionPanel, BorderLayout.CENTER);

        questionLabel = new JLabel();
        questionLabel.setFont(assets.getArialBold());
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        questionLabel.setForeground(assets.getMainColorWhithy());
        questionPanel.add(questionLabel, BorderLayout.CENTER);

        JPanel choicesPanel = new JPanel();
        choicesPanel.setLayout(new GridLayout(2, 2, 10, 10));
        choicesPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        choicesPanel.setBackground(null);
        mainPanel.add(choicesPanel, BorderLayout.SOUTH);

        choice1 = new RoundedButton();
        choice1.setBorder(null);
        choice1.setRadius(15);
        choice1.setFont(assets.getArial());
        choice1.setColor(assets.getMainColorYellowBG());
        choice1.setBorderColor(assets.getMainColorYellowBG());
        choice1.setColorClick(assets.getYellowColorClick());
        choice1.setColorOver(assets.getYellowColorOver());
        choice1.setPreferredSize(new Dimension(0, 50));
        choice1.setFocusable(false);
        choice1.addActionListener(this);
        choicesPanel.add(choice1);

        choice2 = new RoundedButton();
        choice2.setBorder(null);
        choice2.setRadius(15);
        choice2.setFont(assets.getArial());
        choice2.setColor(assets.getMainColorYellowBG());
        choice2.setBorderColor(assets.getMainColorYellowBG());
        choice2.setColorClick(assets.getYellowColorClick());
        choice2.setColorOver(assets.getYellowColorOver());
        choice2.setPreferredSize(new Dimension(0, 50));
        choice2.setFocusable(false);
        choice2.addActionListener(this);
        choicesPanel.add(choice2);

        choice3 = new RoundedButton();
        choice3.setBorder(null);
        choice3.setRadius(15);
        choice3.setFont(assets.getArial());
        choice3.setColor(assets.getMainColorYellowBG());
        choice3.setBorderColor(assets.getMainColorYellowBG());
        choice3.setColorClick(assets.getYellowColorClick());
        choice3.setColorOver(assets.getYellowColorOver());
        choice3.setPreferredSize(new Dimension(0, 50));
        choice3.setFocusable(false);
        choice3.addActionListener(this);
        choicesPanel.add(choice3);

        choice4 = new RoundedButton();
        choice4.setBorder(null);
        choice4.setRadius(15);
        choice4.setFont(assets.getArial());
        choice4.setColor(assets.getMainColorYellowBG());
        choice4.setBorderColor(assets.getMainColorYellowBG());
        choice4.setColorClick(assets.getYellowColorClick());
        choice4.setColorOver(assets.getYellowColorOver());
        choice4.setPreferredSize(new Dimension(0, 50));
        choice4.setFocusable(false);
        choice4.addActionListener(this);
        choicesPanel.add(choice4);

        return mainPanel;
    }

    public JPanel result(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.yellow);
        mainPanel.setBorder(new EmptyBorder(50, 100, 50, 100));

        RoundedPanel contentPanel = new RoundedPanel(20, 20, 20, 20);
        contentPanel.setBackground(assets.getMainColorDarkGreen());
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JPanel greetingPanel = new JPanel();
        greetingPanel.setBackground(null);
        greetingPanel.setLayout(new BorderLayout());
        contentPanel.add(greetingPanel, BorderLayout.NORTH);

        greetings = new JLabel("GUNGONG");
        greetings.setFont(assets.getArialBoldTitle());
        greetings.setForeground(assets.getMainColorYellowBG());
        greetings.setHorizontalAlignment(JLabel.CENTER);
        greetingPanel.add(greetings, BorderLayout.CENTER);

        JPanel scorePanel = new JPanel();
        scorePanel.setBackground(null);
        scorePanel.setLayout(new BorderLayout());
        contentPanel.add(scorePanel, BorderLayout.CENTER);

        scoreLabel = new JLabel("10/10");
        scoreLabel.setFont(assets.getArialScore());
        scoreLabel.setForeground(assets.getMainColorWhithy());
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scorePanel.add(scoreLabel, BorderLayout.CENTER);

//        JPanel backBtnPanel = new JPanel();
//        backBtnPanel.setBackground(null);
//        backBtnPanel.setLayout(new BorderLayout());
//        contentPanel.add(backBtnPanel, BorderLayout.SOUTH);
//
//        btn_goBack = new RoundedButton();
//        btn_goBack.setText("Go Back");
//        btn_goBack.setFont(assets.getArialBold());
//        btn_goBack.setRadius(15);
//        btn_goBack.setColor(assets.getMainColorYellowBG());
//        btn_goBack.setColorOver(assets.getYellowColorOver());
//        btn_goBack.setColorClick(assets.getYellowColorClick());
//        btn_goBack.setBorderColor(assets.getMainColorYellowBG());
//        btn_goBack.setFocusable(false);
//        btn_goBack.setBorder(null);
//        btn_goBack.setPreferredSize(new Dimension(0, 40));
//        btn_goBack.addActionListener(this);
//        backBtnPanel.add(btn_goBack, BorderLayout.CENTER);

        return mainPanel;
    }

    public  String[] listOfQuestions(String name){
        String[] questions = new String[0];

        if (name.equals("Level 0:Novice")){
            questions = getEachLine(assets.getNovice_Quiz());
        }else if (name.equals("Level 1:Beginner")){
            questions = getEachLine(assets.getBeginner_Quiz());
        }else if (name.equals("Level 2:Apprentice")){
            questions = getEachLine(assets.getApprentice_Quiz());
        }else if (name.equals("Level 3:Intermediate")){
            questions = getEachLine(assets.getIntermediate_Quiz());
        }else if (name.equals("Level 4:Adept")){
            questions = getEachLine(assets.getAdept_Quiz());
        }else if (name.equals("Level 5:Skilled")){
            questions = getEachLine(assets.getSkilled_Quiz());
        }else if (name.equals("Level 6:Advanced")){
            questions = getEachLine(assets.getAdvanced_Quiz());
        }else if (name.equals("Level 7:Expert")){
            questions = getEachLine(assets.getExpert_Quiz());
        }else if (name.equals("Level 8:Master")){
            questions = getEachLine(assets.getMaster_Quiz());
        }else if (name.equals("Level 9:Natural Filipino")){
            questions = getEachLine(assets.getNatural_Filpino_Quiz());
        }

        return questions;
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
}
