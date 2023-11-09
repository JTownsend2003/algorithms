package codeforall.io.fourinline.graphics;

import codeforall.io.fourinline.graphics.cell.Cell;

public abstract class Grid {

    public static final int COLS = 7;
    public static final int ROWS = 6;
    private Cell[][] cells;

    public Grid() {
        cells = createCells();
    }

    public boolean isFull() {

        for (Cell[] cellArr : cells) {
            for (Cell cell : cellArr) {

                if (!cell.hasPiece()) {
                    return false;
                }

            }
        }

        return true;

    }

    public Cell getCell(int col, int row) {
        return cells[col][row];
    }

    public Cell[][] getCells() {
        return cells;
    }

    private Cell[][] createCells() {

        Cell[][] cells = new Cell[COLS][ROWS];

        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {

                cells[i][j] = new Cell(i,j);

            }
        }

        return cells;
    }
}
