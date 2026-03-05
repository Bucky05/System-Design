package services;

import enums.GameStates;
import enums.VictoryStrategyEnum;
import factories.VictoryStrategyFactory;
import models.Board;
import models.Player;

public class InitGameState implements GameState {

    GameEngine engine;

    public InitGameState(GameEngine engine) {
        this.engine = engine;
    }
    @Override
    public void addPlayer(String name, char symbol) {
        throw new IllegalStateException("Cannot add players before setting up the board");
    }

    @Override
    public void move(int row, int col) {

        throw new IllegalStateException("Cannot play before setting up the board");
    }

    @Override
    public boolean checkVictory(char symbol) {
        throw new IllegalStateException("Cannot check victory before setting up the board");
    }

    @Override
    public int getBoardSize(int n) {
        throw new IllegalStateException("Cannot get board size before setting up the board");
    }

    @Override
    public GameStates getCurrentState() {
        return GameStates.INIT;
    }

    @Override
    public void changeState(GameState state) {
        engine.setState(state);
    }

    @Override
    public void initGame(int boardSize, int numOfPlayers, VictoryStrategyEnum victoryStrategyEnum) {

        engine.setBoard(new Board(boardSize));
        engine.setPlayerList(numOfPlayers);
        engine.setVictoryStrategy(VictoryStrategyFactory.create(victoryStrategyEnum));
        engine.setMoveCount(0);
        changeState(new InputPlayerState(engine));

    }

    @Override
    public void undo() {
        throw new IllegalStateException("Cannot undo before starting");
    }

    @Override
    public void endGame() {
        throw new IllegalArgumentException("Cannot end game before initializing");
    }
}
