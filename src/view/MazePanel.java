package view;

import javax.swing.*;

import model.*;

public class MazePanel extends JPanel
{
    ImageIcon myIconEmptyRoom = new ImageIcon("EmptyRoom.jpeg");
    ImageIcon myIconCurrentRoom = new ImageIcon("CurrentRoom.jpeg");
    ImageIcon myIconExitRoom = new ImageIcon("ExitRoom.jpeg");
    ImageIcon myIconLockedRoom = new ImageIcon("LockedRoom.jpeg");

    private JLabel[][] myRoomImages;

    public MazePanel(Maze maze)
    {
        setLayout(null);

        JLabel lblHorizontalDoor_1_2_1_1 = new JLabel("");
        lblHorizontalDoor_1_2_1_1
                .setIcon(new ImageIcon("UnlockedHorizontalDoor.jpeg"));
        lblHorizontalDoor_1_2_1_1.setBounds(80, 160, 20, 10);
        add(lblHorizontalDoor_1_2_1_1);

        JLabel lblHorizontalDoor_1_1_1_1_1 = new JLabel("");
        lblHorizontalDoor_1_1_1_1_1
                .setIcon(new ImageIcon("UnlockedHorizontalDoor.jpeg"));
        lblHorizontalDoor_1_1_1_1_1.setBounds(130, 160, 20, 10);
        add(lblHorizontalDoor_1_1_1_1_1);

        JLabel lblHorizontalDoor_2_1_1 = new JLabel("");
        lblHorizontalDoor_2_1_1
                .setIcon(new ImageIcon("UnlockedHorizontalDoor.jpeg"));
        lblHorizontalDoor_2_1_1.setBounds(30, 160, 20, 10);
        add(lblHorizontalDoor_2_1_1);

        JLabel lblHorizontalDoor_1_2_1 = new JLabel("");
        lblHorizontalDoor_1_2_1
                .setIcon(new ImageIcon("UnlockedHorizontalDoor.jpeg"));
        lblHorizontalDoor_1_2_1.setBounds(80, 110, 20, 10);
        add(lblHorizontalDoor_1_2_1);

        JLabel lblHorizontalDoor_2_1 = new JLabel("");
        lblHorizontalDoor_2_1.setIcon(new ImageIcon("UnlockedHorizontalDoor.jpeg"));
        lblHorizontalDoor_2_1.setBounds(30, 110, 20, 10);
        add(lblHorizontalDoor_2_1);

        JLabel lblHorizontalDoor_1_1_1_1 = new JLabel("");
        lblHorizontalDoor_1_1_1_1
                .setIcon(new ImageIcon("UnlockedHorizontalDoor.jpeg"));
        lblHorizontalDoor_1_1_1_1.setBounds(130, 110, 20, 10);
        add(lblHorizontalDoor_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("");
        lblNewLabel_1_1_1_1.setIcon(new ImageIcon("UnlockedVerticalDoor.jpeg"));
        lblNewLabel_1_1_1_1.setBounds(160, 130, 10, 20);
        add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_3_1 = new JLabel("");
        lblNewLabel_3_1.setIcon(new ImageIcon("UnlockedVerticalDoor.jpeg"));
        lblNewLabel_3_1.setBounds(10, 130, 10, 20);
        add(lblNewLabel_3_1);

        JLabel lblRoomRowFourColumnThree = new JLabel("");
        lblRoomRowFourColumnThree.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowFourColumnThree.setBounds(100, 150, 30, 30);
        add(lblRoomRowFourColumnThree);

        JLabel lblRoomRowFourColumnTwo = new JLabel("");
        lblRoomRowFourColumnTwo.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowFourColumnTwo.setBounds(50, 150, 30, 30);
        add(lblRoomRowFourColumnTwo);

        JLabel lblRoomRowFourColumnOne = new JLabel("");
        lblRoomRowFourColumnOne.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowFourColumnOne.setBounds(0, 150, 30, 30);
        add(lblRoomRowFourColumnOne);

        JLabel lblRoomRowFourColumnFour = new JLabel("");
        lblRoomRowFourColumnFour.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowFourColumnFour.setBounds(150, 150, 30, 30);
        add(lblRoomRowFourColumnFour);

        JLabel lblNewLabel_2_1_1 = new JLabel("");
        lblNewLabel_2_1_1.setIcon(new ImageIcon("UnlockedVerticalDoor.jpeg"));
        lblNewLabel_2_1_1.setBounds(110, 130, 10, 20);
        add(lblNewLabel_2_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("");
        lblNewLabel_1_1_1.setIcon(new ImageIcon("UnlockedVerticalDoor.jpeg"));
        lblNewLabel_1_1_1.setBounds(160, 80, 10, 20);
        add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("");
        lblNewLabel_1_2.setIcon(new ImageIcon("UnlockedVerticalDoor.jpeg"));
        lblNewLabel_1_2.setBounds(60, 80, 10, 20);
        add(lblNewLabel_1_2);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("UnlockedVerticalDoor.jpeg"));
        lblNewLabel_3.setBounds(10, 80, 10, 20);
        add(lblNewLabel_3);

        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon("UnlockedVerticalDoor.jpeg"));
        lblNewLabel_2_1.setBounds(110, 80, 10, 20);
        add(lblNewLabel_2_1);

        JLabel lblNewLabel_1_2_1 = new JLabel("");
        lblNewLabel_1_2_1.setIcon(new ImageIcon("UnlockedVerticalDoor.jpeg"));
        lblNewLabel_1_2_1.setBounds(60, 130, 10, 20);
        add(lblNewLabel_1_2_1);

        JLabel lblRoomRowTwoColumnThree = new JLabel("");
        lblRoomRowTwoColumnThree.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowTwoColumnThree.setBounds(100, 50, 30, 30);
        add(lblRoomRowTwoColumnThree);

        JLabel lblRoomRowTwoColumnOne = new JLabel("");
        lblRoomRowTwoColumnOne.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowTwoColumnOne.setBounds(0, 50, 30, 30);
        add(lblRoomRowTwoColumnOne);

        JLabel lblRoomRowTwoColumnFour = new JLabel("");
        lblRoomRowTwoColumnFour.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowTwoColumnFour.setBounds(150, 50, 30, 30);
        add(lblRoomRowTwoColumnFour);

        JLabel lblRoomRowTwoColumnTwo = new JLabel("");
        lblRoomRowTwoColumnTwo.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowTwoColumnTwo.setBounds(50, 50, 30, 30);
        add(lblRoomRowTwoColumnTwo);

        JLabel lblHorizontalDoor_1_1 = new JLabel("");
        lblHorizontalDoor_1_1.setIcon(new ImageIcon("UnlockedHorizontalDoor.jpeg"));
        lblHorizontalDoor_1_1.setBounds(130, 10, 20, 10);
        add(lblHorizontalDoor_1_1);

        JLabel lblRoomRowThreeColumnFour = new JLabel("");
        lblRoomRowThreeColumnFour.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowThreeColumnFour.setBounds(150, 100, 30, 30);
        add(lblRoomRowThreeColumnFour);

        JLabel lblRoomRowThreeColumnOne = new JLabel("");
        lblRoomRowThreeColumnOne.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowThreeColumnOne.setBounds(0, 100, 30, 30);
        add(lblRoomRowThreeColumnOne);

        JLabel lblRoomRowThreeColumnTwo = new JLabel("");
        lblRoomRowThreeColumnTwo.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowThreeColumnTwo.setBounds(50, 100, 30, 30);
        add(lblRoomRowThreeColumnTwo);

        JLabel lblRoomRowThreeColumnThree = new JLabel("");
        lblRoomRowThreeColumnThree.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowThreeColumnThree.setBounds(100, 100, 30, 30);
        add(lblRoomRowThreeColumnThree);

        JLabel lblHorizontalDoor = new JLabel("");
        lblHorizontalDoor.setIcon(new ImageIcon("UnlockedHorizontalDoor.jpeg"));
        lblHorizontalDoor.setBounds(30, 10, 20, 10);
        add(lblHorizontalDoor);

        JLabel lblRoomRowOneColumnOne = new JLabel("");
        lblRoomRowOneColumnOne.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowOneColumnOne.setBounds(0, 0, 30, 30);
        add(lblRoomRowOneColumnOne);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("UnlockedVerticalDoor.jpeg"));
        lblNewLabel_2.setBounds(110, 30, 10, 20);
        add(lblNewLabel_2);

