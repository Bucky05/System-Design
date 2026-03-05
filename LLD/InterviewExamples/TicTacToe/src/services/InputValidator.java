package services;

import models.Board;
import models.Player;

import java.util.List;

public class InputValidator {



    public boolean validateMove(Board board, int row, int col) {
        int size = board.getSize();
        if(row <= 0 || col <= 0 || row > size || col > size ) return false;
        return board.getTable()[row-1][col-1] == '\0';
    }

    public boolean validatePlayer(List<Player> playerList, int numberOfPlayers) {
        return playerList.size() != numberOfPlayers;
    }
    public boolean validateSymbol(List<Player> playerList, char symbol) {

        return playerList.stream().noneMatch(player -> player.getSymbol() == symbol);
    }

    public boolean validateSize(int size) {
        return size >= 3;
    }
}
