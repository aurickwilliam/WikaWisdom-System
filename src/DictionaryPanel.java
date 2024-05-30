import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DictionaryPanel extends JPanel implements ActionListener, MouseListener {
    Assets assets = new Assets();
    // Layout
    private static CardLayout dictionaryCardLayout;

    // Variables
    private String currentCard = "";
    private String previousCard = "";
    private String selectedAlphabet = "";


    // Buttons
    private JButton btn_back;
    private RoundedButton btn_abakada, btn_wpw, btn_commonPhrases;

    // Table
    private JTable table;

    // Label
    private JLabel alphabet;

    // Panels
    private static JPanel mainOptionPanel;
    private static JPanel mainAbakadaPanel;
    private static JPanel mainEachAlphabetPanel;
    private static JPanel mainWpwPanel;
    private static JPanel mainCommonPhraPanel;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btn_abakada){
            System.out.println("ABAKADA");
            currentCard = mainAbakadaPanel.getName();
            dictionaryCardLayout.show(this, currentCard);
        }else if (actionEvent.getSource() == btn_wpw){
            System.out.println("WPW");
            currentCard = mainWpwPanel.getName();
            dictionaryCardLayout.show(this, currentCard);
        }else if (actionEvent.getSource() == btn_commonPhrases){
            System.out.println("COMMON PHRASES");
            currentCard = mainCommonPhraPanel.getName();
            dictionaryCardLayout.show(this, currentCard);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2){
            int row = table.getSelectedRow();
            int column = table.getSelectedColumn();
            selectedAlphabet = (String) table.getValueAt(row, column);
            System.out.println("Sa double Click toh: " + selectedAlphabet);
            alphabet.setText(selectedAlphabet);
            currentCard = mainEachAlphabetPanel.getName();
            dictionaryCardLayout.show(this, currentCard);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public DictionaryPanel(){
        dictionaryCardLayout = new CardLayout();
        setLayout(dictionaryCardLayout);
        setBorder(new EmptyBorder(20, 20, 20, 20));

        // MainOptionPanel
        mainOptionPanel = new JPanel();
        mainOptionPanel.setLayout(new FlowLayout());
        mainOptionPanel.setName("OPTION_PANEL");
        currentCard = mainOptionPanel.getName();
        add(mainOptionPanel, mainOptionPanel.getName());

        Header(mainOptionPanel, "Dictionary", "Learning Options");

        // Option Panel
        JPanel optionPanel = optionPanel();
        optionPanel.setPreferredSize(new Dimension(700, 450));
        mainOptionPanel.add(optionPanel);

        // Hides the back button when it is in option panel
        if (currentCard.equals("OPTION_PANEL")){
            btn_back.setVisible(false);
        }

        // Abakada Panel
        mainAbakadaPanel = new JPanel();
        mainAbakadaPanel.setName("ABAKADA");
        mainAbakadaPanel.setBackground(assets.getMainColorWhiteBG());
        add(mainAbakadaPanel, mainAbakadaPanel.getName());

        Header(mainAbakadaPanel, "AbaKada", "Alphabets and Vocabulary");

        JPanel abakadaPanel = abakadaPanel();
        abakadaPanel.setPreferredSize(new Dimension(700, 470));
        mainAbakadaPanel.add(abakadaPanel);

        // Each Alphabet
        mainEachAlphabetPanel = new JPanel();
        mainEachAlphabetPanel.setName("EACH ALPHA");
        mainEachAlphabetPanel.setBackground(assets.getMainColorWhiteBG());
        add(mainEachAlphabetPanel, mainEachAlphabetPanel.getName());

        Header(mainEachAlphabetPanel, "AbaKada", "Each Alphabet");

        JPanel eachAlphaPanel = eachAlphabetPanel();
        eachAlphaPanel.setPreferredSize(new Dimension(700, 470));
        mainEachAlphabetPanel.add(eachAlphaPanel);

        // WPW Panel
        mainWpwPanel = new JPanel();
        mainWpwPanel.setLayout(new FlowLayout());
        mainWpwPanel.setName("WPW");
        mainWpwPanel.setBackground(null);
        add(mainWpwPanel, mainWpwPanel.getName());

        Header(mainWpwPanel, "Word Per Word", "Filipino word = English word");

        JPanel wpwPanel = wpwPanel();
        wpwPanel.setPreferredSize(new Dimension(700, 470));
        mainWpwPanel.add(wpwPanel);

        // TODO: Add individual meaning to each word

        // Common Phrases
        mainCommonPhraPanel = new JPanel();
        mainCommonPhraPanel.setName("COMMON_PHRA");
        mainCommonPhraPanel.setBackground(null);
        add(mainCommonPhraPanel, mainCommonPhraPanel.getName());

        Header(mainCommonPhraPanel, "Common Phrases", "Common Sentences that can be use");

        JPanel commonPhraCategory = commonPhraCategory();
        commonPhraCategory.setPreferredSize(new Dimension(700, 470));
        mainCommonPhraPanel.add(commonPhraCategory);
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
            // For ABAKADA
            if(currentCard.equals("ABAKADA")){
                previousCard = mainOptionPanel.getName();
                currentCard = previousCard;
            }else if (currentCard.equals("EACH ALPHA")){
                previousCard = mainAbakadaPanel.getName();
                currentCard = previousCard;
            }

            // For WPW
            if (currentCard.equals("WPW")){
                previousCard = mainOptionPanel.getName();
                currentCard = previousCard;
            }

            // For Common Phrases
            if (currentCard.equals("COMMON_PHRA")){
                previousCard = mainOptionPanel.getName();
                currentCard = previousCard;
            }

            dictionaryCardLayout.show(this, previousCard);
        });
        backBtnPanel.add(btn_back, BorderLayout.CENTER);
    }

    public JPanel optionPanel(){
        JPanel optionPanel = new JPanel();
        optionPanel.setBackground(null);
        optionPanel.setBorder(new EmptyBorder(20, 10, 0, 10));
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

        btn_abakada = new RoundedButton();
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
        btn_abakada.addActionListener(this);
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

        btn_wpw = new RoundedButton();
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
        btn_wpw.addActionListener(this);
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

        btn_commonPhrases = new RoundedButton();
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
        btn_commonPhrases.addActionListener(this);
        commonPhrasesBtnPanel.add(btn_commonPhrases);

        return optionPanel;
    }

    public JPanel abakadaPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 10, 20, 10));
        mainPanel.setBackground(null);

        RoundedPanel tablePanel = new RoundedPanel(15, 15, 15, 15);
        tablePanel.setBackground(assets.getMainColorWhithy());
        tablePanel.setPreferredSize(new Dimension(30, 30));
        tablePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        tablePanel.setLayout(new BorderLayout());
        mainPanel.add(tablePanel);

        Object[][] alphabets = Alphabet();
        String[] headerColumn = {"A", "E", "I", "O", "U"};
        table = new JTable(alphabets, headerColumn){
            // Disable the edit in Table
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setFont(assets.getArial());
        table.setForeground(assets.getMainColorBlackTxt());
        table.setSelectionBackground(assets.getMainColorDarkGreen());
        table.setSelectionForeground(assets.getMainColorWhiteBG());
        table.setShowVerticalLines(true);
        table.getTableHeader().setFont(assets.getArialBold());
        table.setBorder(null);
        table.setRowHeight(25);

        // Center the text in each Cell
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        table.addMouseListener(this);

        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        return mainPanel;
    }

    public JPanel eachAlphabetPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(null);
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        RoundedPanel background = new RoundedPanel(15, 15, 15, 15);
        background.setPreferredSize(new Dimension(300, 300));
        background.setBackground(assets.getMainColorDarkGreen());
        background.setLayout(new BorderLayout());
        mainPanel.add(background);

        alphabet = new JLabel();
        alphabet.setForeground(assets.getMainColorWhithy());
        alphabet.setFont(new Font("Arial", Font.BOLD, 75));
        alphabet.setHorizontalAlignment(JLabel.CENTER);
        background.add(alphabet, BorderLayout.CENTER);

        return mainPanel;
    }

    public Object[][] Alphabet(){
        try {
            FileReader filePath = new FileReader(assets.getAlphabetFilePath());
            BufferedReader reader = new BufferedReader(filePath);
            ArrayList<String> alphabets = new ArrayList<String>();
            String line = "";
            while ((line = reader.readLine()) != null){
                alphabets.add(line);
            }
            int no_cols = alphabets.getFirst().split(",").length;

            Object[][] data = new Object[alphabets.size()][no_cols];
            for (int i = 0; i < alphabets.size(); i++) {
                data[i] = alphabets.get(i).split(",");
            }
            reader.close();

            return data;

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error Reading Alphabet File!",
                    "Reading File",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public JPanel wpwPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(null);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BorderLayout());

        String[] list = getEveryWord(assets.getWpwFilePath());

        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new GridLayout(list.length, 1, 20, 20));
        scrollPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        scrollPanel.setBackground(assets.getMainColorWhithy());

        JScrollPane scrollPane = new JScrollPane(scrollPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        for (int i = 0; i < list.length; i++) {
            String fil = list[i].split(",")[0];
            String eng = list[i].split(",")[1];

            RoundedButton btn_word = new wpwContainerPanel(fil, eng);
            btn_word.addActionListener(e -> {
                System.out.println("Click " + fil + " = " + eng);
            });
            scrollPanel.add(btn_word);
        }

        return mainPanel;
    }

//    public JPanel eachWPWPanel(){
//        JPanel mainPanel = new JPanel();
//
//        return mainPanel;
//    }

    public JPanel commonPhraCategory(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(null);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.red);

        JScrollPane scrollPane = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        return mainPanel;
    }



    public String[] getEveryWord(String filePath){
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
                    "Error Reading Word Per Word File!",
                    "Reading File",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static CardLayout getDictionaryCardLayout() {
        return dictionaryCardLayout;
    }

    public static JPanel getMainAbakadaPanel() {
        return mainAbakadaPanel;
    }

    public static JPanel getMainOptionPanel() {
        return mainOptionPanel;
    }
}
