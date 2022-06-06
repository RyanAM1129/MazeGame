package view;

import java.awt.*;

/**
 *
 */
public class BeginGame
{
    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    MainMenu menu = new MainMenu();
                    menu.getStartMenu().setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
