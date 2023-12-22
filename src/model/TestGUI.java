import org.sqlite.SQLiteDataSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class TestGUI extends JFrame implements ActionListener {
    JFrame window;
    Container con;
    JPanel titleNamePanel,startButtonPanel, QuestionPanel,choiceButtonPanel;
    JLabel titleNameLabel;

    JButton startButton,aboutButton,teamButton,exitButton,choice1,choice2,choice3,choice4,correctanswer;
    Font normalFont = new Font("Times New Roman",Font.PLAIN,50);
    JTextArea mainTextArea;
    ChoiceHandler choiceHandler = new ChoiceHandler();
    SQLiteDataSource ds;
    public TestGUI(){
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);

        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNameLabel = new JLabel("Trival Maze");

        titleNameLabel.setForeground(Color.BLUE);
        titleNameLabel.setFont(new Font("Times New Roman",Font.PLAIN,90));


        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);

        startButton = new JButton ("START");
        aboutButton = new JButton ("ABOUT");
        teamButton = new JButton ("TEAM");
        exitButton = new JButton ("EXIT");
        startButton.addActionListener(this);
        exitButton.addActionListener(this);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        startButtonPanel.add(teamButton);
        startButtonPanel.add(aboutButton);
        startButtonPanel.add(exitButton);
        con.add(titleNamePanel);
        con.add(startButtonPanel);

        window.setVisible(true);
    }
    public void createGameScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        QuestionPanel = new JPanel();
        QuestionPanel.setBounds(100,100,600,250);
        QuestionPanel.setBackground(Color.black);
        con.add(QuestionPanel);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);
        choice1 = new JButton("A");
        choice1.setBackground(Color.BLACK);
        choice1.setFont(normalFont);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("B");
        choice2.setBackground(Color.BLACK);
        choice2.setFont(normalFont);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("C");
        choice3.setBackground(Color.BLACK);
        choice3.setFont(normalFont);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("D");
        choice4.setBackground(Color.BLACK);
        choice4.setFont(normalFont);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        correctanswer = new JButton();


        mainTextArea = new JTextArea("Main text area");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        QuestionPanel.add(mainTextArea);


        con.add(choiceButtonPanel);

        getQuestion();
    }



    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            createGameScreen();
        }
        if(e.getSource() == exitButton){
            System.exit(0);
        }
        if(e.getSource() == teamButton){
            //pop up how maze will work
            getQuestion();
            System.out.println("NO");
        }
        if(e.getSource() == aboutButton){
            //team info
        }
    };

    public void getQuestion(){
        ds = null;
        try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:questions.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }
        String query = "SELECT * FROM questions ORDER BY random() LIMIT 1";
        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement(); ) {

            ResultSet rs = stmt.executeQuery(query);

            //walk through each 'row' of results, grab data by column/field name
            // and print it
            while ( rs.next() ) {
                String question = rs.getString( "QUESTION" );
                String answer1 = rs.getString( "ANSWER1" );
                String answer2 = rs.getString( "ANSWER2" );
                String answer3 = rs.getString( "ANSWER3" );
                String answer4 = rs.getString( "ANSWER4" );
                String correct = rs.getString("CORRECT");
                mainTextArea.setText(question);
                choice1.setText(answer1);
                choice2.setText(answer2);
                choice3.setText(answer3);
                choice4.setText(answer4);
                correctanswer.setText(correct);
                System.out.println( "Result: Question = " + question +
                        ", Answer1 = " + answer1 +", Answer2 = " + answer2 +", Answer3 = " + answer3+", Answer4 = " + answer4+", correct answer is" +
                        " = " + correct);
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }

    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            String cor = correctanswer.getText();
            if(Objects.equals(buttonText, cor)){
                getQuestion();
            }
            else {
                //mainTextArea.setText("Try again");
            }
        }

    }
    public static void main (String[] args){

        new TestGUI();
    }
}

