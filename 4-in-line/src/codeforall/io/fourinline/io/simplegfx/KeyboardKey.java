package codeforall.io.fourinline.io.simplegfx;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public enum KeyboardKey {

    MOVE_LEFT(KeyboardEventType.KEY_PRESSED, KeyboardEvent.KEY_LEFT),
    MOVE_RIGHT(KeyboardEventType.KEY_PRESSED, KeyboardEvent.KEY_RIGHT),
    PUT_PIECE(KeyboardEventType.KEY_PRESSED, KeyboardEvent.KEY_SPACE);

    private KeyboardEvent event;

    KeyboardKey(KeyboardEventType eventType, int key) {
       event = new KeyboardEvent();
       event.setKeyboardEventType(eventType);
       event.setKey(key);
    }

    public KeyboardEvent getEvent() {
        return event;
    }
}
