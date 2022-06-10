package view;

import javax.swing.*;

import model.*;

import java.awt.*;

/**
 * This class sets up a panel to show the player for information and
 * Health Points remaining. This panel is a part of the larger Game Board
 * and the JFrame it creates.
 */
public class InfoPanel extends JPanel
{
    private JTextPane myHealth;
    private JTextPane myInfo;

    /**
     * Constructor to set up the panel and associated text.
     * It also sets up the initial Health Points for the
     * Player.
     * @param theGame Parameter for the Game that this is for.
     */
    public InfoPanel(final Game theGame)
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
     * This method changes the Health of the player when an
     * answer is incorrect.
     * @param theGame Parameter for the Game that this is for.
     */
    public void changeHealthBar(final Game theGame)
    {
        this.myHealth.setText("HEALTH: " + theGame.getHealth());
    }
}
