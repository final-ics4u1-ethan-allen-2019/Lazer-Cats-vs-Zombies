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

/*
    Project title: Lazer Cats vs Zombies
    -----------------------------------------------
    ClassName: Draw
    -----------------------------------------------
    What it does: Holds methods for drawing on the canvas
    -----------------------------------------------
    For: ICS4U1 - Holik
    -----------------------------------------------
    By: Ethan and Allen
    -----------------------------------------------
    Last Edited: June 18th 2019
 */

/** Class contain all canvas draw functions
 * @see GraphicsContext
 */
public class Draw {

    private static GraphicsContext graphics;

    /** Gets graphics context
     *
     * @return graphics context
     */
    public static GraphicsContext getGraphicsContext() {
        return graphics;
    }

    static void init(GraphicsContext graphics) {
        Draw.graphics = graphics;
    }

    /** Sets font
     *
     * @param font desired font object
     */
    public static void setFont(Font font) {
        graphics.setFont(font);
    }

    /** Sets paint
     *
     * @param paint desired paint object
     */
    public static void setFill(Paint paint) {
        graphics.setFill(paint);
    }

    /** Draws ellipse
     *
     * @param x x pos
     * @param y y pos
     * @param width ellipse width
     * @param height ellipse height
     * @param ui if part of ui
     */
    public static void ellipse(double x, double y, double width, double height, boolean ui) {
        Vector2 camPos = SceneManager.getCurrentGameScene().cameraPosition;
        graphics.fillOval(x - (!ui ? camPos.x : 0), y - (!ui ? camPos.y : 0), width, height);
    }

    /** Draws ellipse with ui false
     *
     * @param x x pos
     * @param y y pos
     * @param width ellipse width
     * @param height ellipse height
     */
    public static void ellipse(double x, double y, double width, double height) {
        ellipse(x, y, width, height,false);
    }

    /** Draws rect
     *
     * @param x x pos
     * @param y y pos
     * @param width rect width
     * @param height rect height
     * @param ui if part of ui
     */
    public static void rect(double x, double y, double width, double height, boolean ui) {
        Vector2 camPos = SceneManager.getCurrentGameScene().cameraPosition;
        graphics.fillRect(x - (!ui ? camPos.x : 0), y - (!ui ? camPos.y : 0), width, height);
    }
    /** Draws rect
     *
     * @param x x pos
     * @param y y pos
     * @param width rect width
     * @param height rect height
     */
    public static void rect(double x, double y, double width, double height) {
        rect(x, y, width, height,false);
    }

    /** Draws image
     *
     * @param image desired image
     * @param x x pos
     * @param y y pos
     * @param width image width
     * @param height image height
     * @param ui if part of ui
     */
    public static void drawImage(Image image, double x, double y, double width, double height, boolean ui) {
        Vector2 camPos = SceneManager.getCurrentGameScene().cameraPosition;
        BlendMode m = graphics.getGlobalBlendMode();
        graphics.drawImage(image, x - (!ui ? camPos.x : 0), y - (!ui ? camPos.y : 0), width, height);
    }

    /** Draws image
     *
     * @param image desired image
     * @param x x pos
     * @param y y pos
     * @param width image width
     * @param height image height
     */
    public static void drawImage(Image image, double x, double y, double width, double height) {
        drawImage(image, x, y, width, height,false);
    }

    /** Draws image
     *
     * @param image desired image
     * @param x x pos
     * @param y y pos
     */
    public static void drawImage(Image image, double x, double y) {
        drawImage(image, x, y, image.getWidth(), image.getWidth(),false);
    }

    /** Draws text
     *
     * @param text desired text
     * @param x x pos
     * @param y y pos
     * @param ui if in ui
     */
    public static void drawText(String text, double x, double y, boolean ui) {
        Vector2 camPos = SceneManager.getCurrentGameScene().cameraPosition;
        graphics.fillText(text, x - (!ui ? camPos.x : 0), y - (!ui ? camPos.y : 0));
    }

    /** Draws text
     *
     * @param text desired text
     * @param x x pos
     * @param y y pos
     * @param fontSize desired font size
     * @param ui if in ui
     */
    public static void drawText(String text, double x, double y, int fontSize, boolean ui) {
        Vector2 camPos = SceneManager.getCurrentGameScene().cameraPosition;
        graphics.fillText(text, x - (!ui ? camPos.x : 0), y - (!ui ? camPos.y : 0), fontSize);
    }

    /** Draws text
     *
     * @param text desired text
     * @param x x pos
     * @param y y pos
     */
    public static void drawText(String text, double x, double y) {
        drawText(text, x, y,false);
    }

    /** Gets text size
     *
     * @param text desired string
     * @return text size
     */
    public static double textSize(String text) {
        Text text1 = new Text(text);
        text1.setFont(graphics.getFont());
        return text1.getBoundsInLocal().getWidth();
    }

    /** Clears screen
     *
     */
    public static void clear() {
        graphics.clearRect(0,0, Game.getWidth(), Game.getHeight());
    }

}
