package org.library.LLD.TicTacToe.models;

import org.library.LLD.TicTacToe.constants.PieceType;

public class Board {
    private final int size;
    private final Cell[][] board;

    public Board(int size){
        this.size = size;
        this.board = new Cell[size][size];
        initializeBoard();
    }

    private void initializeBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = new Cell(i, j);
            }
        }
    }

    public boolean isMoveVaild(int row, int col){
        return (row >= 0 && row < size) && (col >= 0 && col < size) && board[row][col].getPieceType() == null;
    }

    public boolean isAllCellFlled(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j].getPieceType() == null){
                    return false;
                }
            }
        }
        return true;
    }

    public void makeMove(int row, int col, PieceType piece){
        board[row][col].setPieceType(piece);
    }

    public void displayBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j].getPieceType() == null){
                    System.out.print(" _ ");
                }else {
                    System.out.print(" " + board[i][j].getPieceType() + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean checkWin(PieceType piece){
        // Rows
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++)
                if (board[i][j].getPieceType() != piece)
                    win = false;
            if (win) return true;
        }

        // Columns
        for (int j = 0; j < size; j++) {
            boolean win = true;
            for (int i = 0; i < size; i++)
                if (board[i][j].getPieceType() != piece)
                    win = false;
            if (win) return true;
        }

        // Diagonals
        boolean win = true;
        for (int i = 0; i < size; i++)
            if (board[i][i].getPieceType() != piece)
                win = false;
        if (win) return true;

        win = true;
        for (int i = 0; i < size; i++)
            if (board[i][size - 1 - i].getPieceType() != piece)
                win = false;

        return win;
    }
}
