package codeforall.io.fourinline.gamelogic;

import codeforall.io.fourinline.graphics.Direction;
import codeforall.io.fourinline.graphics.Player;
import codeforall.io.fourinline.graphics.cell.Piece;

import java.util.List;

public class GameRuler {

    public static boolean hasFourInLine(Player player) {
        synchronized (GameRuler.class) {
            for (Piece piece : player.getPieces()) {

                for (Direction direction : Direction.values()) {
                    if (hasConsecutivePieces(piece, direction, player.getPieces())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean hasConsecutivePieces(Piece piece, Direction direction, List<Piece> pieces) {

        int col = piece.getCol();
        int row = piece.getRow();

        for (int i = 0; i < 3; i++) {
            col += direction.getColChange();
            row += direction.getRowChange();

            if (findPiece(col, row, pieces) == null) {
                return false;
            }

        }

        return true;

    }

    private static Piece findPiece(int col, int row, List<Piece> pieces) {

        for (Piece piece : pieces) {
            if (piece.getCol() == col && piece.getRow() == row) {
                return piece;
            }
        }

        return null;
    }

}
