package com.mtmercer;

import com.mtmercer.tictactoe.TicTacToePanel;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public Game() {
        super("TicTacToe");

        //TODO: Add dynamic thread wait here

        // Load the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException e) {
            System.err.println("Failed to set the default system look and feel: " + e.getMessage());
        }

        // Setup the root frame
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300, 300);

        // Setup the layout
        this.setLayout(new BorderLayout());

        // Add the drawer panel
        this.add(new TicTacToePanel());

        // Pack the layout and centers the frame
        this.pack();
        this.setLocationRelativeTo(null); // Starts at the center of the screen

        // Starts the application
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}
