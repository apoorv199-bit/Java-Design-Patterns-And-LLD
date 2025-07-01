package org.library.LLD.TicTacToe;

import org.library.LLD.TicTacToe.constants.PieceType;
import org.library.LLD.TicTacToe.factory.PlayerFactory;
import org.library.LLD.TicTacToe.models.Game;
import org.library.LLD.TicTacToe.models.Player;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args){
        Queue<Player> players = new LinkedList<>();
        players.offer(PlayerFactory.createPlayer("Apoorv", PieceType.X, "Human"));
        players.offer(PlayerFactory.createPlayer("Harshita", PieceType.O, "Human"));

        Game game = new Game(3, players);
        game.startGame();
    }
}
