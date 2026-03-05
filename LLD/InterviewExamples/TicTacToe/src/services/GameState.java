package services;

import enums.GameStates;
import enums.VictoryStrategyEnum;
import models.Player;

public interface GameState {

    int getBoardSize(int n);
    void addPlayer(String name, char symbol);
    void move(int row, int col);
    boolean checkVictory(char symbol);
    GameStates getCurrentState();
    void changeState(GameState state);
    void initGame(int boardSize, int numOfPlayers, VictoryStrategyEnum strategyEnum);
    void undo();
    void endGame();
}
