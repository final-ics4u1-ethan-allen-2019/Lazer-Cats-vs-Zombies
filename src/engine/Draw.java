package engine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class Draw {

    private static GraphicsContext graphics;

    public static GraphicsContext getGraphicsContext() {
        return graphics;
    }

    static void init(GraphicsContext graphics) {
        Draw.graphics = graphics;
    }

    // Drawing methods

    public static void setFont(Font font) {
        graphics.setFont(font);
    }

    public static void setFill(Paint paint) {
        graphics.setFill(paint);
    }

    public static void ellipse(double x, double y, double width, double height) {
        graphics.fillOval(x, y, width, height);
    }

    public static void rect(double x, double y, double width, double height) {
        graphics.fillRect(x, y, width, height);
    }

    public static void drawImage(Image image, double x, double y, double width, double height) {
        graphics.drawImage(image, x, y, width, height);
    }

    public static void drawImage(Image image, double x, double y) {
        graphics.drawImage(image, x, y, image.getWidth(), image.getWidth());
    }

    public static void drawText(String text, double x, double y) {
        graphics.fillText(text, x, y);
    }

    public static void clear() {
        graphics.clearRect(0,0, Game.getWidth(), Game.getHeight());
    }

}
