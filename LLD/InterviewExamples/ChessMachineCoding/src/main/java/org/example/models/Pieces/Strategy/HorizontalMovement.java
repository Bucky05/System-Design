package org.example.models.Pieces.Strategy;

import org.example.models.Board.Cell;

public class HorizontalMovement implements MovementStrategy{

    @Override
    public boolean canMove(Cell start, Cell end) {
        return start.getY() == end.getY();
    }
}
