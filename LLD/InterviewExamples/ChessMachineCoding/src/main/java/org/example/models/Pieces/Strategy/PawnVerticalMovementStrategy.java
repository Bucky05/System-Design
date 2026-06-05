package org.example.models.Pieces.Strategy;

import org.example.models.Board.Cell;
import org.example.models.Board.ChessBoard;
import org.example.models.Helpers.Color;
import org.example.models.Pieces.Pawn;

public class PawnVerticalMovementStrategy implements MovementStrategy{

    private final Pawn pawn;

    public PawnVerticalMovementStrategy(Pawn pawn) {
        this.pawn = pawn;
    }
    @Override
    public boolean canMove(Cell start, Cell end, ChessBoard board) {

        if(start.getY() != end.getY()) {
            return false;
        }

        int step = (this.pawn.getColor().equals(Color.WHITE)) ? 1 : -1;

        int displacement = end.getX() - start.getX();

        if(this.pawn.isMovingForFirstTime() && displacement == 2*step) {
            return !end.hasPiece() && !board.getBoard().get(start.getX() + step).get(start.getY()).hasPiece();
        }
        return Math.abs(displacement) == 1 && !end.hasPiece();


    }
}
