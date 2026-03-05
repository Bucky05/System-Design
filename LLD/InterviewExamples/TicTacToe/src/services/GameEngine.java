package services;

import enums.GameStates;
import enums.VictoryStrategyEnum;
import models.Board;
import models.Player;
import strategies.VictoryStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GameEngine {



    private Board board;
    private List<Player> playerList;
    private Stack<int[]> movesStack ;
    private InputValidator inputValidator;
    private int numberOfPlayers;
    private GameState state;
    private VictoryStrategy victoryStrategy;
    int moveCount ;
    public GameEngine() {

        this.inputValidator = new InputValidator();
        this.state = new InitGameState(this);
    }

    Board getBoard() {
        return this.board;
    }

    List<Player> getPlayerList() {
        return this.playerList;
    }

    Stack<int[]> getMovesStack() {
        return movesStack;
    }

    void undo() {
        state.undo();
    }

    public void initGame(int boardSize, int numberOfPlayers, VictoryStrategyEnum strategy) {
        state.initGame(boardSize,numberOfPlayers,strategy);

    }

    public int getMoveCount(){
        return this.moveCount;
    }
    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
    public VictoryStrategy getVictoryStrategy() {
        return this.victoryStrategy;
    }
    void setVictoryStrategy(VictoryStrategy strategy) {
        this.victoryStrategy = strategy;

    }

    void setBoard(Board board) {
        this.board = board;
    }
    void setPlayerList(int n) {
        playerList = new ArrayList<>(n);
        numberOfPlayers = n;
    }

    int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void move(int row, int col) {
        state.move(row,col);
    }

    public void addPlayer(String name, char symbol) {
        state.addPlayer(name,symbol);
    }

    public InputValidator getInputValidator() {
        return inputValidator;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameStates getState() {
        return this.state.getCurrentState();
    }

    public void endGame() {
        this.state.endGame();
    }
}
