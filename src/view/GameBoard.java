package view;

import java.io.File;
import java.util.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;

import model.*;

/**
 *
 */
public class GameBoard
{
    private static final long serialVersionUID = 1L;

    private Game myGame;
    private MazePanel myMazePanel;

    private JFrame myBoard;
    private JFrame endOfGame;
    private QuestionPanel myQuestionPanel;
    private InfoPanel myInfoPanel;

    private JButton myNorthButton;
    private JButton myEastButton;
    private JButton mySouthButton;
    private JButton myWestButton;

    private JButton mySubmitButton;

    private boolean myNorthEnabled;
    private boolean myEastEnabled;
    private boolean mySouthEnabled;
    private boolean myWestEnabled;

    public GameBoard()
    {
        myNorthEnabled = false;
        myEastEnabled = false;
        mySouthEnabled = false;
        myWestEnabled = false;
    }

    /**
     *
     */
    public void buildBoard()
    {
        myBoard = new JFrame("Java Trivia Maze");

        this.myGame = new Game(4);

        this.myMazePanel = new MazePanel(this.myGame);
        myMazePanel.setBounds(700, 10, 300, 200);
        myBoard.add(myMazePanel);

        myQuestionPanel = new QuestionPanel();
        myQuestionPanel.setBounds(10, 10, 500, 380);
        myBoard.add(myQuestionPanel);

        myInfoPanel = new InfoPanel(myGame);
        myInfoPanel.setBounds(600, 500, 300, 300);
        myBoard.add(myInfoPanel);

        myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myBoard.setSize(1000, 800);

        this.myNorthButton = new JButton("North");
        this.myNorthButton.setBounds(100, 650, 90, 25);
        this.myNorthButton.addActionListener(moveNorthButton);
        myBoard.add(myNorthButton);

        this.myEastButton = new JButton("East");
        this.myEastButton.setBounds(190, 675, 90, 25);
        this.myEastButton.addActionListener(moveEastButton);
        myBoard.add(myEastButton);

        this.mySouthButton = new JButton("South");
        this.mySouthButton.setBounds(100, 700, 90, 25);
        this.mySouthButton.addActionListener(moveSouthButton);
        myBoard.add(mySouthButton);

        this.myWestButton = new JButton("West");
        this.myWestButton.setBounds(10, 675, 90, 25);
        this.myWestButton.addActionListener(moveWestButton);
        myBoard.add(myWestButton);

        this.mySubmitButton = new JButton("Submit");
        this.mySubmitButton.setBounds(120, 400, 90, 20);
        this.mySubmitButton.addActionListener(submitButton);
        myBoard.add(mySubmitButton);

        myBoard.setLayout(null);
        myQuestionPanel.setLayout(null);
        myInfoPanel.setLayout(null);

        myBoard.setVisible(true);
        myMazePanel.setVisible(true);
        myQuestionPanel.setVisible(false);
        myInfoPanel.setVisible(true);

        myMazePanel.setStartRoom();
        myMazePanel.setEndRoom(myGame);

        System.out.println(myGame);

        disableMoveButtons();
        mySubmitButton.setEnabled(false);
        checkDoors();
    }

    private void checkDoors()
    {
        Room currLocation = myGame.getCurrentLocation();

        if (currLocation.getType() != RoomType.TOP_LEFT && currLocation.getType() != RoomType.TOP &&
                currLocation.getType() != RoomType.TOP_RIGHT)
        {
            myNorthButton.setEnabled(true);
        }
        if (currLocation.getType() != RoomType.TOP_LEFT && currLocation.getType() != RoomType.LEFT &&
                currLocation.getType() != RoomType.BOT_LEFT)
        {
            myWestButton.setEnabled(true);
        }
        if (currLocation.getType() != RoomType.BOT_LEFT && currLocation.getType() != RoomType.BOT &&
                currLocation.getType() != RoomType.BOT_RIGHT)
        {
            mySouthButton.setEnabled(true);
        }
        if (currLocation.getType() != RoomType.TOP_RIGHT && currLocation.getType() != RoomType.RIGHT)
        {
            myEastButton.setEnabled(true);
        }
    }

