package view;

import javax.swing.*;

import model.*;

import java.awt.*;

/**
 *
 */
public class InfoPanel extends JPanel
{
    private JTextPane myHealth;
    private JTextPane myInfo;

    /**
     *
     * @param theGame
     */
    public InfoPanel(Game theGame)
    {
        this.myInfo = new JTextPane();
        this.myInfo.setBounds(0, 0, 200, 50);
        this.myInfo.setText("Player is in black.\nExit is in green.");
        this.myInfo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        this.myInfo.setBackground(null);
        this.myInfo.setEditable(false);

        this.myHealth = new JTextPane();
        this.myHealth.setBounds(0, 80, 100, 50);
        this.myHealth.setText("HEALTH: " + theGame.getHealth());
        this.myHealth.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        this.myHealth.setBackground(null);
        this.myHealth.setEditable(false);

        add(myInfo);
        add(myHealth);
    }

    /**
     *
     * @param theGame
     */
    public void changeHealthBar(Game theGame)
    {
        this.myHealth.setText("HEALTH: " + theGame.getHealth());
    }
}
