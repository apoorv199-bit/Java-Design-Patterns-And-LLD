package org.library.LLD.TicTacToe.models;

import org.library.LLD.TicTacToe.constants.PieceType;

public class Cell {
    private int row, col;
    private PieceType pieceType;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }

    public PieceType getPieceType(){
        return this.pieceType;
    }

    public void setPieceType(PieceType piece){
        this.pieceType = piece;
    }
}
