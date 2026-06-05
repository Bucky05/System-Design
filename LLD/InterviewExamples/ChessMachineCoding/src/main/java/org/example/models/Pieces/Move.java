package org.example.models.Pieces;

import org.example.models.Board.Cell;

public class Move {

    private Cell prevPosition;
    private Cell currPosition;

    public Move(Cell prev, Cell curr) {
        this.prevPosition = prev;
        this.currPosition = curr;
    }

    public Cell getSource() {
        return prevPosition;
    }

    public Cell getDestination() {
        return currPosition;
    }
}
