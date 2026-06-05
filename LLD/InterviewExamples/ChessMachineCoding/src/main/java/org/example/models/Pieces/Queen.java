package org.example.models.Pieces;

import org.example.exceptions.InvalidPieceMoveException;
import org.example.models.Board.Cell;
import org.example.models.Board.ChessBoard;
import org.example.models.Helpers.Color;
import org.example.models.Pieces.Strategy.DiagonalMovementStrategy;
import org.example.models.Pieces.Strategy.HorizontalMovementStrategy;
import org.example.models.Pieces.Strategy.VerticalMovementStrategy;

import java.util.Arrays;

public class Queen extends Piece implements ChessPiece{

    public Queen(PieceName name, Color color, String symbol) {

        super(name, color, symbol);
        this.movementStrategies = Arrays.asList(new DiagonalMovementStrategy(), new HorizontalMovementStrategy(), new VerticalMovementStrategy());
    }


    @Override
    public boolean canMove(Cell startingCell, Cell endingCell, ChessBoard board) {


        if (super.canMove(startingCell, endingCell, board)) {
            return true;
        }

        throw new InvalidPieceMoveException("Invalid move for Bishop");
    }


    @Override
    public void listPossibleMoves() {

    }
}
