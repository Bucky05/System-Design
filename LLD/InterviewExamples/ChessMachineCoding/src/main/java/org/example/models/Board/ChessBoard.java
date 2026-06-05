package org.example.models.Board;

import org.example.models.Helpers.Pair;
import org.example.models.Pieces.ChessPiece;
import org.example.models.Pieces.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChessBoard implements Board{

    private static final int rc = 8;
    private static final int cc = 8;

    private final List<List<Cell>> board;


    public ChessBoard() {
        this.board = new ArrayList<>();
        for(int i = 0 ; i < rc ; i++) {
            List<Cell> row = new ArrayList<>();
            for(int j = 0 ; j < cc ; j++) {
                row.add(new Cell(i+1,(char)(j+'a')));
            }
            board.add(row);
        }
    }
    @Override
    public void display() {
        for(int r = 0 ; r < rc; r++) {
            for(int c = 0; c < cc ; c++) {
                if(board.get(r).get(c).hasPiece()) {
                    System.out.print(board.get(r).get(c).getPiece().get().getPieceSymbol()+" | ");
                } else {
                    System.out.print("___ | ");
                }

            }
            System.out.println("");
        }
    }

    @Override
    public void applyMove(Move move, Board boardObj) {
        int startRow = move.getSource().getX();
        int startCol = move.getSource().getY();

        int endRow = move.getDestination().getX();
        int endCol = move.getDestination().getY();

        ChessPiece piece = board.get(startRow).get(startCol-'a').getPiece().get();
        if(boardObj instanceof ChessBoard) {
            piece.makeMove(move.getSource(), move.getDestination(), (ChessBoard) boardObj);
        }

    }

    @Override
    public void setPiece(ChessPiece piece, int row, char col) {
        board.get(row).get(col - 'a').setPiece(piece);
    }

    public List<List<Cell>> getBoard() {
        return board;
    }
}
