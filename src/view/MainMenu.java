package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * This class creates the main menu JFrame and associated buttons for the Java Trivia Maze game.
 */
public class MainMenu
{
    //Previous work attempting serialization
    private static final long serialVersionUID = 1L;

    private JFrame myStartMenu;
    private JLabel myTitle;
    private Timer myTimer;

    /**
     * The default constructor simply calls on the start() method which contains all logic for
     * creating and initializing the Main Menu and its functionality.
     */
    public MainMenu()
    {
        start();
    }

    /**
     * This method creates, and initializes all functionality of the Main menu. It is left private for
     * encapsulation reasons.
     */
    private void start()
    {
        GameBoard game = new GameBoard();

        this.myStartMenu = new JFrame();
        this.myStartMenu.setTitle("Java Trivia Maze");
        this.myStartMenu.setBounds(0, 0, 600, 450);
        this.myStartMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.myStartMenu = new JFrame("Java Trivia Maze");

        //This try block is for the image file used in the background of the main menu
        try
        {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("startMenu.jpeg"));
            this.myStartMenu.setContentPane(new JPanel(new BorderLayout())
            {
                @Override
                public void paintComponent(Graphics g)
                {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        }
        catch (final IOException e)
        {
            e.printStackTrace();
        }

        myTitle = new JLabel("Java Trivia Maze");
        myTitle.setBounds(200, 0, 600, 200);
        myTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.myTimer = new Timer(1000, new BlinkingText(myTitle));
        myTimer.start();

        JButton playButton = new JButton("Play");
        playButton.setBounds(250, 200, 100, 30);

        //The Play button starts a new game
        playButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent e)
            {
                myTimer.stop();
                myStartMenu.dispose();
                game.buildBoard();
            }
        });

        JButton loadButton = new JButton("Load");
        loadButton.setBounds(250, 240, 100, 30);

        //This button would have been the load button but does what the Play button does currently
        loadButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent e)
            {
                myTimer.stop();
                myStartMenu.dispose();
                game.buildBoard();
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(250, 280, 100, 30);

        //This button simply closes the game when pressed
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent e)
            {
                System.exit(0);
            }
        });

        this.myStartMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.myStartMenu.add(myTitle);
        this.myStartMenu.add(playButton);
        this.myStartMenu.add(loadButton);
        this.myStartMenu.add(exitButton);
        this.myStartMenu.setSize(600, 400);
        this.myStartMenu.setLayout(null);
    }

    /**
     * Getter for the myStartMenu variable of this class.
     * @return Returns the myStartMenu variable of this class.
     */
    public JFrame getStartMenu()
    {
        return this.myStartMenu;
    }
}
