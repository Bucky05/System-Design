package org.example.models.Pieces.Strategy;

import org.example.models.Board.Cell;
import org.example.models.Board.ChessBoard;

public class DiagonalMovementStrategy implements MovementStrategy{

    @Override
    public boolean canMove(Cell start, Cell end, ChessBoard board) {
        return start.getX() != end.getX() && start.getY() != end.getY();
    }
}
