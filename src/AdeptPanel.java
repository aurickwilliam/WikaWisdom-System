import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdeptPanel extends JPanel implements ActionListener {
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

    public AdeptPanel(){
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
