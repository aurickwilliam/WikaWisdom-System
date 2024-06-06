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

public class QuizPanel extends JPanel implements ActionListener {
    static Assets assets = new Assets();

    // vars
    private int index = 0;
    private String[] questions;
    private String correct_answer;
    private int score = 0;
    private String currentCard = "";

    public static boolean isCompleted = false;

    // Layout
    private CardLayout quizCardLayout;

    // Panel
    private JPanel panel_quiz, resultPanel, level = new LevelPanel();

    // Label
    private JLabel questionLabel, greetings, scoreLabel;

    // Buttons
    private RoundedButton choice1, choice2, choice3, choice4, btn_goBack;
    private JButton next;

    public QuizPanel(String level_name){
        quizCardLayout = new CardLayout() ;
        setBackground(null);
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(quizCardLayout);

        // Set description
        LevelPanel.getDescriptionTitle().setText("Quiz Time!");

        // Get the questions
        questions = listOfQuestions(level_name);
        System.out.println(Arrays.toString(questions));

        panel_quiz = new JPanel();
        panel_quiz.setName("QUIZ");
        currentCard = panel_quiz.getName();
        panel_quiz.setBackground(null);
        panel_quiz.setLayout(new BorderLayout());
        add(panel_quiz, panel_quiz.getName());

        JPanel quiz = quiz();
        quiz.setBackground(null);
        panel_quiz.add(quiz, BorderLayout.CENTER);

        resultPanel = result();
        resultPanel.setName("RESULT");
        resultPanel.setBackground(null);
        add(resultPanel, resultPanel.getName());

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

        quizCardLayout.show(this, currentCard);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == choice1){
            System.out.println("A");
            if (correct_answer.equals("A")){
                score++;
            }
            index++;
            System.out.println("SCORE: " + score);
        }else if (actionEvent.getSource() == choice2){
            System.out.println("B");
            if (correct_answer.equals("B")){
                score++;
            }
            index++;
            System.out.println("SCORE: " + score);
        }else if (actionEvent.getSource() == choice3){
            System.out.println("C");
            if (correct_answer.equals("C")){
                score++;
            }
            index++;
            System.out.println("SCORE: " + score);
        }else if (actionEvent.getSource() == choice4){
            System.out.println("D");
            if (correct_answer.equals("D")){
                score++;
            }
            index++;
            System.out.println("SCORE: " + score);
        }

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
            quizCardLayout.show(this, currentCard);

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

            isCompleted = true;
//
//            JOptionPane.showMessageDialog(null,
//                    greet + "\n\nScore: " + final_score,
//                    "Score", JOptionPane.INFORMATION_MESSAGE);

            LevelPanel.getLevelCardLayout().show(level, LevelPanel.getMainLevelPanel().getName());

            System.out.println("FINAL SCORE: " + score);
            System.out.println("DONE");
        }
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

        JPanel backBtnPanel = new JPanel();
        backBtnPanel.setBackground(null);
        backBtnPanel.setLayout(new BorderLayout());
        contentPanel.add(backBtnPanel, BorderLayout.SOUTH);

        btn_goBack = new RoundedButton();
        btn_goBack.setText("Go Back");
        btn_goBack.setFont(assets.getArialBold());
        btn_goBack.setRadius(15);
        btn_goBack.setColor(assets.getMainColorYellowBG());
        btn_goBack.setColorOver(assets.getYellowColorOver());
        btn_goBack.setColorClick(assets.getYellowColorClick());
        btn_goBack.setBorderColor(assets.getMainColorYellowBG());
        btn_goBack.setFocusable(false);
        btn_goBack.setBorder(null);
        btn_goBack.setPreferredSize(new Dimension(0, 40));
        btn_goBack.addActionListener(this);
        backBtnPanel.add(btn_goBack, BorderLayout.CENTER);

        return mainPanel;
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
