package org.example.game;

import org.example.models.Board.ChessBoard;
import org.example.models.Helpers.Color;
import org.example.models.Pieces.ChessPiece;
import org.example.models.Pieces.Pawn;
import org.example.models.Pieces.PieceName;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardFactory {

    public static Map<PieceName, ChessPiece> whitePieces;
    public static Map<PieceName, ChessPiece> blackPieces;

    public static Map<PieceName, ChessPiece> prepareWhitePieces() {
        whitePieces = getPieces(Color.WHITE);
        return whitePieces;
    }
    public static Map<PieceName, ChessPiece> prepareBlackPieces() {
        blackPieces = getPieces(Color.BLACK);
        return blackPieces;
    }
    public static void prepareBoardByPlacingPieces(ChessBoard board) {

        if(whitePieces == null || blackPieces == null) {
            throw new IllegalStateException("Pieces not initialized");
        }

        placePawns(board, whitePieces, Color.WHITE);
        placePawns(board,blackPieces, Color.BLACK);

        placeBishops(board, whitePieces, Color.WHITE);
        placeBishops(board, blackPieces, Color.BLACK);

        placeKnights(board, whitePieces, Color.WHITE);
        placeKnights(board,blackPieces, Color.BLACK);

        placeRooks(board,whitePieces,Color.WHITE);
        placeRooks(board,blackPieces,Color.BLACK);

        placeKing(board,whitePieces,Color.WHITE);
        placeKing(board,blackPieces,Color.BLACK);

        placeQueen(board,whitePieces,Color.WHITE);
        placeQueen(board,blackPieces,Color.BLACK);


    }

    private static void placeRooks(ChessBoard board, Map<PieceName, ChessPiece> colorPieces, Color color) {
        int row = (color == Color.WHITE) ? 0 : 7;
        board.setPiece(colorPieces.get(PieceName.ROOK1), row, 'a');
        board.setPiece(colorPieces.get(PieceName.ROOK2), row, 'h');

    }

    private static void placeBishops(ChessBoard board, Map<PieceName, ChessPiece> colorPieces, Color color) {
        int row = (color == Color.WHITE) ? 0 : 7;
        board.setPiece(colorPieces.get(PieceName.BISHOP1), row, 'c');
        board.setPiece(colorPieces.get(PieceName.BISHOP2), row, 'f');

    }

    private static void placeKnights(ChessBoard board, Map<PieceName, ChessPiece> colorPieces, Color color) {
        int row = (color == Color.WHITE) ? 0 : 7;
        board.setPiece(colorPieces.get(PieceName.KNIGHT1), row, 'b');
        board.setPiece(colorPieces.get(PieceName.KNIGHT2), row, 'g');

    }

    private static void placeKing(ChessBoard board, Map<PieceName, ChessPiece> colorPieces, Color color) {
        int row = (color == Color.WHITE) ? 0 : 7;
        board.setPiece(colorPieces.get(PieceName.KING), row, 'd');

    }
    private static void placeQueen(ChessBoard board, Map<PieceName, ChessPiece> colorPieces, Color color) {
        int row = (color == Color.WHITE) ? 0 : 7;
        board.setPiece(colorPieces.get(PieceName.QUEEN), row, 'e');

    }

    private static void placePawns(ChessBoard board, Map<PieceName,ChessPiece> colorPieces, Color color) {

        int row = (color == Color.WHITE) ? 1 : 6;

        List<PieceName> pawns  = Arrays.asList(PieceName.PAWN1, PieceName.PAWN2, PieceName.PAWN3, PieceName.PAWN4, PieceName.PAWN5, PieceName.PAWN6, PieceName.PAWN7, PieceName.PAWN8, PieceName.PAWN1);

        for(int col = 0; col < 8; col++) {
            board.setPiece(colorPieces.get(pawns.get(col)), row, (char)('a'+col));
        }
    }
    public static Map<PieceName, ChessPiece> getPieces(Color color) {
        Map<PieceName, ChessPiece> pieces = new HashMap<>();

        pieces.put(PieceName.PAWN1,new Pawn(PieceName.PAWN1, color, color.toString().substring(0,1)+"P1"));
        pieces.put(PieceName.PAWN2, new Pawn(PieceName.PAWN2, color, color.toString().substring(0,1)+"P2"));
        pieces.put(PieceName.PAWN3,new Pawn(PieceName.PAWN3, color, color.toString().substring(0,1)+"P3"));
        pieces.put(PieceName.PAWN4,new Pawn(PieceName.PAWN4, color, color.toString().substring(0,1)+"P4"));
        pieces.put(PieceName.PAWN5,new Pawn(PieceName.PAWN5, color, color.toString().substring(0,1)+"P5"));
        pieces.put(PieceName.PAWN6,new Pawn(PieceName.PAWN6, color, color.toString().substring(0,1)+"P6"));
        pieces.put(PieceName.PAWN7,new Pawn(PieceName.PAWN7, color, color.toString().substring(0,1)+"P7"));
        pieces.put(PieceName.PAWN8,new Pawn(PieceName.PAWN8, color, color.toString().substring(0,1)+"P8"));
        pieces.put(PieceName.ROOK1,new Pawn(PieceName.ROOK1, color, color.toString().substring(0,1)+"R1"));
        pieces.put(PieceName.ROOK2,new Pawn(PieceName.ROOK2, color, color.toString().substring(0,1)+"R2"));
        pieces.put(PieceName.KNIGHT1,new Pawn(PieceName.KNIGHT1, color, color.toString().substring(0,1)+"K1"));
        pieces.put(PieceName.KNIGHT2,new Pawn(PieceName.KNIGHT2, color, color.toString().substring(0,1)+"K2"));
        pieces.put(PieceName.BISHOP1,new Pawn(PieceName.BISHOP1, color, color.toString().substring(0,1)+"B1"));
        pieces.put(PieceName.BISHOP2,new Pawn(PieceName.BISHOP2, color, color.toString().substring(0,1)+"B2"));
        pieces.put(PieceName.KING,new Pawn(PieceName.KING, color, color.toString().substring(0,1)+"KG"));
        pieces.put(PieceName.QUEEN,new Pawn(PieceName.QUEEN, color, color.toString().substring(0,1)+"QN"));

        return pieces;
    }
}
