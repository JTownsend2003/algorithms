package codeforall.io.fourinline.io.simplegfx;

import codeforall.io.fourinline.gamelogic.GameEngine;
import codeforall.io.fourinline.graphics.Player;
import codeforall.io.fourinline.io.IoHandler;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class SimpleGfxIoHandler implements IoHandler, KeyboardHandler {

    private GameEngine gameEngine;

    @Override
    public void init() {
        Keyboard keyboard = new Keyboard(this);

        for (KeyboardKey key : KeyboardKey.values()) {
            keyboard.addEventListener(key.getEvent());
        }
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                gameEngine.getCurrentPlayer().moveLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                gameEngine.getCurrentPlayer().moveRight();
                break;
            case KeyboardEvent.KEY_SPACE:
                gameEngine.putPiece(gameEngine.getCurrentPlayer().putPiece());
                gameEngine.setNextPlayer();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }
}
