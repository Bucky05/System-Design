package org.example.game;

import org.example.models.Board.Board;
import org.example.models.Board.ChessBoard;
import org.example.models.Pieces.ChessPiece;
import org.example.models.Pieces.PieceName;
import org.example.models.Players.ChessPlayer;
import org.example.models.Players.Player;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ChessGame extends BoardGame{

    private final ChessPlayer p1;
    private final ChessPlayer p2;
    public ChessGame(ChessBoard board, ChessPlayer p1, ChessPlayer p2) {
        super(board,new ArrayDeque<>(Arrays.asList(p1,p2)));
        this.p1 = p1;
        this.p2 = p2;

        BoardFactory.prepareBoardByPlacingPieces(board);
    }

    @Override
    protected boolean isGameOver() {
        boolean isWhiteKingDead = p1.getPiece(PieceName.KING).isKilled();
        boolean isBlackKingDead = p2.getPiece(PieceName.KING).isKilled();

        return isWhiteKingDead || isBlackKingDead;
    }

    private void initBoard() {

    }


    @Override
    public void showBoard() {
        this.board.display();
    }
}