    private void displayQuestion(Door theDoor)
    {
        this.myQuestionPanel.initializeQuestionData(theDoor.getQuestion());
        this.myQuestionPanel.setVisible(true);
        System.out.println(theDoor.getQuestion().getQuestion());

        Stack<String> myAnswers = theDoor.getQuestion().getAnswer();
        while (myAnswers.size() > 0)
        {
            System.out.println(myAnswers.pop());
        }

        disableMoveButtons();
        mySubmitButton.setEnabled(true);
    }

    public void play(String fileName)
    {
        try
        {
            File file = new File(fileName);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/10000);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    private void disableMoveButtons()
    {
        this.myNorthButton.setEnabled(false);
        this.myEastButton.setEnabled(false);
        this.mySouthButton.setEnabled(false);
        this.myWestButton.setEnabled(false);
    }

    private void endGameOptions()
    {
        JTextPane message = new JTextPane();
        message.setText("Do you want to play again?");
        message.setBounds(10, 10, 180, 20);
        message.setEditable(false);

        endOfGame = new JFrame("Do you want to play again?");
        endOfGame.setSize(200, 200);
        endOfGame.setBounds(0, 0, 200, 200);

        JButton yesButton = new JButton("Yes");
        yesButton.setBounds(30, 75, 60, 25);

        yesButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                myBoard.dispose();
                buildBoard();
                endOfGame.dispose();
            }
        });

        JButton noButton = new JButton("No");
        noButton.setBounds(100, 75, 60, 25);

        noButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        endOfGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endOfGame.setLayout(null);

        endOfGame.add(message);
        endOfGame.add(yesButton);
        endOfGame.add(noButton);
        endOfGame.setVisible(true);
    }

    ActionListener moveNorthButton = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            displayQuestion(myGame.getCurrentLocation().getNorthDoor());

            myNorthEnabled = true;
        }
    };

    ActionListener moveEastButton = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            displayQuestion(myGame.getCurrentLocation().getEastDoor());

            myEastEnabled = true;
        }
    };

    ActionListener moveSouthButton = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            displayQuestion(myGame.getCurrentLocation().getSouthDoor());

            mySouthEnabled = true;
        }
    };

    ActionListener moveWestButton = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            displayQuestion(myGame.getCurrentLocation().getWestDoor());

            myWestEnabled = true;
        }
    };

    ActionListener submitButton = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (myQuestionPanel.isAnswerCorrect())
            {
                int currentRow = myGame.getCurrentRow();
                int currentColumn = myGame.getCurrentColumn();

                if (myNorthEnabled)
                {
                    myGame.moveNorth();
                }
                else if (myEastEnabled)
                {
                    myGame.moveEast();
                }
                else if (mySouthEnabled)
                {
                    myGame.moveSouth();
                }
                else if (myWestEnabled)
                {
                    myGame.moveWest();
                }

                myMazePanel.setCurrentRoom(currentRow, currentColumn, myGame);

                JOptionPane.showMessageDialog(myQuestionPanel, "Correct!");
                play("questionRight.wav");

                if (myGame.isMyGameWon())
                {
                    JOptionPane.showMessageDialog(myMazePanel, "You win!");
                    play("winGame.wav");
                    endGameOptions();
                }
            }
            else
            {
                myGame.minusHealth();
                myInfoPanel.changeHealthBar(myGame);
                JOptionPane.showMessageDialog(myQuestionPanel, "Incorrect!");
                play("questionWrong.wav");

                if (myGame.isMyGameLost())
                {
                    JOptionPane.showMessageDialog(myQuestionPanel, "You Lose!");
                    play("failGame.wav");
                    endGameOptions();
                }
            }

            myNorthEnabled = false;
            myEastEnabled = false;
            mySouthEnabled = false;
            myWestEnabled = false;

            myQuestionPanel.setVisible(false);
            mySubmitButton.setEnabled(false);
            checkDoors();
        }
    };
}
