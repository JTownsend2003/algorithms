package codeforall.io.fourinline;

import codeforall.io.fourinline.factory.GameFactory;
import codeforall.io.fourinline.gamelogic.GameEngine;
import codeforall.io.fourinline.gamelogic.GameType;

public class GameRunner {

    public static void main(String[] args) {

        GameEngine gameEngine =
                GameFactory.getGame(GameType.Graphics.SIMPLE_GFX, GameType.Playability.INTERACTIVE);

        gameEngine.start();

    }

}
