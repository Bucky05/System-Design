package org.example.models.Pieces;

import org.example.models.Board.Cell;
import org.example.models.Board.ChessBoard;
import org.example.models.Helpers.Color;

public interface ChessPiece {

    void makeMove(Cell startingCell, Cell endingCell, ChessBoard board);


    void setKilled(boolean killed);
    boolean isKilled();

    void listPossibleMoves();

    boolean canMove(Cell starting, Cell ending, ChessBoard board);

    boolean isMovingForFirstTime();

    Color getColor();

    String getPieceSymbol();
}
