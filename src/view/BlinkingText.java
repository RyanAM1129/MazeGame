package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates text that blinks for the main menu.
 */
public class BlinkingText implements ActionListener
{
    private JLabel myLabel;
    private Color myColor1 = java.awt.Color.white;
    private Color myColor2 = java.awt.Color.yellow;
    private int myCount;

    /**
     * Constructor for the blinking text that takes a JLabel
     * and that is the label to work with to create blinking text.
     * @param label Parameter for the
     */
    public BlinkingText(final JLabel label)
    {
        this.myLabel = label;
    }

    @Override
    /**
     * Method that overrides the actionPerformed() method
     * from the ActionListener class. This is for color
     * changing for the blinking text.
     */
    public void actionPerformed(final ActionEvent e)
    {
        if(myCount % 2 == 0)
            myLabel.setForeground(myColor1);
        else
            myLabel.setForeground(myColor2);
        this.myCount++;
    }
}
