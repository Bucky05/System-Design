package org.example.game;

import org.example.models.Board.ChessBoard;
import org.example.models.Helpers.Color;
import org.example.models.Players.ChessPlayer;
import org.example.models.Players.PlayerFactory;

public class GameFactory {

    public static BoardGame createNewChessGame() {
        ChessBoard b = new ChessBoard();
        ChessPlayer p1 = PlayerFactory.createPlayer("Alice", Color.WHITE,b);
        ChessPlayer p2 = PlayerFactory.createPlayer("Bob", Color.BLACK,b);
        return new ChessGame(b,p1,p2);
    }
}
