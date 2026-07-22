package org.example.models;

public class Cell {

    int row;
    int col;
    int cellNo;
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        cellNo = (row+1)*(col+1);
    }
}
