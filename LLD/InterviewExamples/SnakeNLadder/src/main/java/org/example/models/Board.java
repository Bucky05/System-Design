package org.example.models;

import java.util.List;

public class Board {

    int rows;
    int cols;
    List<Cell> cells;
    public Board(int rows, int cols, List<Cell> cells) {
        this.rows = rows;
        this.cols = cols;
        this.cells = cells;
    }
}
