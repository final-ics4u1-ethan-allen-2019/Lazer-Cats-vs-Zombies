package engine;

import javafx.scene.canvas.GraphicsContext;

public class Draw {

    private static GraphicsContext graphics;

    public static GraphicsContext getGraphicsContext() {
        return graphics;
    }

    static void init(GraphicsContext graphics) {
        Draw.graphics = graphics;
    }

    // Drawing methods

    public static void ellipse() {

    }

}
