package org.example.models.Pieces.Strategy;

import org.example.models.Board.Cell;

public class DiagonalMovement implements MovementStrategy{

    @Override
    public boolean canMove(Cell start, Cell end) {
        return start.getX() != end.getX() && start.getY() != end.getY();
    }
}
