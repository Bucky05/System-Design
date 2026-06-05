package org.example.models.Pieces.Strategy;

import org.example.models.Board.Cell;
import org.example.models.Board.ChessBoard;

public class VerticalMovementStrategy implements MovementStrategy{


    @Override
    public boolean canMove(Cell start, Cell end, ChessBoard board) {

        if(start.getY() != end.getY()) {
            return false;
        }

        int step = (end.getX() > start.getX() ? 1 : -1) ;

        int currentRow = start.getX() + step;

        while(currentRow != end.getX() && currentRow >= 0 && currentRow < 8) {
            if(board.getBoard().get(currentRow).get(start.getY() - 'a').hasPiece()) {
                return false;
            }
            currentRow += step;
         }

        return !end.hasPiece() || end.getPiece().get().getColor() != start.getPiece().get().getColor();
    }
}
