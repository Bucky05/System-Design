package org.example.models.Pieces.Strategy;

import org.example.models.Board.Cell;
import org.example.models.Board.ChessBoard;

public class KnightMovementStrategy implements MovementStrategy{


    @Override
    public boolean canMove(Cell start, Cell end, ChessBoard board) {
        return false; // TODO
    }
}
