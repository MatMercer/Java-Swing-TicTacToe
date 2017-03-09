package com.mtmercer.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class TicTacToe extends JFrame {
    //TODO: Implement game logic and drawer
    //TODO: Make a class to the jframe, and another class that controls it

    public TicTacToe() {
        super("TicTacToe");

        //TODO: Add dynamic thread wait here

        // Load the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException e) {
            System.err.println("Failed to set the default system look and feel: " + e.getMessage());
        }

        // Setup the root frame
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300, 300);

        // Setup the layout
        this.setLayout(new BorderLayout());

        // Add the drawer panel
        this.add(new DrawTicTacToePane());

        // Pack the layout and centers the frame
        this.pack();
        this.setLocationRelativeTo(null); // Starts at the center of the screen
    }

    public void play() {
        this.setVisible(true);
    }
}
