package models;

import java.util.Arrays;

public class Board {

    private int size;
    private char table[][];

    public Board(int size) {
        this.size = size;
        table = new char[size][size];
    }

    public int getSize() {
        return this.size;
    }
    public char[][] getTable() {
        char[][] copy = new char[size][size];

        for(int i = 0 ; i < size ; i++) {
            copy[i] = table[i].clone();
        }

        return copy;
    }

    public void printTable() {
        for(int i = 0 ; i < size ; i++) {
            for(int j = 0 ; j < size ; j++) {
                System.out.print(table[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public void updateTable(int row, int col, char symbol) {
        table[row][col] = symbol;
    }

}
