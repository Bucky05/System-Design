package org.example.models;

public class SnakeOrLadder {

    Cell start;
    Cell end;
    boolean isSnake;

    public SnakeOrLadder(Cell start, Cell end, boolean isSnake) {
        this.start = start;
        this.end = end;
        this.isSnake = isSnake;
    }
}
