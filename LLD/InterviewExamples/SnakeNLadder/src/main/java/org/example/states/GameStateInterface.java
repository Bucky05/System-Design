package org.example.states;

import org.example.services.StateTracker;

import java.util.List;

public interface GameStateInterface {

    void play(StateTracker stateTracker);
    int rollDice(StateTracker stateTracker);
    void move(StateTracker stateTracker);
    void initializeGame(StateTracker stateTracker, int rows, int cols, List<List<Integer>> snakeOrLadder, List<String> players);


}
