package com.mtmercer.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class TicTacToePanel extends JPanel implements ComponentListener, ActionListener {
    //TODO: Implement game logic in a different class
    private TicTacToe ticTacToeGame;

    public TicTacToePanel() {
        // Instantiates the tictactoe game
        this.ticTacToeGame = new TicTacToe();

        //TODO: Change the background color
        // Implements the component listener
        this.addComponentListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Calculates what is the current size of the screen
        super.paintComponent(g);
        int x = this.getWidth();
        int y = this.getHeight();
        Dimension size = new Dimension(x, y);

        // Draw the grid
        this.drawGrid(g, size);

        // Draw the game
        this.drawTicTacToeGame(g, size);
    }

    private void drawGrid(Graphics g, Dimension d) {
        // Draws the lines based on 1/3 of the screen
        g.drawLine(d.width / 3, d.height, d.width / 3, 0);
        g.drawLine((d.width / 3) * 2, d.height, (d.width / 3) * 2, 0);
        g.drawLine(d.width, d.height / 3, 0, d.height / 3);
        g.drawLine(d.width, (d.height / 3) * 2, 0, (d.height / 3) * 2);
    }

    private void drawTicTacToeGame(Graphics g, Dimension d) {
        // It is based in the size of the square - sqrsize/10 of it
        int shapeWidth = (d.width / 3) - d.width / 10;
        // Where the shape should be draw, a constant to automatically centers the shape in the square based in the idx
        int centerRatio = (d.width / 3);
        // Center constant with shape padding
        int shapePaddingConst = (d.width / 10) / 2;

        int i = 0;
        for (TicTacToePiece[] row : this.ticTacToeGame.getGameBoard()) {
            int j = 0;
            for (TicTacToePiece piece : row) {
                if (piece != null) {
                    if(piece.getType() == TicTacToePieceType.O) {
                        g.drawOval(
                                centerRatio * i + shapePaddingConst,
                                centerRatio * j + shapePaddingConst,
                                shapeWidth,
                                shapeWidth);
                    }
                    else if (piece.getType() == TicTacToePieceType.X){
                        // '\' part of the X
                        g.drawLine(
                                centerRatio * i + shapePaddingConst,
                                centerRatio * j + shapePaddingConst,
                                (centerRatio * i + shapePaddingConst) + shapeWidth,
                                (centerRatio * j + shapePaddingConst) + shapeWidth
                        );
                        // '/' part of the X
                        g.drawLine(
                                (centerRatio * i + shapePaddingConst) + shapeWidth,
                                centerRatio * j + shapePaddingConst,
                                centerRatio * i + shapePaddingConst,
                                (centerRatio * j + shapePaddingConst) + shapeWidth
                        );
                    }
                }
                j += 1;
            }
            i += 1;
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Rectangle b = getParent().getBounds();
        // Makes the tictactoe view always a square based in the parent
        if (b.width < b.height) {
            e.getComponent().setBounds(b.x, b.y, b.width, b.width);
        } else {
            e.getComponent().setBounds(b.x, b.y, b.height, b.height);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: Add game logic class and a matrix to control the game inside it
    }

    //TODO: Implement X and O draw

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

}
