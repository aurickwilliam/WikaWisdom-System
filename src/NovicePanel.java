import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovicePanel extends JPanel implements ActionListener {
    Assets assets = new Assets();
    // Layout
    private CardLayout lessonCardLayout;

    // Strings
    private String currentCard = "";
    private String previousCard = "";

    // Buttons
    private RoundedButton btn_right, btn_left;

    // Panels
    private static JPanel lessonPanel;
    private static JPanel page1;
    private static JPanel page2;
    private static JPanel page3;
    private static JPanel page4;
    private static JPanel page5;

    public NovicePanel(){
        setBackground(null);
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(700, 470));

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

        JLabel title = new JLabel("Historical Context");
        title.setFont(assets.getArialBold());
        title.setForeground(assets.getMainColorYellowBG());
        title.setHorizontalAlignment(JLabel.LEFT);
        titlePanel.add(title, BorderLayout.CENTER);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBackground(null);
        textPanel.setBorder(new EmptyBorder(20, 20, 0, 0));
        mainPanel.add(textPanel, BorderLayout.CENTER);

        JLabel text = new JLabel();
        text.setText("<html>• " + "Filipino is the national language of the Philippines, based on Tagalog, and was officially adopted in the 1987 Constitution. " +
                "<br><br>• Tagalog was chosen as the basis for the national language in 1937 due to its widespread use and rich literary tradition.\n" + "</html>");
        text.setFont(assets.getArial());
        text.setForeground(assets.getMainColorWhithy());
        text.setVerticalAlignment(JLabel.NORTH);
        text.setHorizontalAlignment(JLabel.LEFT);
        textPanel.add(text, BorderLayout.CENTER);

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

        JLabel title = new JLabel("The Alphabet and Phonetics");
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
        text1.setText("<html>• " + "<b>Alphabet:</b> The modern Filipino alphabet consists of 28 letters." + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JLabel text2 = new JLabel();
        text2.setText("<html><br>• " + "<b>Vowels:</b> A, E, I, O, U" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        textPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>• " + "<b>Consonants</b>: B, C, D, F, G, H, J, K, L, M, N, Ñ, Ng, P, Q, R, S, T, V, W, X, Y, Z" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        textPanel.add(text3);

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

        JLabel title = new JLabel("Basic Pronunciation Rules");
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
        text1.setText("<html>• " + "<b>Vowels:</b> Pronounced similarly to Spanish vowels:" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel vowelPanel = new JPanel();
        vowelPanel.setBackground(null);
        vowelPanel.setLayout(new BoxLayout(vowelPanel, BoxLayout.Y_AXIS));
        vowelPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(vowelPanel);

        JLabel text2 = new JLabel();
        text2.setText("<html><br>• " + "<b>A:</b> as in \"father\"" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        vowelPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>• " + "<b>E:</b> as in \"bed\"" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        vowelPanel.add(text3);

        JLabel text4 = new JLabel();
        text4.setText("<html><br>• " + "<b>I:</b> as in \"machine\"" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        vowelPanel.add(text4);

        JLabel text5 = new JLabel();
        text5.setText("<html><br>• " + "<b>O:</b> as in \"more\"" + "</html>");
        text5.setFont(assets.getArial());
        text5.setForeground(assets.getMainColorWhithy());
        vowelPanel.add(text5);

        JLabel text6 = new JLabel();
        text6.setText("<html><br>• " + "<b>U:</b> as in \"rule\"" + "</html>");
        text6.setFont(assets.getArial());
        text6.setForeground(assets.getMainColorWhithy());
        vowelPanel.add(text6);

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

        JLabel title = new JLabel("Basic Pronunciation Rules");
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
        text1.setText("<html>• " + "<b>Consonants:</b> Most consonants are pronounced as in English, with a few exceptions:" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel vowelPanel = new JPanel();
        vowelPanel.setBackground(null);
        vowelPanel.setLayout(new BoxLayout(vowelPanel, BoxLayout.Y_AXIS));
        vowelPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(vowelPanel);

        JLabel text2 = new JLabel();
        text2.setText("<html><br>• " + "<b>Ng:</b> as in \"sing\"" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        vowelPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>• " + "<b>Ñ:</b> as in Spanish \"niño\"" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        vowelPanel.add(text3);

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

        JLabel title = new JLabel("Basic Pronunciation Rules");
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
        text1.setText("<html>• " + "<b>Stress and Intonations:</b> Stress can change the meaning of words. Generally, stress is on the second to the last syllable, but it can vary." + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel vowelPanel = new JPanel();
        vowelPanel.setBackground(null);
        vowelPanel.setLayout(new BoxLayout(vowelPanel, BoxLayout.Y_AXIS));
        vowelPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(vowelPanel);

        JLabel text2 = new JLabel();
        text2.setText("<html><br> " + "<b>Sample Words and Pronunciation</b>" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        vowelPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>• " + "<b>Aso</b>(dog) - /a-so/" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        vowelPanel.add(text3);

        JLabel text4 = new JLabel();
        text4.setText("<html><br>• " + "<b>Puno</b>(tree) - /pu-no/" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        vowelPanel.add(text4);

        JLabel text5 = new JLabel();
        text5.setText("<html><br>• " + "<b>Bata</b>(child) - /ba-ta/" + "</html>");
        text5.setFont(assets.getArial());
        text5.setForeground(assets.getMainColorWhithy());
        vowelPanel.add(text5);

        JLabel text6 = new JLabel();
        text6.setText("<html><br>• " + "<b>Bayan</b>(country) - /ba-yan/" + "</html>");
        text6.setFont(assets.getArial());
        text6.setForeground(assets.getMainColorWhithy());
        vowelPanel.add(text6);

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
                btn_right.setVisible(false);
            }else if (currentCard.equals("P5")){
                //
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
                btn_right.setVisible(true);
            }

            lessonCardLayout.show(lessonPanel, currentCard);
        }
    }

    public static JPanel getPage1() {
        return page1;
    }

    public CardLayout getLessonCardLayout() {
        return lessonCardLayout;
    }
}