        JLabel lblRoomRowOneColumnThree = new JLabel("");
        lblRoomRowOneColumnThree.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowOneColumnThree.setBounds(100, 0, 30, 30);
        add(lblRoomRowOneColumnThree);

        JLabel lblHorizontalDoor_1 = new JLabel("");
        lblHorizontalDoor_1.setIcon(new ImageIcon("UnlockedHorizontalDoor.jpeg"));
        lblHorizontalDoor_1.setBounds(80, 10, 20, 10);
        add(lblHorizontalDoor_1);

        JLabel lblHorizontalDoor_1_1_1 = new JLabel("");
        lblHorizontalDoor_1_1_1
                .setIcon(new ImageIcon("UnlockedHorizontalDoor.jpeg"));
        lblHorizontalDoor_1_1_1.setBounds(130, 60, 20, 10);
        add(lblHorizontalDoor_1_1_1);

        JLabel lblRoomRowOneColumnFour = new JLabel("");
        lblRoomRowOneColumnFour.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowOneColumnFour.setBounds(150, 0, 30, 30);
        add(lblRoomRowOneColumnFour);

        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setIcon(new ImageIcon("UnlockedVerticalDoor.jpeg"));
        lblNewLabel_1_1.setBounds(160, 30, 10, 20);
        add(lblNewLabel_1_1);

