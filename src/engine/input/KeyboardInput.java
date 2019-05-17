package engine.input;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class KeyboardInput implements EventHandler<KeyEvent> {

    private static ArrayList<KeyCode> keyPressed = new ArrayList<>();

    // Handles key released and key down
    @Override
    public void handle(KeyEvent event) {
        if (event.getEventType().equals(KeyEvent.KEY_PRESSED)) { // Key press event
            if (!keyPressed.contains(event.getCode())) keyPressed.add(event.getCode());
        } else if (event.getEventType().equals(KeyEvent.KEY_RELEASED)) { // Key release event
            keyPressed.remove(event.getCode());
        }
    }

    // Returns true if the key is pressed
    public static boolean isKeyDown(KeyCode code) {
        return keyPressed.contains(code);
    }

}
