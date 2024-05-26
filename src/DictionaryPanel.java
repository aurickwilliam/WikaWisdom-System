import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DictionaryPanel extends JPanel {
    Assets assets = new Assets();
    public DictionaryPanel(){
        CardLayout dictionaryCardLayout = new CardLayout();
        setLayout(dictionaryCardLayout);
        setBorder(new EmptyBorder(20, 20, 20, 20));

        // MainOptionPanel
        JPanel mainOptionPanel = new JPanel();
        mainOptionPanel.setLayout(new FlowLayout());
        add(mainOptionPanel, "OPTION_PANEL");

        // Title Bar
        JPanel titlePanel = new RoundedPanel(20, 20, 20, 20);
        titlePanel.setBackground(assets.getMainColorDarkGreen());
        titlePanel.setPreferredSize(new Dimension(700, 100));
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainOptionPanel.add(titlePanel);

        JLabel title = new JLabel("Dictionary");
        title.setFont(assets.getArialBoldTitle());
        title.setForeground(assets.getMainColorWhiteBG());
        titlePanel.add(title);

        JLabel descriptionTitle = new JLabel("Learning Options");
        descriptionTitle.setFont(assets.getArial_desc());
        descriptionTitle.setForeground(assets.getMainColorWhiteBG());
        descriptionTitle.setBorder(new EmptyBorder(10, 0, 0, 0));
        titlePanel.add(descriptionTitle);

        // Option Panel
        JPanel optionPanel = optionPanel();
        optionPanel.setPreferredSize(new Dimension(700, 450));
        mainOptionPanel.add(optionPanel);
    }

    public JPanel optionPanel(){
        JPanel optionPanel = new JPanel();
        optionPanel.setBackground(null);
        optionPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
        optionPanel.setLayout(new GridLayout(1, 3, 10, 20));


        //Abakada Option
        RoundedPanel abakadaOption = new RoundedPanel(15, 15, 15, 15);
        abakadaOption.setBackground(assets.getMainColorWhithy());
        abakadaOption.setLayout(new BorderLayout());
        abakadaOption.setBorder(new EmptyBorder(20, 20, 20, 20));
        optionPanel.add(abakadaOption);

        JPanel abakadaTitlePanel = new JPanel();
        abakadaTitlePanel.setBackground(null);
        abakadaTitlePanel.setLayout(new BorderLayout());
        abakadaOption.add(abakadaTitlePanel, BorderLayout.NORTH);

        JLabel abakadaTitle = new JLabel("AbaKada");
        abakadaTitle.setHorizontalTextPosition(JLabel.LEFT);
        abakadaTitle.setFont(assets.getArialBoldTitle());
        abakadaTitle.setForeground(assets.getMainColorBlackTxt());
        abakadaTitlePanel.add(abakadaTitle, BorderLayout.CENTER);

        JPanel abakadaDescPanel = new JPanel();
        abakadaDescPanel.setLayout(new BorderLayout());
        abakadaDescPanel.setBackground(null);
        abakadaDescPanel.setBorder(new EmptyBorder(50, 0, 20, 0));
        abakadaOption.add(abakadaDescPanel, BorderLayout.CENTER);

        JLabel abakadaDesc = new JLabel();
        abakadaDesc.setText("<html>The AbaKada section " +
                "introduces the Filipino " +
                "alphabet, providing " +
                "phonetic sounds and " +
                "example words for each letter.<br><br>" +
                "This helps learners understand " +
                "the basics of pronunciation " +
                "vocabulary.</html");
        abakadaDesc.setForeground(assets.getMainColorBlackTxt());
        abakadaDesc.setFont(assets.getArial());
        abakadaDesc.setVerticalAlignment(JLabel.NORTH);
        abakadaDescPanel.add(abakadaDesc, BorderLayout.CENTER);

        JPanel abakadaBtnPanel = new JPanel();
        abakadaBtnPanel.setBackground(null);
        abakadaBtnPanel.setLayout(new BorderLayout());
        abakadaBtnPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
        abakadaOption.add(abakadaBtnPanel, BorderLayout.SOUTH);

        RoundedButton btn_abakada = new RoundedButton();
        btn_abakada.setText("Open");
        btn_abakada.setRadius(10);
        btn_abakada.setFont(assets.getArialBold());
        btn_abakada.setForeground(assets.getMainColorWhiteBG());
        btn_abakada.setColor(assets.getMainColorYellowBG());
        btn_abakada.setColorClick(assets.getYellowColorClick());
        btn_abakada.setColorOver(assets.getYellowColorOver());
        btn_abakada.setBorderColor(assets.getMainColorWhithy());
        btn_abakada.setFocusable(false);
        btn_abakada.setBorder(null);
        btn_abakada.setPreferredSize(new Dimension(40, 40));
        abakadaBtnPanel.add(btn_abakada);

        // WPW Option
        RoundedPanel WpwOption = new RoundedPanel(15, 15, 15, 15);
        WpwOption.setBackground(assets.getMainColorDarkGreen());
        WpwOption.setLayout(new BorderLayout());
        WpwOption.setBorder(new EmptyBorder(20, 20, 20, 20));
        optionPanel.add(WpwOption);

        JPanel wpwTitlePanel = new JPanel();
        wpwTitlePanel.setBackground(null);
        wpwTitlePanel.setLayout(new BorderLayout());
        WpwOption.add(wpwTitlePanel, BorderLayout.NORTH);

        JLabel wpwTitle = new JLabel("WpW");
        wpwTitle.setHorizontalTextPosition(JLabel.LEFT);
        wpwTitle.setFont(assets.getArialBoldTitle());
        wpwTitle.setForeground(assets.getMainColorWhiteBG());
        wpwTitlePanel.add(wpwTitle, BorderLayout.CENTER);

        JPanel wpwDescPanel = new JPanel();
        wpwDescPanel.setLayout(new BorderLayout());
        wpwDescPanel.setBackground(null);
        wpwDescPanel.setBorder(new EmptyBorder(50, 0, 20, 0));
        WpwOption.add(wpwDescPanel, BorderLayout.CENTER);

        JLabel wpwDesc = new JLabel();
        wpwDesc.setText("<html>The Word per Word Section " +
                "offers a comprehensive list of " +
                "common Filipino words, " +
                "complete with English " +
                "translations and definitions.<br><br>" +
                "Learners can explore words " +
                "categorized by types such as nouns, " +
                "verbs, and adjectives.</html");
        wpwDesc.setForeground(assets.getMainColorWhiteBG());
        wpwDesc.setFont(assets.getArial());
        wpwDesc.setVerticalAlignment(JLabel.NORTH);
        wpwDescPanel.add(wpwDesc, BorderLayout.CENTER);

        JPanel wpwBtnPanel = new JPanel();
        wpwBtnPanel.setBackground(null);
        wpwBtnPanel.setLayout(new BorderLayout());
        wpwBtnPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
        WpwOption.add(wpwBtnPanel, BorderLayout.SOUTH);

        RoundedButton btn_wpw = new RoundedButton();
        btn_wpw.setText("Open");
        btn_wpw.setRadius(10);
        btn_wpw.setFont(assets.getArialBold());
        btn_wpw.setForeground(assets.getMainColorWhiteBG());
        btn_wpw.setColor(assets.getMainColorYellowBG());
        btn_wpw.setColorClick(assets.getYellowColorClick());
        btn_wpw.setColorOver(assets.getYellowColorOver());
        btn_wpw.setBorderColor(assets.getMainColorDarkGreen());
        btn_wpw.setFocusable(false);
        btn_wpw.setBorder(null);
        btn_wpw.setPreferredSize(new Dimension(40, 40));
        wpwBtnPanel.add(btn_wpw);

        // Common Phrases Option
        RoundedPanel commonPhrasesOption = new RoundedPanel(15, 15, 15, 15);
        commonPhrasesOption.setBackground(assets.getMainColorDarkGreen());
        commonPhrasesOption.setLayout(new BorderLayout());
        commonPhrasesOption.setBorder(new EmptyBorder(20, 20, 20, 20));
        optionPanel.add(commonPhrasesOption);

        JPanel commonPhrasesTitlePanel = new JPanel();
        commonPhrasesTitlePanel.setBackground(null);
        commonPhrasesTitlePanel.setLayout(new BorderLayout());
        commonPhrasesOption.add(commonPhrasesTitlePanel, BorderLayout.NORTH);

        JLabel commonPhrasesTitle = new JLabel("<html>Common<br> Phrases</html>");
        commonPhrasesTitle.setHorizontalTextPosition(JLabel.LEFT);
        commonPhrasesTitle.setFont(new Font("Arial", Font.BOLD, 25));
        commonPhrasesTitle.setForeground(assets.getMainColorWhiteBG());
        commonPhrasesTitlePanel.add(commonPhrasesTitle, BorderLayout.CENTER);

        JPanel commonPhrasesDescPanel = new JPanel();
        commonPhrasesDescPanel.setLayout(new BorderLayout());
        commonPhrasesDescPanel.setBackground(null);
        commonPhrasesDescPanel.setBorder(new EmptyBorder(30, 0, 20, 0));
        commonPhrasesOption.add(commonPhrasesDescPanel, BorderLayout.CENTER);

        JLabel commonPhrasesDesc = new JLabel();
        commonPhrasesDesc.setText("<html>The Common Phrases section " +
                "features essential Filipino " +
                "phrases used in everyday conversation.<br><br> " +
                "Organized into categories like " +
                "greetings and introductions, " +
                "each phrase includes English translations and " +
                "basic pronunciation.</html");
        commonPhrasesDesc.setForeground(assets.getMainColorWhiteBG());
        commonPhrasesDesc.setFont(assets.getArial());
        commonPhrasesDesc.setVerticalAlignment(JLabel.NORTH);
        commonPhrasesDescPanel.add(commonPhrasesDesc, BorderLayout.CENTER);

        JPanel commonPhrasesBtnPanel = new JPanel();
        commonPhrasesBtnPanel.setBackground(null);
        commonPhrasesBtnPanel.setLayout(new BorderLayout());
        commonPhrasesBtnPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
        commonPhrasesOption.add(commonPhrasesBtnPanel, BorderLayout.SOUTH);

        RoundedButton btn_commonPhrases = new RoundedButton();
        btn_commonPhrases.setText("Open");
        btn_commonPhrases.setRadius(10);
        btn_commonPhrases.setFont(assets.getArialBold());
        btn_commonPhrases.setForeground(assets.getMainColorWhiteBG());
        btn_commonPhrases.setColor(assets.getMainColorYellowBG());
        btn_commonPhrases.setColorClick(assets.getYellowColorClick());
        btn_commonPhrases.setColorOver(assets.getYellowColorOver());
        btn_commonPhrases.setBorderColor(assets.getMainColorDarkGreen());
        btn_commonPhrases.setFocusable(false);
        btn_commonPhrases.setBorder(null);
        btn_commonPhrases.setPreferredSize(new Dimension(40, 40));
        commonPhrasesBtnPanel.add(btn_commonPhrases);

        return optionPanel;
    }
}
