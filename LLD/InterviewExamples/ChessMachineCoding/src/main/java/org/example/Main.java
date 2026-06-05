package org.example;

import org.example.game.BoardGame;
import org.example.game.ChessGame;
import org.example.game.GameFactory;
import org.example.models.Board.Board;
import org.example.models.Board.ChessBoard;
import org.example.models.Helpers.Color;
import org.example.models.Players.ChessPlayer;
import org.example.models.Players.Player;
import org.example.models.Players.PlayerFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        BoardGame game = GameFactory.createNewChessGame();
        game.showBoard();

        try {
            game.startGame();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}