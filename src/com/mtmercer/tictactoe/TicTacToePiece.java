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
        if(this.getType() == TicTacToePieceType.O) {
            return "O";
        }
        else if(this.getType() == TicTacToePieceType.X) {
            return "X";
        }
        else {
            return ".";
        }
    }
}
