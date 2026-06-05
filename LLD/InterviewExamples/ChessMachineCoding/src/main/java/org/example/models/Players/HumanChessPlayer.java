package org.example.models.Players;

import org.example.models.Board.Cell;
import org.example.models.Board.ChessBoard;
import org.example.models.Pieces.ChessPiece;
import org.example.models.Pieces.Move;
import org.example.models.Pieces.PieceName;

import java.util.Map;
import java.util.Scanner;

public class HumanChessPlayer extends ChessPlayer {

    public HumanChessPlayer(String name, Map<PieceName, ChessPiece> pieces, ChessBoard board) {
        super(name, pieces, board);
    }

    @Override
    public Move makeMove() {

        this.getBoard().display();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the row and column of the piece you want to move: ");
        int row = sc.nextInt();
        int col = sc.nextInt();

        if(!this.getBoard().getBoard().get(row).get(col-'a').hasPiece()) {
            throw new RuntimeException("No piece found at this cell");
        }

        System.out.println("Enter the row and column of the destination");
        int destRow = sc.nextInt();
        int destCol = sc.nextInt();

        Cell start = this.getBoard().getBoard().get(row).get(col - 'a');
        Cell end = this.getBoard().getBoard().get(destRow).get(destCol-'a');

        ChessPiece piece = this.getBoard().getBoard().get(row).get(col-'a').getPiece().get();

        if(!piece.canMove(start,end,this.getBoard())) {
            throw new IllegalArgumentException("Invalid move");
        }

        return new Move(start, end );

    }
}
