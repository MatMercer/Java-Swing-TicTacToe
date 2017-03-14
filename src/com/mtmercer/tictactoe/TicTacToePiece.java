package com.mtmercer.tictactoe;

public class TicTacToePiece {

    private TicTacToePieceType type;

    public TicTacToePiece(TicTacToePieceType type) {
        this.type = type;
    }

    public TicTacToePieceType getType() {
        return type;
    }

    @Override
    public String toString() {
        if (this.getType() == TicTacToePieceType.O) {
            return "O";
        } else if (this.getType() == TicTacToePieceType.X) {
            return "X";
        } else {
            return ".";
        }
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == null) {
            return false;
        }
        if (ob.getClass() != getClass()) {
            return false;
        }

        TicTacToePiece otherPiece = (TicTacToePiece)ob;

        return otherPiece.getType() == this.getType();
    }
}
