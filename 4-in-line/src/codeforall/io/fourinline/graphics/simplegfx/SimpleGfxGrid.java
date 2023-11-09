package codeforall.io.fourinline.graphics.simplegfx;

import codeforall.io.fourinline.graphics.Grid;
import codeforall.io.fourinline.graphics.cell.Cell;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid extends Grid {

    private Rectangle[][] rectangles;
    public final static int CELLSIZE = 50;
    public final static int PADDING = 10;
    public final static int PADDING_TOP = 100;

    public SimpleGfxGrid() {
        super();
        rectangles = createRectangles();
    }

    private Rectangle[][] createRectangles() {

        Rectangle[][] rectangles = new Rectangle[Grid.COLS][Grid.ROWS];

        for (Cell[] cells : getCells()) {
            for (Cell cell : cells) {

                int col = cell.getCol();
                int row = cell.getRow();

                int x = col * CELLSIZE + PADDING;
                int y = row * CELLSIZE + PADDING_TOP;

                Rectangle rectangle = new Rectangle(x,y,CELLSIZE,CELLSIZE);
                rectangles[cell.getCol()][cell.getRow()] = rectangle;
                rectangle.draw();

            }
        }

        return rectangles;
    }


}
