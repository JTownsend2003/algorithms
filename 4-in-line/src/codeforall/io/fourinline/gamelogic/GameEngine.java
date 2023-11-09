package codeforall.io.fourinline.gamelogic;

import codeforall.io.fourinline.Clock;
import codeforall.io.fourinline.graphics.Grid;
import codeforall.io.fourinline.graphics.Player;
import codeforall.io.fourinline.graphics.cell.Cell;
import codeforall.io.fourinline.graphics.cell.Piece;
import codeforall.io.fourinline.io.IoHandler;

public class GameEngine {

    private Grid grid;
    private IoHandler ioHandler;
    private Player player1;
    private Player player2;
    private Player currentPlayer;


    public GameEngine(Grid grid, Player player1, Player player2) {
        this.grid = grid;
        this.ioHandler = null;
        this.player1 = player1;
        this.player2 = player2;
    }

    public GameEngine(Grid grid, IoHandler ioHandler, Player player1, Player player2) {
        this.grid = grid;
        this.ioHandler = ioHandler;
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        ioHandler.setGameEngine(this);
        ioHandler.init();
    }

    public void start() {

        while (!endGame()) {

            Clock.tick();

            if (ioHandler == null) {
                play();
                continue;
            }

        }

        Player winner = fourInLine();
        winner.win();

        Clock.slowdown();
        Clock.tick();

        System.exit(0);
    }

    public void play() {

        player1.chooseRandomPos();
        putPiece(player1.putPiece());
        player2.chooseRandomPos();
        putPiece(player2.putPiece());

    }

    public void putPiece(Piece piece) {

        Cell cell;
        Cell previous = grid.getCell(piece.getCol(), piece.getRow());

        synchronized (GameRuler.class) {
            while (!(cell = grid.getCell(piece.getCol(), piece.getRow())).hasPiece() && piece.getRow() + 1 < Grid.ROWS) {

                piece.drop();
                previous = cell;
                Clock.tick();
            }
        }

        if (previous.hasPiece()) {
            return;
        }
        previous.setPiece(piece);

    }

    private boolean endGame() {

        Player winner = fourInLine();

        if (grid.isFull()) {
            return true;
        } else {
            return winner != null;
        }

    }

    private Player fourInLine() {

        if (GameRuler.hasFourInLine(player1)) {
            return player1;
        }

        return GameRuler.hasFourInLine(player2) ? player2 : null;

    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setNextPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }
}
