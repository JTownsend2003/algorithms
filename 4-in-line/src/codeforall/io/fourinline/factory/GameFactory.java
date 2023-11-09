package codeforall.io.fourinline.factory;

import codeforall.io.fourinline.gamelogic.GameEngine;
import codeforall.io.fourinline.gamelogic.GameType;
import codeforall.io.fourinline.graphics.Grid;
import codeforall.io.fourinline.graphics.Player;
import codeforall.io.fourinline.graphics.simplegfx.SimpleGfxPlayer;
import codeforall.io.fourinline.graphics.textbased.TextBasedPlayer;
import codeforall.io.fourinline.io.IoHandler;
import codeforall.io.fourinline.graphics.textbased.TextBasedGrid;
import codeforall.io.fourinline.graphics.simplegfx.SimpleGfxGrid;
import codeforall.io.fourinline.io.simplegfx.SimpleGfxIoHandler;
import codeforall.io.fourinline.io.textbased.TextBasedIoHandler;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class GameFactory {

    public static GameEngine getGame(GameType.Graphics graphics, GameType.Playability playability) {

        Grid grid;
        IoHandler ioHandler;
        Player player1;
        Player player2;

        switch (graphics) {
            case SIMPLE_GFX:
                grid = new SimpleGfxGrid();
                ioHandler = new SimpleGfxIoHandler();
                player1 = new SimpleGfxPlayer(Color.YELLOW, 1);
                player2 = new SimpleGfxPlayer(Color.RED, 2);
                break;
            case TEXT_BASED:
                grid = new TextBasedGrid();
                ioHandler = new TextBasedIoHandler();
                player1 = new TextBasedPlayer(1);
                player2 = new TextBasedPlayer(2);
                break;
            default:
                grid = new SimpleGfxGrid();
                ioHandler = new SimpleGfxIoHandler();
                player1 = new SimpleGfxPlayer(Color.YELLOW, 1);
                player2 = new SimpleGfxPlayer(Color.RED, 2);
                break;
        }

        return playability == GameType.Playability.NON_INTERACTIVE ?
                new GameEngine(grid, player1, player2) : new GameEngine(grid, ioHandler, player1, player2);

    }

}
