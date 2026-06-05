package org.example.models.Pieces.Strategy;

import org.example.models.Board.Cell;
import org.example.models.Board.ChessBoard;

public class HorizontalMovementStrategy implements MovementStrategy{

    @Override
    public boolean canMove(Cell start, Cell end, ChessBoard board) {

        if(start.getX() != end.getX()) {
            return false;
        }

        int step = (end.getY() > start.getY() ? 1 : -1) ;

        int currentCol = start.getY() + step;

        while(currentCol != end.getY() && currentCol >= 0 && currentCol < 8) {
            if(board.getBoard().get(currentCol).get(start.getY() - 'a').hasPiece()) {
                return false;
            }
            currentCol += step;
        }

        return !end.hasPiece() || end.getPiece().get().getColor() != start.getPiece().get().getColor();
    }
}
