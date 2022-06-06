package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainMenu
{
    private static final long serialVersionUID = 1L;

    private JFrame myStartMenu;
    private JLabel myTitle;
    private Timer myTimer;

    public MainMenu()
    {
        start();
    }

    private void start()
    {
        GameBoard game = new GameBoard();

        this.myStartMenu = new JFrame();
        this.myStartMenu.setTitle("Java Trivia Maze");
        this.myStartMenu.setBounds(0, 0, 600, 450);
        this.myStartMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.myStartMenu = new JFrame("Java Trivia Maze");

        try
        {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("src/images/startMenu.jpeg"));
            this.myStartMenu.setContentPane(new JPanel(new BorderLayout())
            {
                @Override
                public void paintComponent(Graphics g)
                {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        myTitle = new JLabel("Java Trivia Maze");
        myTitle.setBounds(200, 0, 600, 200);
        myTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.myTimer = new Timer(1000, new BlinkingText(myTitle));
        myTimer.start();

        JButton startButton = new JButton("Play");
        startButton.setBounds(250, 200, 100, 30);

        startButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                myTimer.stop();
                myStartMenu.dispose();
                game.buildBoard();
            }
        });

        JButton loadButton = new JButton("Load");
        loadButton.setBounds(250, 240, 100, 30);

        loadButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                myTimer.stop();
                myStartMenu.dispose();
                game.buildBoard();
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(250, 280, 100, 30);

        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        this.myStartMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.myStartMenu.add(myTitle);
        this.myStartMenu.add(startButton);
        this.myStartMenu.add(loadButton);
        this.myStartMenu.add(exitButton);
        this.myStartMenu.setSize(600, 400);
        this.myStartMenu.setLayout(null);
    }

    public JFrame getStartMenu()
    {
        return this.myStartMenu;
    }
}
