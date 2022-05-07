import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGUI extends JFrame implements ActionListener {
    JFrame window;
    Container con;
    JPanel titleNamePanel,startButtonPanel, QuestionPanel,choiceButtonPanel;
    JLabel titleNameLabel;

    JButton startButton,aboutButton,teamButton,exitButton,choice1,choice2,choice3,choice4;
    Font normalFont = new Font("Times New Roman",Font.PLAIN,50);


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
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("B");
        choice2.setBackground(Color.BLACK);
        choice2.setFont(normalFont);
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("C");
        choice3.setBackground(Color.BLACK);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("D");
        choice4.setBackground(Color.BLACK);
        choice4.setFont(normalFont);
        choiceButtonPanel.add(choice4);
        con.add(choiceButtonPanel);
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
        }
        if(e.getSource() == aboutButton){
            //team info
        }
    };
    public static void main (String[] args){
        new TestGUI();
    }
}

