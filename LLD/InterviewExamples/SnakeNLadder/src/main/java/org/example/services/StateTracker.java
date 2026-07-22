package org.example.services;

import org.example.states.GameStateInterface;

import java.util.List;

public class StateTracker {

    GameStateInterface gameState;

    public StateTracker(GameStateInterface gameState) {
        this.gameState = gameState;
    }

    public void changeState(GameStateInterface gameState) {
        this.gameState = gameState;
    }

    public void play(){
        gameState.play();
    }
    public int rollDice(){
        return gameState.rollDice();
    }
    public void move(){
        gameState.move();
    };
    public void initializeGame(int rows, int cols, List<List<Integer>> snakeOrLadder,  List<String> players){
        gameState.initializeGame( rows,  cols,  snakeOrLadder,  players);
    };

    public void addPlayer(String name){
        gameState.addPlayer(name);
    };
}
