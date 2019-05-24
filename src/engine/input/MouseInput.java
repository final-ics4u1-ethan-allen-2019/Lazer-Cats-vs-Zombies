package engine.input;

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
}
