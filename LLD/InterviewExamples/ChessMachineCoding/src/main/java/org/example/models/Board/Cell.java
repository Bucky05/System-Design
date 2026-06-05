package org.example.models.Board;

import org.example.models.Helpers.Pair;
import org.example.models.Pieces.ChessPiece;

import javax.swing.text.html.Option;
import java.util.Optional;

// a cell may or may not have a chess piece
public class Cell {

    private Optional<ChessPiece> piece;
    private final Pair position;

    public Cell(int x, char y) {
        this.position = new Pair(x,y);
        this.piece = Optional.empty();
    }

    public Optional<ChessPiece> getPiece() {
        return piece;
    }

    public void setPiece(ChessPiece piece) {
        this.piece = Optional.of(piece);
    }

    public boolean hasPiece() {
        return piece.isPresent();
    }
    public void removePiece() {
        this.piece = Optional.empty();
    }

    public Pair getPosition() {
        return position;
    }

    public int getX() {
        return position.getX();
    }

    public char getY() {
        return position.getY();
    }

    public int getVerticalDistance(Cell cell) {
        return Math.abs(cell.getY() - position.getY());
    }

    public int getHorizontalDistance(Cell cell) {
        return Math.abs(cell.getX() - position.getX());
    }


}
