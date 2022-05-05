import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGUI extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu file, about;
    JMenuItem start,exit,info,team;


    public TestGUI() {
        menuBar = new JMenuBar();


        file = new JMenu("File");
        menuBar.add(file);
        start = new JMenuItem("Start");
        exit = new JMenuItem("Exit");
        file.add(start);
        file.add(exit);

        about = new JMenu("About");
        menuBar.add(about);
        info = new JMenuItem("info");
        team = new JMenuItem("team");
        about.add(info);
        about.add(team);
        exit.addActionListener(this);
        JLabel Title = new JLabel("Trivia Maze");
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setFont(new Font("Arial", Font.BOLD, 40));

        this.add(Title);
        this.setJMenuBar(menuBar);


    }

    public static void main (String[] args){
        TestGUI frame = new TestGUI();
        frame.setVisible(true);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
            //pop up maze panel or question panel
        }
        if(e.getSource() == exit){
            System.exit(0);
        }
        if(e.getSource() == info){
            //pop up how maze will work
        }
        if(e.getSource() == team){
            //team info
        }
    }
}
