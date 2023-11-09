package codeforall.io.fourinline.graphics.cell;

public class Cell {

    private int col;
    private int row;
    private Piece piece;

    public Cell(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void setPiece(Piece piece)  {
        this.piece = piece;
    }

    public boolean hasPiece() {
        return !(piece == null);
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
