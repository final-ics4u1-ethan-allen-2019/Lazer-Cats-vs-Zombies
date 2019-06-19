package engine.input;

/*
    Project title: Lazer Cats vs Zombies
    -----------------------------------------------
    ClassName: KeyBoardInput
    -----------------------------------------------
    What it does: Keeps track of keyboard input
    -----------------------------------------------
    For: ICS4U1 - Holik
    -----------------------------------------------
    By: Ethan and Allen
    -----------------------------------------------
    Last Edited: June 18th 2019
 */

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

/** Keyboard Input
 *
 */
public class KeyboardInput implements EventHandler<KeyEvent> {

    private static ArrayList<KeyCode> keyPressed = new ArrayList<>();

    /** Handles key events from JavaFX
     *
     * @param event The event params given by JavaFX
     * @see KeyEvent
     */
    @Override
    public void handle(KeyEvent event) {
        if (event.getEventType().equals(KeyEvent.KEY_PRESSED)) { // Key press event
            if (!keyPressed.contains(event.getCode())) keyPressed.add(event.getCode());
        } else if (event.getEventType().equals(KeyEvent.KEY_RELEASED)) { // Key release event
            keyPressed.remove(event.getCode());
        }
    }

    // Returns true if the key is pressed

    /** Checks if the Key is down
     *
     * @param code Code to check if it is down
     * @return if Key is down
     * @see KeyCode
     */
    public static boolean isKeyDown(KeyCode code) {
        return keyPressed.contains(code);
    }

}
