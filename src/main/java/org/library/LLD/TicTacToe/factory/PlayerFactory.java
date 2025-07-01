package org.library.LLD.TicTacToe.factory;

import org.library.LLD.TicTacToe.constants.PieceType;
import org.library.LLD.TicTacToe.models.HumanPlayer;
import org.library.LLD.TicTacToe.models.Player;

public class PlayerFactory {
    public static Player createPlayer(String name, PieceType pieceType, String type){
        switch (type){
            case "Human":
                return new HumanPlayer(name, pieceType);
            default:
                throw new IllegalArgumentException("Incorrect player type.");
        }
    }
}
