package org.example.states;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Player;
import org.example.models.SnakeOrLadder;
import org.example.services.StateTracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitializeState implements GameStateInterface{
    List<Player> players;
    Board board;
    Map<Cell, SnakeOrLadder> snakeOrLadderMap;


    public void play(){
        throw new IllegalStateException("Cant do before initialization");
    }
    public int rollDice(){
        throw new IllegalStateException("Cant do before initialization");
    }
    public void move(){
        throw new IllegalStateException("Cant do before initialization");
    };
    public void initializeGame(StateTracker gameTracker, int rows, int cols, List<List<Integer>> snakeOrLadder, List<String> players){
        this.players = new ArrayList<>();
        snakeOrLadderMap = new HashMap<>();
        List<Cell> cells = initializeBoard(rows, cols);

        initializeSnakeOrLadder(cells, snakeOrLadder,rows*cols);

        initializePlayers(players);
        gameTracker.changeState(new PlayingState(players,board,snakeOrLadderMap));

    };

    private void initializePlayers(List<String> players) {
        for(int i = 0 ; i < players.size(); i++) {
            this.players.add(new Player(i+1,players.get(i)));
        }
    }
    private List<Cell> initializeBoard(int rows, int cols) {
        List<Cell> cells = new ArrayList<>();
        for(int i = 0 ; i < rows; i++) {
            for(int j = 0 ; j < cols ; j++) {
                Cell curr = new Cell(i, j);
                cells.add(curr);
            }
        }
        board = new Board(rows, cols, cells);
        return cells;
    }

    private void initializeSnakeOrLadder(List<Cell> cells,List<List<Integer>> snakeOrLadder, int total ) {
        for(int i = 0 ; i < snakeOrLadder.size() ; i++) {
            int start = snakeOrLadder.get(i).get(0);
            int end = snakeOrLadder.get(i).get(1);

            if(start == end || start < 1 || end < 1 || start > total || end > total) {
                throw new IllegalArgumentException("start and end cannot be same");
            }

            if(start < end ) {
                SnakeOrLadder curr = new SnakeOrLadder(cells.get(start-1),cells.get(end-1),true);
                snakeOrLadderMap.put(cells.get(start-1),curr);
            } else {
                SnakeOrLadder curr = new SnakeOrLadder(cells.get(start-1),cells.get(end-1),false);
                snakeOrLadderMap.put(cells.get(start-1),curr);

            }
        }
    };
    private void addPlayer(String name){};
}
