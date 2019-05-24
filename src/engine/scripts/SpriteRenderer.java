package engine.scripts;

import engine.Draw;
import javafx.scene.image.Image;

public class SpriteRenderer extends Script {

    private Image image;

    private double width, height;

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

    @Override
    public void render() {
        Draw.drawImage(image, parent.x, parent.y, width, height);
    }

}
