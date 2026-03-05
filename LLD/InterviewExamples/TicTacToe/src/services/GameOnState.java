package services;

import enums.GameStates;
import enums.VictoryStrategyEnum;
import models.Player;

import java.util.Stack;

public class GameOnState implements GameState{

    GameEngine engine;

    public GameOnState(GameEngine engine) {
        this.engine = engine;
    }
    @Override
    public int getBoardSize(int n) {
        return engine.getBoard().getSize();
    }

    @Override
    public void addPlayer(String name, char symbol) {
        throw new IllegalStateException("Cannot add player in middle of the game");
    }

    @Override
    public void move(int row, int col) {
        if(!engine.getInputValidator().validateMove(engine.getBoard(),row,col)) {
            throw new IllegalArgumentException("Please provide valid row and col");
        }
        Player player = engine.getPlayerList().get(engine.moveCount%engine.getNumberOfPlayers());
        engine.getBoard().updateTable(row-1,col-1,player.getSymbol());
        engine.getBoard().printTable();
        if(checkVictory(player.getSymbol())) {
            System.out.println(player.getName()+" Won");
            changeState(new EndState(engine));
            return;
        }
        if(checkDraw()) {
            System.out.println("Draw");
            changeState(new EndState(engine));
            return;
        }

        engine.setMoveCount(engine.getMoveCount()+1);

    }

    private boolean checkDraw() {
        char[][] table = engine.getBoard().getTable();

        for(char row[] : table) {
            for(char cell : row) {
                if(cell == '\0') return false;
            }
        }

        return true;
    }
    @Override
    public boolean checkVictory(char symbol) {
        boolean isVictory = engine.getVictoryStrategy().checkVictory(engine.getBoard().getTable(),symbol);
        if(isVictory) {
            changeState(new EndState(engine));
            return true;
        }
        return false;
    }

    @Override
    public GameStates getCurrentState() {
        return null;
    }

    @Override
    public void changeState(GameState state) {
        engine.setState(state);
    }

    @Override
    public void initGame(int boardSize, int numOfPlayers, VictoryStrategyEnum strategyEnum) {
        throw new IllegalStateException("Cannot init game in between the game");
    }

    @Override
    public void undo() {
        Stack<int[]> moveStack = engine.getMovesStack();
        if(moveStack.isEmpty()) {
            throw new IllegalStateException("No moves to undo");
        } else {
            int moves[] = moveStack.pop();
            engine.getBoard().updateTable(moves[0],moves[1],'\0');
            engine.setMoveCount(engine.getMoveCount()-1);
        }
    }

    @Override
    public void endGame() {
        changeState(new InitGameState(engine));
    }
}
