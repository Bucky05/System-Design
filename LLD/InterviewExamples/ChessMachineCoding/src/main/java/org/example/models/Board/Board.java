package org.example.models.Board;

import org.example.models.Pieces.ChessPiece;
import org.example.models.Pieces.Move;

public interface Board {

    void display();

    void applyMove(Move mov, Board board);

    void setPiece(ChessPiece piece, int row, char y);
}
