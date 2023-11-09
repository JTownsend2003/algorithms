package codeforall.io.fourinline.graphics.cell;

import codeforall.io.fourinline.graphics.Grid;

public abstract class Piece {

    protected int col;
    protected int row;

    public Piece(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void drop() {
        if (row + 1 == Grid.ROWS) {
            return;
        }
        row++;
    }

    @Override
    public String toString() {
       return "col: " + col + " row: " + row;
    }
}
