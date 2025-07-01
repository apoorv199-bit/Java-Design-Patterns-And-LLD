package org.library.LLD.TicTacToe.models;

import org.library.LLD.TicTacToe.constants.PieceType;

public abstract class Player {
    private final String name;
    private final PieceType piece;

    protected Player(String name, PieceType piece){
        this.name = name;
        this.piece = piece;
    }

    public abstract void makeMove(Board board);

    public PieceType getPiece(){
        return this.piece;
    }

    public String getName(){
        return this.name;
    }
}
