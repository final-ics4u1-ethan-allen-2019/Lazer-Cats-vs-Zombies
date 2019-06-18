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

    public SpriteRenderer setOffset(Vector2 offset) {
        this.offset = offset.copy();
        return this;
    }

    public void hide() {
        visible = false;
    }

    public void show() {
        visible = true;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public void render() {
        if (visible) Draw.drawImage(image, parent.x+offset.x, parent.y+offset.y, width, height);
    }

}
