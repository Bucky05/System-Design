package org.example.states;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Player;
import org.example.models.SnakeOrLadder;
import org.example.services.StateTracker;

import java.util.List;
import java.util.Map;

public class PlayingState implements GameStateInterface{

    List<Player> players;
    Board board;
    Map<Cell, SnakeOrLadder> snakeOrLadderMap;
    public void play(){}
    public int rollDice(){return 1;}
    public void move(){}

    public PlayingState( List<Player> players,
                         Board board,
                         Map<Cell, SnakeOrLadder> snakeOrLadderMap) {
        this.players = players;
        this.board = board;
        this.snakeOrLadderMap = snakeOrLadderMap;
    }

    @Override
    public void play(StateTracker stateTracker) {

    }

    @Override
    public int rollDice(StateTracker stateTracker) {
        return 0;
    }

    @Override
    public void move(StateTracker stateTracker) {

    }

    public void initializeGame(StateTracker stateTracker, int rows, int cols, List<List<Integer>> snakeOrLadder, List<String> players) {

    }
}
