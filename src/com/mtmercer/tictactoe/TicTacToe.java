package com.mtmercer.tictactoe;

import org.jetbrains.annotations.Nullable;

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

    @Nullable
    private TicTacToePieceType getWinnerInLine(int line) {
        // A test piece to check if the line is all the same
        TicTacToePiece testPiece = this.getGameBoard()[line][0];

        // If the first piece that is being tested is null, so the line isn't completed
        if(testPiece == null) {
            return null;
        }

        for(int i = 1; i < 3; i++) {
            // If it encounters a piece that isn't equals returns that the line isn't completed
            if(!testPiece.equals(this.getGameBoard()[line][i])) {
                return null;
            }
        }

        // Returs who wins in the line
        return testPiece.getType();
    }

    @Nullable
    private TicTacToePieceType checkWinnerInLines() {
        // Checks for a winner in all the lines
        for(int i = 0; i < 3; i++) {
            TicTacToePieceType winner = getWinnerInLine(i);

            // If someones wins, returns it
            if (winner != null) {
                return winner;
            }
        }

        return null;
    }


    @Nullable
    private TicTacToePieceType getWinnerInColumn(int column) {
        // A test piece to check if the line is all the same
        TicTacToePiece testPiece = this.getGameBoard()[0][column];

        // If the first piece that is being tested is null, so the column isn't completed
        if(testPiece == null) {
            return null;
        }

        for(int i = 1; i < 3; i++) {
            // If it encounters a piece that isn't equals returns that the column isn't completed
            if(!testPiece.equals(this.getGameBoard()[i][column])) {
                return null;
            }
        }

        // Returs who wins in the column
        return testPiece.getType();
    }

    @Nullable
    private TicTacToePieceType checkWinnerInColumns() {
        // Checks for a winner in all the columns
        for(int i = 0; i < 3; i++) {
            TicTacToePieceType winner = getWinnerInColumn(i);

            // If someones wins, returns it
            if (winner != null) {
                return winner;
            }
        }

        return null;
    }

    @Nullable
    private TicTacToePieceType checkWinnerInDiagonals() {
        // \ diagonal
        TicTacToePiece testPiece = this.getGameBoard()[0][0];
        if (testPiece != null) {
            for(int i = 1; i < 3; i++) {
                if(!testPiece.equals(this.getGameBoard()[i][i])) {
                    testPiece = null;
                    break;
                }
            }
        }

        if (testPiece != null) {
            return testPiece.getType();
        }

        // / diagonal
        testPiece = this.getGameBoard()[0][2];
        if (testPiece != null) {
            for(int i = 1; i < 3; i++) {
                if(!testPiece.equals(this.getGameBoard()[i][2 - i])) {
                    testPiece = null;
                    break;
                }
            }
        }

        if (testPiece != null) {
            return testPiece.getType();
        }
        else {
            return null;
        }

    }

    public TicTacToePieceType winner() {
        TicTacToePieceType winner = null;

        winner = this.checkWinnerInLines();
        if(winner != null) {
            return winner;
        }

        winner = this.checkWinnerInColumns();
        if(winner != null) {
            return winner;
        }

        winner = this.checkWinnerInDiagonals();

        return winner;
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
