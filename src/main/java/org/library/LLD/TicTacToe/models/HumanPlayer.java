package org.library.LLD.TicTacToe.models;

import org.library.LLD.TicTacToe.constants.PieceType;

import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(String name, PieceType piece){
        super(name, piece);
    }

    @Override
    public void makeMove(Board board) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println(this.getName() + " (" + this.getPiece() + ")" + " Enter row and col: ");
            String[] split = sc.nextLine().split(",");
            int row = Integer.parseInt(split[0]);
            int col = Integer.parseInt(split[1]);

            if(board.isMoveVaild(row, col)){
                board.makeMove(row, col, this.getPiece());
                return;
            }else{
                System.out.println("Invalid move, try again!");
            }
        }
    }
}
