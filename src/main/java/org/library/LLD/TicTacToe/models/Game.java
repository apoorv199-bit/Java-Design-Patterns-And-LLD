package org.library.LLD.TicTacToe.models;

import java.util.Queue;

public class Game {
    private final Queue<Player> players;
    private final Board board;

    public Game(int size, Queue<Player> players){
        this.board = new Board(size);
        this.players = players;
    }

    public void startGame(){
        boolean gameEnd = false;
        while(!gameEnd){
            board.displayBoard();
            Player currentPlayer = players.poll();
            currentPlayer.makeMove(board);
            if(board.checkWin(currentPlayer.getPiece())){
                System.out.println(currentPlayer.getName() + " won the game.");
                gameEnd = true;
            }
            if(board.isAllCellFlled()){
                System.out.println("Game draw.");
                gameEnd = true;
            }
            players.offer(currentPlayer);
        }
    }

}
