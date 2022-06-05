package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlinkingText implements ActionListener
{
    private JLabel myLabel;
    private Color myColor1 = java.awt.Color.white;
    private Color myColor2 = java.awt.Color.yellow;
    private int myCount;

    public BlinkingText(JLabel label)
    {
        this.myLabel = label;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(myCount % 2 == 0)
            myLabel.setForeground(myColor1);
        else
            myLabel.setForeground(myColor2);
        this.myCount++;
    }
}
