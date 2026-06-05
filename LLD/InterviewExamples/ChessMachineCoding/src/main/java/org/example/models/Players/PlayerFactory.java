package org.example.models.Players;

import org.example.game.BoardFactory;
import org.example.models.Board.ChessBoard;
import org.example.models.Helpers.Color;
import org.example.models.Pieces.ChessPiece;
import org.example.models.Pieces.PieceName;

import java.util.Map;

public class PlayerFactory {

    public static ChessPlayer createPlayer(String name, Color color, ChessBoard board) {
        Map<PieceName, ChessPiece> pieces = (color == Color.WHITE) ? BoardFactory.prepareWhitePieces() : BoardFactory.prepareBlackPieces();
        return new HumanChessPlayer(name,pieces,board);
    }
}
