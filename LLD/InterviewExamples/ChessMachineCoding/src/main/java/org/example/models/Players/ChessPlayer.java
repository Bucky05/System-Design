package org.example.models.Players;

import org.example.models.Board.ChessBoard;
import org.example.models.Pieces.ChessPiece;
import org.example.models.Pieces.Move;
import org.example.models.Pieces.PieceName;

import java.util.Map;

public abstract class ChessPlayer extends Player{

    private final Map<PieceName, ChessPiece> pieces;
    private final ChessBoard board;

    public ChessPlayer(String name, Map<PieceName, ChessPiece> pieces, ChessBoard board) {
        super(name);
        this.pieces = pieces;
        this.board = board;
    }

    public Map<PieceName, ChessPiece> getPieces() {
        return pieces;
    }

    public ChessPiece getPiece(PieceName name) {

        if(pieces.containsKey(name) && pieces.get(name).isKilled() ) {
            pieces.remove(name); // this is lazy update
        }
        if(!pieces.containsKey(name)) {
            throw new IllegalArgumentException("Piece not found");
        }

        return pieces.get(name);
    }
    @Override
    public Move makeMove() {
        return null;
    }

    public ChessBoard getBoard() { return this.board; }
}
