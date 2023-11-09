package codeforall.io.fourinline.graphics;

import codeforall.io.fourinline.Clock;
import codeforall.io.fourinline.graphics.cell.Piece;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private int playerNum;
    protected int col;
    protected int row;
    protected List<Piece> pieces;

    public Player(int playerNum) {
        this.playerNum = playerNum;
        this.col = 0;
        this.row = 0;
        pieces = new ArrayList<>();
    }

    public void moveLeft() {
        if (col == 0) {
            return;
        }
        col--;
    }

    public void moveRight() {
        if (col+1 == Grid.COLS) {
            return;
        }
        col++;
    }

    abstract public Piece putPiece();

    public List<Piece> getPieces() {
        return pieces;
    }

    public void chooseRandomPos() {
        int numOfMoves = (int) (Math.random() * 5) + 1 ;
        double directionProbability = Math.random();

        for (int i = 0; i < numOfMoves; i++) {
            Clock.tick();

            if (directionProbability > 0.50) {
                moveRight();
                continue;
            }
            moveLeft();
        }
    }

    @Override
    public String toString() {
        return "Player " + playerNum;
    }

    public abstract void win();
}
