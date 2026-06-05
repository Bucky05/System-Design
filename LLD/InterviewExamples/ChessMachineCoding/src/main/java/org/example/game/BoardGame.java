package org.example.game;

import org.example.models.Board.Board;
import org.example.models.Pieces.Move;
import org.example.models.Players.Player;

import java.util.Queue;

public abstract class BoardGame {

    protected final Queue<Player> players;
    protected final Board board;
    protected BoardGame(Board board, Queue<Player> players) {

        this.board = board;
        this.players = players;
    }
    protected abstract boolean isGameOver();
    public abstract void showBoard();
    public void startGame() throws Exception {
        // TODO Implement start game
        while(true) {
            Player curr = players.poll();

            Move move = curr.makeMove();
            if(move == null) throw new Exception("Invalid move");
            this.board.applyMove(move, board); // TODO implement try catch and repeat player's chance

            if(isGameOver()) {
                System.out.println("Game over");
                System.out.println(curr.getName() + "wins");
                break;
            }

            players.add(curr);

        }
    }
}
