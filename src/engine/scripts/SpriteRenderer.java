package engine.scripts;

import engine.Draw;
import engine.math.Vector2;
import javafx.scene.image.Image;

public class SpriteRenderer extends Script {

    private Image image;

    private double width, height;

    private Vector2 offset = new Vector2();

    private boolean visible = true;

    /**
     * Makes a new SpriteRenderer.
     * @param image Image to draw.
     */
    public SpriteRenderer(Image image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    /**
     * Makes a new SpriteRenderer
     * @param image Image to draw.
     * @param width Overrided height to draw image.
     * @param height Overrided width to draw image.
     */
    public SpriteRenderer(Image image, double width, double height) {
        this.image = image;
        this.width = width;
        this.height = height;
    }

    /** Sets the image offset
     *
     * @param offset Vector2 offset
     * @return the spriterenderer
     */
    public SpriteRenderer setOffset(Vector2 offset) {
        this.offset = offset.copy();
        return this;
    }

    /** Stops rendering the image
     *
     */
    public void hide() {
        visible = false;
    }

    /** Starts rendering the image
     *
     */
    public void show() {
        visible = true;
    }

    /** Sets the current displayed image
     *
     * @param image the image you want to display
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /** Draws the image called by GameObject in game loop
     *
     */
    @Override
    public void render() {
        if (visible) Draw.drawImage(image, parent.x+offset.x, parent.y+offset.y, width, height);
    }

}
