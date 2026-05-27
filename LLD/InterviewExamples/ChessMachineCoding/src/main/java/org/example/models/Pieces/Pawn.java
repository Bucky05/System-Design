package org.example.models.Pieces;

import org.example.exceptions.InvalidPieceMoveException;
import org.example.models.Board.Cell;
import org.example.models.Helpers.Color;
import org.example.models.Helpers.Direction;
import org.example.models.Pieces.Strategy.DiagonalMovement;
import org.example.models.Pieces.Strategy.PawnVerticalMovement;
import org.example.models.Pieces.Strategy.VerticalMovement;

import javax.naming.directory.DirContext;
import java.util.Arrays;

public class Pawn extends Piece implements ChessPiece {


    public Pawn(PieceName name, Color color) {

        super(name,color);
        this.movementStrategies = Arrays.asList(new PawnVerticalMovement(), new DiagonalMovement());
    }
    @Override
    public void makeMove(Cell startingCell, Cell endingCell) {

    }

    @Override
    public boolean canMove(Cell startingCell, Cell endingCell) {
        // 1. If first move then can move one step or two step
        // 2. If not first then can move one step
        // 3. if diagonally are opposite color then can move diagonally and kill piece
        // 4. IF diagonally same color then can't move
        // 5. If vertically any piece then pawn can't move
        // 6. IF black have to move in negative Y , if white then in positive Y


        Direction direction = getDirection(startingCell,endingCell);

        if(direction == Direction.NONE || isDirectionValidForPawn(direction)) {
            throw new InvalidPieceMoveException("Invalid move for pawn");
        }

        if(isMovingVertically(startingCell,endingCell) && !endingCell.hasPiece()) {
            if(startingCell.getVerticalDistance(endingCell) == 2 && isMovingForFirstTime() ) {
                //TODO : once have a board then also check if the path is clear
                return true;
            } else if(startingCell.getVerticalDistance(endingCell) == 1) {
                return true;
            } else {
                return false;
            }
        }


        if(isMovingDiagonally(startingCell,endingCell) && endingCell.hasPiece() && endingCell.getPiece().get().getColor() != getColor()) {
            if(getColor() == Color.WHITE) {
                return endingCell.getY() - endingCell.getY() == 1 && startingCell.getHorizontalDistance(endingCell) == 1;
            } else {
                return endingCell.getY() - endingCell.getY() == -1 && startingCell.getHorizontalDistance(endingCell) == 1;
            }
        }




        return false;
    }




    @Override
    public void listPossibleMoves() {

    }

    private boolean isDirectionValidForPawn(Direction direction) {
        if(this.getColor() == Color.BLACK) {
            return direction == Direction.DOWN || direction == Direction.LEFT_DOWN || direction == Direction.RIGHT_DOWN;
        } else {
            return direction == Direction.UP || direction == Direction.LEFT_UP || direction == Direction.RIGHT_UP;
        }
    }
}
