package org.example.states;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Player;
import org.example.models.SnakeOrLadder;
import org.example.services.StateTracker;

import java.util.List;
import java.util.Map;

public class GameOverState implements GameStateInterface{

    List<Player> players;
    Board board;
    Map<Cell, SnakeOrLadder> snakeOrLadderMap;

    public GameOverState( List<Player> players,
    Board board,
    Map<Cell, SnakeOrLadder> snakeOrLadderMap) {
        this.players = players;
        this.board = board;
        this.snakeOrLadderMap = snakeOrLadderMap;
    }
    public void play(StateTracker stateTracker){}
    public int rollDice(StateTracker stateTracker){return 1;}
    public void move(StateTracker stateTracker){};
    public void initializeGame(StateTracker gameTracker, int rows, int cols, List<List<Integer>> snakeOrLadder, List<String> players) {

    }

}
