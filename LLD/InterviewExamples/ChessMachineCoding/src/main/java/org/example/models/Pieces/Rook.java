package org.example.models.Pieces;

import org.example.exceptions.InvalidPieceMoveException;
import org.example.models.Board.Cell;
import org.example.models.Board.ChessBoard;
import org.example.models.Helpers.Color;
import org.example.models.Pieces.Strategy.HorizontalMovementStrategy;
import org.example.models.Pieces.Strategy.VerticalMovementStrategy;

import java.util.Arrays;

public class Rook extends Piece implements ChessPiece {

    public Rook(PieceName name, Color color, String symbol) {

        super(name, color, symbol);
        this.movementStrategies = Arrays.asList(new VerticalMovementStrategy(), new HorizontalMovementStrategy());
    }



    @Override
    public boolean canMove(Cell startingCell, Cell endingCell, ChessBoard board) {


        if (super.canMove(startingCell, endingCell, board)) {
            return true;
        }

        throw new InvalidPieceMoveException("Invalid move for Rook");
    }


    @Override
    public void listPossibleMoves() {

    }
}