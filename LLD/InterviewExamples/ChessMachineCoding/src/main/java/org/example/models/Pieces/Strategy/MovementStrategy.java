package org.example.models.Pieces.Strategy;

import org.example.models.Board.Cell;
import org.example.models.Board.ChessBoard;

public interface MovementStrategy {

    boolean canMove(Cell start, Cell end, ChessBoard board);
}
