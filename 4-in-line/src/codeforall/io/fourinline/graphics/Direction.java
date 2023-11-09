package codeforall.io.fourinline.graphics;

public enum Direction {
    HORIZONTAL(1,0),
    VERTICAL(0,1),
    DIAGONAL_1(1,1),
    DIAGONAL_2(1,-1);

    private int colChange;
    private int rowChange;

    Direction(int colChange, int rowChange) {
        this.colChange = colChange;
        this.rowChange = rowChange;
    }

    public int getColChange() {
        return colChange;
    }

    public int getRowChange() {
        return rowChange;
    }
}