        JLabel lblHorizontalDoor_2 = new JLabel("");
        lblHorizontalDoor_2.setIcon(new ImageIcon("UnlockedHorizontalDoor.jpeg"));
        lblHorizontalDoor_2.setBounds(30, 60, 20, 10);
        add(lblHorizontalDoor_2);

        JLabel lblRoomRowOneColumnTwo = new JLabel("");
        lblRoomRowOneColumnTwo.setIcon(new ImageIcon("EmptyRoom.jpeg"));
        lblRoomRowOneColumnTwo.setBounds(50, 0, 30, 30);
        add(lblRoomRowOneColumnTwo);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("UnlockedDoorVertical.jpeg"));
        lblNewLabel_1.setBounds(60, 30, 10, 20);
        add(lblNewLabel_1);

        JLabel lblHorizontalDoor_1_2 = new JLabel("");
        lblHorizontalDoor_1_2.setIcon(new ImageIcon("UnlockedHorizontalDoor.jpeg"));
        lblHorizontalDoor_1_2.setBounds(80, 60, 20, 10);
        add(lblHorizontalDoor_1_2);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("UnlockedVerticalDoor.jpeg"));
        lblNewLabel.setBounds(10, 30, 10, 20);
        add(lblNewLabel);

        myRoomImages = new JLabel[][]
        {
                { lblRoomRowOneColumnOne, lblRoomRowTwoColumnOne, lblRoomRowThreeColumnOne, lblRoomRowFourColumnOne },
                { lblRoomRowOneColumnTwo, lblRoomRowTwoColumnTwo, lblRoomRowThreeColumnTwo, lblRoomRowFourColumnTwo },
                { lblRoomRowOneColumnThree, lblRoomRowTwoColumnThree, lblRoomRowThreeColumnThree, lblRoomRowFourColumnThree },
                { lblRoomRowOneColumnFour, lblRoomRowTwoColumnFour, lblRoomRowThreeColumnFour, lblRoomRowFourColumnFour },
        };
    }

    private void setRoomIcon(int rowToSet, int columnToSet, ImageIcon icon)
    {
        this.myRoomImages[rowToSet][columnToSet].setIcon(icon);
    }

    public void setStartRoom()
    {
        setRoomIcon(0, 0, myIconCurrentRoom);
    }

    public void setEndRoom(Game roomToSet)
    {
        setRoomIcon(roomToSet.getSize() - 1, roomToSet.getSize() - 1, myIconExitRoom);
    }

    public void setCurrentRoom(int oldRow, int oldColumn, Game newLocation)
    {
        setRoomIcon(oldRow, oldColumn, myIconEmptyRoom);
        setRoomIcon(newLocation.getCurrentRow(), newLocation.getCurrentColumn(), myIconCurrentRoom);
        this.validate();
    }
}
