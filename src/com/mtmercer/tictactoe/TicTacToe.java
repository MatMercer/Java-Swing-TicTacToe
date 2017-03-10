package com.mtmercer.tictactoe;

import java.security.InvalidParameterException;

public class TicTacToe {
    private TicTacToePiece[][] gameBoard;

    public TicTacToe() {
        // Creates the game board
        this.gameBoard = new TicTacToePiece[3][3];
    }

    public TicTacToePiece[][] getGameBoard() {
        return this.gameBoard;
    }

    private void insertPieceAt(TicTacToePieceType type, int row, int column) throws InvalidParameterException {
        // Does the row and column is valid?
        if (row < 0 || column < 0 || row > 2 || column > 2) {
            throw new InvalidParameterException("Invalid row or column index, it must be greater than 0 and less than 2");
        }
        // Is there a piece in this index already?
        else if (this.gameBoard[row][column] != null) {
            throw new InvalidParameterException("There is already a piece in " + row + ":" + column + ".");
        } else {
            this.gameBoard[row][column] = new TicTacToePiece(type);
        }
    }

    public void insertXAt(int row, int column) throws InvalidParameterException {
        insertPieceAt(TicTacToePieceType.X, row, column);
    }

    public void insertOAt(int row, int column) throws InvalidParameterException {
        insertPieceAt(TicTacToePieceType.O, row, column);
    }

    //TODO: Implement this
    public TicTacToePieceType winner() {
        //TODO: Returns which piece type wins
        //TODO: Null if no one wins
        return null;
    }

    //TODO: Implement this
    public void resetGame() {
        //TODO: Resets the game
    }

    @Override
    public String toString() {
        String gameStr = "";

        for (TicTacToePiece[] row : this.gameBoard) {
            for (TicTacToePiece piece : row) {
                if (piece == null) {
                    gameStr += ".";
                } else {
                    gameStr += piece;
                }
            }
            gameStr += "\n";
        }

        return gameStr;
    }

}
