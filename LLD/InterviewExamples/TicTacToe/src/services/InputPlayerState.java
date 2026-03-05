package services;

import enums.GameStates;
import enums.VictoryStrategyEnum;
import factories.PlayerFactory;
import factories.VictoryStrategyFactory;
import models.Player;

import java.util.List;

public class InputPlayerState implements GameState{

    GameEngine engine;

    public InputPlayerState(GameEngine engine) {
        this.engine = engine;
    }
    @Override
    public int getBoardSize(int n) {
        return engine.getBoard().getSize();
    }

    @Override
    public void addPlayer(String name, char symbol) {
        List<Player> list = engine.getPlayerList();
        if(!engine.getInputValidator().validateSymbol(list,symbol)) {
            throw new IllegalArgumentException("Symbol already in use");
        }

        list.add(PlayerFactory.create(list.size()+1,name,symbol));
        if(!engine.getInputValidator().validatePlayer(list,engine.getNumberOfPlayers())) {
            changeState(new GameOnState(engine));
        }
    }

    @Override
    public void move(int row, int col) {
        throw new IllegalStateException("Cannot make a move until all the players are registered");
    }

    @Override
    public boolean checkVictory(char symbol) {
        throw new IllegalStateException("Cannot check victory until all the players are registered");
    }

    @Override
    public GameStates getCurrentState() {
        return GameStates.INPUT_PLAYERS;
    }

    @Override
    public void changeState(GameState state) {
        engine.setState(state);
    }

    @Override
    public void initGame(int boardSize, int numOfPlayers, VictoryStrategyEnum strategyEnum) {
        throw new IllegalStateException("Game already initialized");
    }

    @Override
    public void undo(){
        throw new IllegalStateException("Cannot undo before starting the game");
    }

    @Override
    public void endGame() {
        changeState(new InitGameState(engine));
    }
}
