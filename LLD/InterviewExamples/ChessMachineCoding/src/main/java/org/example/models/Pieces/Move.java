package org.example.models.Pieces;

import org.example.models.Helpers.Pair;

public class Move {

    private Pair prevPosition;
    private Pair currPosition;

    public Move(Pair prev, Pair curr) {
        this.prevPosition = prev;
        this.currPosition = curr;
    }
}
