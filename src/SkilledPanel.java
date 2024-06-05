import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkilledPanel extends JPanel implements ActionListener {
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
    private static JPanel page6;
    private static JPanel page7;
    private static JPanel page8;
    private static JPanel page9;

    public SkilledPanel(){
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

        page6 = Page6();
        page6.setName("P6");
        lessonPanel.add(page6, page6.getName());

        page7 = Page7();
        page7.setName("P7");
        lessonPanel.add(page7, page7.getName());

        page8 = Page8();
        page8.setName("P8");
        lessonPanel.add(page8, page8.getName());

        page9 = Page9();
        page9.setName("P9");
        lessonPanel.add(page9, page9.getName());

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

        JLabel title = new JLabel("Family Members");
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
        text1.setText("<html><br>• " + "<b>Father:</b> Ama/Tatay" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel subPanel = new JPanel();
        subPanel.setBackground(null);
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(subPanel);

        JLabel text2 = new JLabel();
        text2.setText("<html>• " + "<b>Pronounced:</b> /a-ma/ /ta-tay/" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        subPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>• " + "<b>Mother:</b> Ina/Nanay" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        textPanel.add(text3);

        JPanel sub2Panel = new JPanel();
        sub2Panel.setBackground(null);
        sub2Panel.setLayout(new BoxLayout(sub2Panel, BoxLayout.Y_AXIS));
        sub2Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub2Panel);

        JLabel text4 = new JLabel();
        text4.setText("<html>• " + "<b>Pronounced:</b> /ee-na/ /na-nay/" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text4);

        JLabel text5 = new JLabel();
        text5.setText("<html><br>• " + "<b>Brother:</b> Kapatid na lalaki" + "</html>");
        text5.setFont(assets.getArial());
        text5.setForeground(assets.getMainColorWhithy());
        textPanel.add(text5);

        JPanel sub3Panel = new JPanel();
        sub3Panel.setBackground(null);
        sub3Panel.setLayout(new BoxLayout(sub3Panel, BoxLayout.Y_AXIS));
        sub3Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub3Panel);

        JLabel text6 = new JLabel();
        text6.setText("<html>• " + "<b>Pronounced:</b> /ka-pa-tid na la-la-ki/" + "</html>");
        text6.setFont(assets.getArial());
        text6.setForeground(assets.getMainColorWhithy());
        sub3Panel.add(text6);

        JLabel text7 = new JLabel();
        text7.setText("<html><br>• " + "<b>Sister:</b> Kapatid na babae" + "</html>");
        text7.setFont(assets.getArial());
        text7.setForeground(assets.getMainColorWhithy());
        textPanel.add(text7);

        JPanel sub4Panel = new JPanel();
        sub4Panel.setBackground(null);
        sub4Panel.setLayout(new BoxLayout(sub4Panel, BoxLayout.Y_AXIS));
        sub4Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub4Panel);

        JLabel text8 = new JLabel();
        text8.setText("<html>• " + "<b>Pronounced:</b> /ka-pa-tid na ba-ba-e/" + "</html>");
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

        JLabel title = new JLabel("Family Members");
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
        text1.setText("<html><br>• " + "<b>Grandfather:</b> Lolo" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel subPanel = new JPanel();
        subPanel.setBackground(null);
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(subPanel);

        JLabel text2 = new JLabel();
        text2.setText("<html>• " + "<b>Pronounced:</b> /lo-lo/" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        subPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>• " + "<b>Grandmother:</b> Lola" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        textPanel.add(text3);

        JPanel sub2Panel = new JPanel();
        sub2Panel.setBackground(null);
        sub2Panel.setLayout(new BoxLayout(sub2Panel, BoxLayout.Y_AXIS));
        sub2Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub2Panel);

        JLabel text4 = new JLabel();
        text4.setText("<html>• " + "<b>Pronounced:</b> /lo-la/" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text4);

        JLabel text5 = new JLabel();
        text5.setText("<html><br>• " + "<b>Son:</b> Anak na lalaki" + "</html>");
        text5.setFont(assets.getArial());
        text5.setForeground(assets.getMainColorWhithy());
        textPanel.add(text5);

        JPanel sub3Panel = new JPanel();
        sub3Panel.setBackground(null);
        sub3Panel.setLayout(new BoxLayout(sub3Panel, BoxLayout.Y_AXIS));
        sub3Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub3Panel);

        JLabel text6 = new JLabel();
        text6.setText("<html>• " + "<b>Pronounced:</b> /a-nak na la-la-ki/" + "</html>");
        text6.setFont(assets.getArial());
        text6.setForeground(assets.getMainColorWhithy());
        sub3Panel.add(text6);

        JLabel text7 = new JLabel();
        text7.setText("<html><br>• " + "<b>Daughter:</b> Anak na babae" + "</html>");
        text7.setFont(assets.getArial());
        text7.setForeground(assets.getMainColorWhithy());
        textPanel.add(text7);

        JPanel sub4Panel = new JPanel();
        sub4Panel.setBackground(null);
        sub4Panel.setLayout(new BoxLayout(sub4Panel, BoxLayout.Y_AXIS));
        sub4Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub4Panel);

        JLabel text8 = new JLabel();
        text8.setText("<html>• " + "<b>Pronounced:</b> /a-nak na ba-ba-e/" + "</html>");
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

        JLabel title = new JLabel("Family Members");
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
        text1.setText("<html><br>• " + "<b>Uncle:</b> Tiyo/Tito" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel subPanel = new JPanel();
        subPanel.setBackground(null);
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(subPanel);

        JLabel text2 = new JLabel();
        text2.setText("<html>• " + "<b>Pronounced:</b> /ti-yo/ /ti-to/" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        subPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>• " + "<b>Aunt:</b> Tiya/Tita" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        textPanel.add(text3);

        JPanel sub2Panel = new JPanel();
        sub2Panel.setBackground(null);
        sub2Panel.setLayout(new BoxLayout(sub2Panel, BoxLayout.Y_AXIS));
        sub2Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub2Panel);

        JLabel text4 = new JLabel();
        text4.setText("<html>• " + "<b>Pronounced:</b> /ti-ya/ /ti-to/" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text4);

        JLabel text5 = new JLabel();
        text5.setText("<html><br>• " + "<b>Cousin:</b> Pinsan" + "</html>");
        text5.setFont(assets.getArial());
        text5.setForeground(assets.getMainColorWhithy());
        textPanel.add(text5);

        JPanel sub3Panel = new JPanel();
        sub3Panel.setBackground(null);
        sub3Panel.setLayout(new BoxLayout(sub3Panel, BoxLayout.Y_AXIS));
        sub3Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub3Panel);

        JLabel text6 = new JLabel();
        text6.setText("<html>• " + "<b>Pronounced:</b> /pin-san/" + "</html>");
        text6.setFont(assets.getArial());
        text6.setForeground(assets.getMainColorWhithy());
        sub3Panel.add(text6);

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

        JLabel title = new JLabel("Describing Relationships");
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
        text1.setText("<html>" + "<b>Examples:</b>" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JLabel text2 = new JLabel();
        text2.setText("<html><br>•" + "<b>My Father:</b> Ang aking ama/tatay" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        textPanel.add(text2);

        JPanel sub1Panel = new JPanel();
        sub1Panel.setBackground(null);
        sub1Panel.setLayout(new BoxLayout(sub1Panel, BoxLayout.Y_AXIS));
        sub1Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub1Panel);

        JLabel text3 = new JLabel();
        text3.setText("<html>• " + "<b>Pronounced:</b> /ang a-king a-ma/ /ta-tay/" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        sub1Panel.add(text3);

        JLabel text4 = new JLabel();
        text4.setText("<html><br>•" + "<b>Your Mother:</b> Ang iyong ina/nanay" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        textPanel.add(text4);

        JPanel sub2Panel = new JPanel();
        sub2Panel.setBackground(null);
        sub2Panel.setLayout(new BoxLayout(sub2Panel, BoxLayout.Y_AXIS));
        sub2Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub2Panel);

        JLabel text5 = new JLabel();
        text5.setText("<html>• " + "<b>Pronounced:</b> /ang i-yong ee-na/ /na-nay/" + "</html>");
        text5.setFont(assets.getArial());
        text5.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text5);

        JLabel text6 = new JLabel();
        text6.setText("<html><br>•" + "<b>His Brother:</b> Ang kanyang kapatid na lalaki" + "</html>");
        text6.setFont(assets.getArial());
        text6.setForeground(assets.getMainColorWhithy());
        textPanel.add(text6);

        JPanel sub3Panel = new JPanel();
        sub3Panel.setBackground(null);
        sub3Panel.setLayout(new BoxLayout(sub3Panel, BoxLayout.Y_AXIS));
        sub3Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub3Panel);

        JLabel text7 = new JLabel();
        text7.setText("<html>• " + "<b>Pronounced:</b> /ang kan-yan kapatid na la-la-ki/" + "</html>");
        text7.setFont(assets.getArial());
        text7.setForeground(assets.getMainColorWhithy());
        sub3Panel.add(text7);

        JLabel text8 = new JLabel();
        text8.setText("<html><br>•" + "<b>Her Sister:</b> Ang kanyang kapatid na babae" + "</html>");
        text8.setFont(assets.getArial());
        text8.setForeground(assets.getMainColorWhithy());
        textPanel.add(text8);

        JPanel sub4Panel = new JPanel();
        sub4Panel.setBackground(null);
        sub4Panel.setLayout(new BoxLayout(sub4Panel, BoxLayout.Y_AXIS));
        sub4Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub4Panel);

        JLabel text9 = new JLabel();
        text9.setText("<html>• " + "<b>Pronounced:</b> /ang kan-yan kapatid na ba-ba-e/" + "</html>");
        text9.setFont(assets.getArial());
        text9.setForeground(assets.getMainColorWhithy());
        sub4Panel.add(text9);

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

        JLabel title = new JLabel("Describing Relationships");
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
        text1.setText("<html>•" + "<b>Our grandfather:</b> Ang aming lolo" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel subPanel = new JPanel();
        subPanel.setBackground(null);
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(subPanel);

        JLabel text2 = new JLabel();
        text2.setText("<html>• " + "<b>Pronounced:</b> /ang a-ming lo-lo/" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        subPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>•" + "<b>Their grandmother:</b> Ang kanilang lola" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        textPanel.add(text3);

        JPanel sub2Panel = new JPanel();
        sub2Panel.setBackground(null);
        sub2Panel.setLayout(new BoxLayout(sub2Panel, BoxLayout.Y_AXIS));
        sub2Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub2Panel);

        JLabel text4 = new JLabel();
        text4.setText("<html>• " + "<b>Pronounced:</b> /ang ka-ni-lang lo-la/" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text4);

        return mainPanel;
    }

    public RoundedPanel Page6(){
        RoundedPanel mainPanel = new RoundedPanel(15, 15, 15, 15);
        mainPanel.setBackground(assets.getMainColorDarkGreen());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(null);
        titlePanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JLabel title = new JLabel("Possessive Pronouns");
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
        text1.setText("<html>•" + "<b>My:</b> Akin/Aking" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel subPanel = new JPanel();
        subPanel.setBackground(null);
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(subPanel);

        JLabel text2 = new JLabel();
        text2.setText("<html>• " + "<b>Pronounced:</b> /a-kin/ /a-king/" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        subPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>•" + "<b>Your (singular):</b> Iyo/Iyong" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        textPanel.add(text3);

        JPanel sub2Panel = new JPanel();
        sub2Panel.setBackground(null);
        sub2Panel.setLayout(new BoxLayout(sub2Panel, BoxLayout.Y_AXIS));
        sub2Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub2Panel);

        JLabel text4 = new JLabel();
        text4.setText("<html>• " + "<b>Pronounced:</b>  /i-yo/ /i-yong/" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text4);

        JLabel text5 = new JLabel();
        text5.setText("<html><br>•" + "<b>His/Her:</b> Kanya/Kanyang" + "</html>");
        text5.setFont(assets.getArial());
        text5.setForeground(assets.getMainColorWhithy());
        textPanel.add(text5);

        JPanel sub3Panel = new JPanel();
        sub3Panel.setBackground(null);
        sub3Panel.setLayout(new BoxLayout(sub3Panel, BoxLayout.Y_AXIS));
        sub3Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub3Panel);

        JLabel text6 = new JLabel();
        text6.setText("<html>• " + "<b>Pronounced:</b>  /kan-ya/ /kan-yang/" + "</html>");
        text6.setFont(assets.getArial());
        text6.setForeground(assets.getMainColorWhithy());
        sub3Panel.add(text6);

        JLabel text7 = new JLabel();
        text7.setText("<html><br>•" + "<b>Our (inclusive):</b> Ating" + "</html>");
        text7.setFont(assets.getArial());
        text7.setForeground(assets.getMainColorWhithy());
        textPanel.add(text7);

        JPanel sub4Panel = new JPanel();
        sub4Panel.setBackground(null);
        sub4Panel.setLayout(new BoxLayout(sub4Panel, BoxLayout.Y_AXIS));
        sub4Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub4Panel);

        JLabel text8 = new JLabel();
        text8.setText("<html>• " + "<b>Pronounced:</b>  /a-ting/" + "</html>");
        text8.setFont(assets.getArial());
        text8.setForeground(assets.getMainColorWhithy());
        sub4Panel.add(text8);

        return mainPanel;
    }

    public RoundedPanel Page7(){
        RoundedPanel mainPanel = new RoundedPanel(15, 15, 15, 15);
        mainPanel.setBackground(assets.getMainColorDarkGreen());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(null);
        titlePanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JLabel title = new JLabel("Possessive Pronouns");
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
        text1.setText("<html>•" + "<b>Our (exclusive):</b> Aming" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel subPanel = new JPanel();
        subPanel.setBackground(null);
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(subPanel);

        JLabel text2 = new JLabel();
        text2.setText("<html>• " + "<b>Pronounced:</b> /a-ming/" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        subPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>•" + "<b>Their:</b> Kanila/Kanilang" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        textPanel.add(text3);

        JPanel sub2Panel = new JPanel();
        sub2Panel.setBackground(null);
        sub2Panel.setLayout(new BoxLayout(sub2Panel, BoxLayout.Y_AXIS));
        sub2Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub2Panel);

        JLabel text4 = new JLabel();
        text4.setText("<html>• " + "<b>Pronounced:</b> /ka-ni-la/ /ka-ni-lang/" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text4);

        return mainPanel;
    }

    public RoundedPanel Page8(){
        RoundedPanel mainPanel = new RoundedPanel(15, 15, 15, 15);
        mainPanel.setBackground(assets.getMainColorDarkGreen());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(null);
        titlePanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JLabel title = new JLabel("Examples");
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
        text1.setText("<html>•" + "<b>My house:</b> Ang aking bahay" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel subPanel = new JPanel();
        subPanel.setBackground(null);
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(subPanel);

        JLabel text2 = new JLabel();
        text2.setText("<html>• " + "<b>Pronounced:</b> /ang a-king ba-hay/" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        subPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>•" + "<b>Your book:</b> Ang iyong libro" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        textPanel.add(text3);

        JPanel sub2Panel = new JPanel();
        sub2Panel.setBackground(null);
        sub2Panel.setLayout(new BoxLayout(sub2Panel, BoxLayout.Y_AXIS));
        sub2Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub2Panel);

        JLabel text4 = new JLabel();
        text4.setText("<html>• " + "<b>Pronounced:</b> /ang i-yong li-bro/" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text4);

        JLabel text5 = new JLabel();
        text5.setText("<html><br>•" + "<b>His car:</b> Ang kanyang kotse" + "</html>");
        text5.setFont(assets.getArial());
        text5.setForeground(assets.getMainColorWhithy());
        textPanel.add(text5);

        JPanel sub3Panel = new JPanel();
        sub3Panel.setBackground(null);
        sub3Panel.setLayout(new BoxLayout(sub3Panel, BoxLayout.Y_AXIS));
        sub3Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub3Panel);

        JLabel text6 = new JLabel();
        text6.setText("<html>• " + "<b>Pronounced:</b> /ang kan-yang kot-se/" + "</html>");
        text6.setFont(assets.getArial());
        text6.setForeground(assets.getMainColorWhithy());
        sub3Panel.add(text6);

        JLabel text7 = new JLabel();
        text7.setText("<html><br>•" + "<b>Her bag:</b> Ang kanyang bag" + "</html>");
        text7.setFont(assets.getArial());
        text7.setForeground(assets.getMainColorWhithy());
        textPanel.add(text7);

        JPanel sub4Panel = new JPanel();
        sub4Panel.setBackground(null);
        sub4Panel.setLayout(new BoxLayout(sub4Panel, BoxLayout.Y_AXIS));
        sub4Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub4Panel);

        JLabel text8 = new JLabel();
        text8.setText("<html>• " + "<b>Pronounced:</b> /ang kan-yang bag/" + "</html>");
        text8.setFont(assets.getArial());
        text8.setForeground(assets.getMainColorWhithy());
        sub4Panel.add(text8);

        return mainPanel;
    }

    public RoundedPanel Page9(){
        RoundedPanel mainPanel = new RoundedPanel(15, 15, 15, 15);
        mainPanel.setBackground(assets.getMainColorDarkGreen());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(null);
        titlePanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JLabel title = new JLabel("Examples");
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
        text1.setText("<html>•" + "<b>Our school (inclusive):</b> Ang ating paaralan" + "</html>");
        text1.setFont(assets.getArial());
        text1.setForeground(assets.getMainColorWhithy());
        textPanel.add(text1);

        JPanel subPanel = new JPanel();
        subPanel.setBackground(null);
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(subPanel);

        JLabel text2 = new JLabel();
        text2.setText("<html>• " + "<b>Pronounced:</b> /ang a-ting pa-a-ra-lan/" + "</html>");
        text2.setFont(assets.getArial());
        text2.setForeground(assets.getMainColorWhithy());
        subPanel.add(text2);

        JLabel text3 = new JLabel();
        text3.setText("<html><br>•" + "<b>Their friend:</b> Ang kanilang kaibigan" + "</html>");
        text3.setFont(assets.getArial());
        text3.setForeground(assets.getMainColorWhithy());
        textPanel.add(text3);

        JPanel sub2Panel = new JPanel();
        sub2Panel.setBackground(null);
        sub2Panel.setLayout(new BoxLayout(sub2Panel, BoxLayout.Y_AXIS));
        sub2Panel.setBorder(new EmptyBorder(0, 20, 0, 0));
        textPanel.add(sub2Panel);

        JLabel text4 = new JLabel();
        text4.setText("<html>• " + "<b>Pronounced:</b> /ang ka-ni-lang ka-i-bi-gan/" + "</html>");
        text4.setFont(assets.getArial());
        text4.setForeground(assets.getMainColorWhithy());
        sub2Panel.add(text4);

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
            }else if (currentCard.equals("P5")){
                currentCard = page6.getName();
            }else if (currentCard.equals("P6")){
                currentCard = page7.getName();
            }else if (currentCard.equals("P7")){
                currentCard = page8.getName();
            }else if (currentCard.equals("P8")){
                currentCard = page9.getName();
                btn_right.setVisible(false);
            }else if (currentCard.equals("P9")){
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
            }else if (currentCard.equals("P6")){
                currentCard = page5.getName();
            }else if (currentCard.equals("P7")){
                currentCard = page6.getName();
            }else if (currentCard.equals("P8")){
                currentCard = page7.getName();
            }else if (currentCard.equals("P9")){
                currentCard = page8.getName();
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
