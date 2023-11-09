package codeforall.io.fourinline.graphics.simplegfx;

import codeforall.io.fourinline.graphics.cell.Piece;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxPiece extends Piece {

    private final static int PIECE_SIZE = 25;
    private final static int PIECE_PADDING = PIECE_SIZE / 2;
    private Rectangle piece;
    private int x;
    private int y;


    public SimpleGfxPiece(int col, int row, Color color) {
        super(col, row);
        x = col * SimpleGfxGrid.CELLSIZE + SimpleGfxGrid.PADDING + PIECE_PADDING;
        y = row * SimpleGfxGrid.CELLSIZE + SimpleGfxGrid.PADDING_TOP + PIECE_PADDING;

        piece = new Rectangle(x, y, PIECE_SIZE, PIECE_SIZE);
        piece.setColor(color);
        piece.fill();
    }

    @Override
    public void drop() {
        super.drop();
        int y = row * SimpleGfxGrid.CELLSIZE + SimpleGfxGrid.PADDING_TOP + PIECE_PADDING;

        y = y - piece.getY();

        piece.translate(0, y);
    }
}
