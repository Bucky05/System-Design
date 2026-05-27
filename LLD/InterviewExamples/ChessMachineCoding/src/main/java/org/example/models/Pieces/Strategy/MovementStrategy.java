package org.example.models.Pieces.Strategy;

import org.example.models.Board.Cell;

public interface MovementStrategy {

    boolean canMove(Cell start, Cell end);
}
