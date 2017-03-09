package com.mtmercer.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class DrawTicTacToePane extends JPanel implements ComponentListener {

    DrawTicTacToePane() {
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
        super.paintComponent(g);
        int x = this.getWidth();
        int y = this.getHeight();
        Dimension size = new Dimension(x, y);

        this.drawGrid(g, size);
    }

    private void drawGrid(Graphics g, Dimension d) {
        g.drawLine(d.width/3, d.height, d.width/3, 0);
        g.drawLine((d.width/3) * 2, d.height, (d.width/3) * 2, 0);
        g.drawLine(d.width, d.height/3, 0, d.height/3);
        g.drawLine(d.width, (d.height/3) * 2, 0, (d.height/3) * 2);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Rectangle b = getParent().getBounds();
        // Makes the tictactoe view always a square based in the parent
        if(b.width < b.height) {
            e.getComponent().setBounds(b.x, b.y, b.width, b.width);
        }
        else {
            e.getComponent().setBounds(b.x, b.y, b.height, b.height);
        }
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    //TODO: Implement X and O draw

}
