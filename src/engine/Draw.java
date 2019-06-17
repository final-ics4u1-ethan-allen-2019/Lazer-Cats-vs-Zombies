package engine;

import engine.math.Vector2;
import engine.scenes.GameScene;
import engine.scenes.SceneManager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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

    public static void ellipse(double x, double y, double width, double height, boolean ui) {
        Vector2 camPos = SceneManager.getCurrentGameScene().cameraPosition;
        graphics.fillOval(x - (!ui ? camPos.x : 0), y - (!ui ? camPos.y : 0), width, height);
    }

    public static void ellipse(double x, double y, double width, double height) {
        ellipse(x, y, width, height,false);
    }

    public static void rect(double x, double y, double width, double height, boolean ui) {
        Vector2 camPos = SceneManager.getCurrentGameScene().cameraPosition;
        graphics.fillRect(x - (!ui ? camPos.x : 0), y - (!ui ? camPos.y : 0), width, height);
    }

    public static void rect(double x, double y, double width, double height) {
        rect(x, y, width, height,false);
    }

    public static void drawImage(Image image, double x, double y, double width, double height, boolean ui) {
        Vector2 camPos = SceneManager.getCurrentGameScene().cameraPosition;
        BlendMode m = graphics.getGlobalBlendMode();
        graphics.drawImage(image, x - (!ui ? camPos.x : 0), y - (!ui ? camPos.y : 0), width, height);
    }

    public static void drawImage(Image image, double x, double y, double width, double height) {
        drawImage(image, x, y, width, height,false);
    }

    public static void drawImage(Image image, double x, double y) {
        drawImage(image, x, y, image.getWidth(), image.getWidth(),false);
    }

    public static void drawText(String text, double x, double y, boolean ui) {
        Vector2 camPos = SceneManager.getCurrentGameScene().cameraPosition;
        graphics.fillText(text, x - (!ui ? camPos.x : 0), y - (!ui ? camPos.y : 0));
    }

    public static void drawText(String text, double x, double y, int fontSize, boolean ui) {
        Vector2 camPos = SceneManager.getCurrentGameScene().cameraPosition;
        graphics.fillText(text, x - (!ui ? camPos.x : 0), y - (!ui ? camPos.y : 0), fontSize);
    }

    public static void drawText(String text, double x, double y) {
        drawText(text, x, y,false);
    }


    public static double textSize(String text) {
        Text text1 = new Text(text);
        text1.setFont(graphics.getFont());
        return text1.getBoundsInLocal().getWidth();
    }

    public static void clear() {
        graphics.clearRect(0,0, Game.getWidth(), Game.getHeight());
    }

}
