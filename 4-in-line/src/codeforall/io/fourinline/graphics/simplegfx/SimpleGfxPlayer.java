package codeforall.io.fourinline.graphics.simplegfx;

import codeforall.io.fourinline.graphics.Grid;
import codeforall.io.fourinline.graphics.Player;
import codeforall.io.fourinline.graphics.cell.Piece;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class SimpleGfxPlayer extends Player {

    private final static int PLAYER_SIZE = 30;
    private final static int PLAYER_PADDING = 10;
    private Rectangle player;
    private Color color;

    public SimpleGfxPlayer(Color color, int playerNum) {
        super(playerNum);
        this.color = color;

        int initialX = SimpleGfxGrid.PADDING + PLAYER_PADDING;
        int y = SimpleGfxGrid.PADDING_TOP - SimpleGfxGrid.CELLSIZE + PLAYER_PADDING;

        player = new Rectangle( initialX, y, PLAYER_SIZE, PLAYER_SIZE);
        player.setColor(color);
        player.fill();
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        int x = col * SimpleGfxGrid.CELLSIZE + SimpleGfxGrid.PADDING + PLAYER_PADDING;

        x = x - player.getX();

        player.translate(x, 0);

    }

    @Override
    public void moveRight() {
        super.moveRight();
        int x = SimpleGfxGrid.PADDING + col * SimpleGfxGrid.CELLSIZE + PLAYER_PADDING;

        x = x - player.getX();

        player.translate(x, 0);
    }

    @Override
    public void win() {
        Text text = new Text(SimpleGfxGrid.PADDING, SimpleGfxGrid.CELLSIZE, toString() + "wins!");
        text.draw();
    }

    @Override
    public Piece putPiece() {
        Piece piece = new SimpleGfxPiece(col, row, color);
        pieces.add(piece);

        return piece;
    }
}
