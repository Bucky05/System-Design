package services;

import enums.GameStates;
import enums.VictoryStrategyEnum;
import models.Player;

public class EndState implements GameState{

    private GameEngine engine;

    public EndState(GameEngine engine) {
        this.engine = engine;
    }

    @Override
    public int getBoardSize(int n) {
        return engine.getBoard().getSize();
    }

    @Override
    public void addPlayer(String name, char symbol) {
        throw new IllegalStateException("Cannot add player after the game");
    }

    @Override
    public void move(int row, int col) {
        throw new IllegalStateException("Cannot make a move after the game");
    }

    @Override
    public boolean checkVictory(char symbol) {
        return engine.getVictoryStrategy().checkVictory(engine.getBoard().getTable(),symbol);
    }

    @Override
    public GameStates getCurrentState() {
        return GameStates.ENDED;
    }

    @Override
    public void changeState(GameState state) {
        this.engine.setState(state);
    }

    @Override
    public void initGame(int boardSize, int numOfPlayers, VictoryStrategyEnum strategyEnum) {
        throw new IllegalStateException("Cannot init game after the game ended");
    }

    @Override
    public void undo() {
        throw new IllegalStateException("Cannot undo after the game ended");
    }

    @Override
    public void endGame() {
        changeState(new InitGameState(engine));
    }
}
