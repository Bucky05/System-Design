package org.example.models.Pieces.Strategy;

import org.example.models.Board.Cell;
import org.example.models.Board.ChessBoard;
import org.example.models.Helpers.Color;

public class PawnDiagonalMovementStrategy implements MovementStrategy{

    @Override
    public boolean canMove(Cell start, Cell end, ChessBoard board) {
        Color color = start.getPiece().get().getColor();
        if(!end.hasPiece() || end.getPiece().get().getColor() == color) {
            return false;
        }

        if(color == Color.WHITE) {
            return end.getY() - end.getY() == 1 && start.getHorizontalDistance(end) == 1;
        } else {
            return end.getY() - end.getY() == -1 && start.getHorizontalDistance(end) == 1;
        }
    }
}
