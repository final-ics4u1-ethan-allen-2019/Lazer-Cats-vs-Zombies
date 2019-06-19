package engine.input;

/*
    Project title: Lazer Cats vs Zombies
    -----------------------------------------------
    ClassName: MouseInput
    -----------------------------------------------
    What it does: Keeps track of mouse input
    -----------------------------------------------
    For: ICS4U1 - Holik
    -----------------------------------------------
    By: Ethan and Allen
    -----------------------------------------------
    Last Edited: June 18th 2019
 */


import engine.math.Vector2;
import engine.scenes.SceneManager;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseInput implements EventHandler<MouseEvent> {

    public static double x;
    public static double y;

    public static boolean isPressed;

    @Override
    public void handle(MouseEvent event) {
        x = event.getX();
        y = event.getY();

        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) isPressed = true;
        else if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) isPressed = false;
    }

    public static Vector2 getWorldLoc() {
        Vector2 vector2 = SceneManager.getCurrentGameScene().cameraPosition;
        return vector2.add(x, y);
    }
}
