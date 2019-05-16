package engine.scripts;

import javafx.scene.image.Image;

public class SpriteRenderer extends Script {

    private Image image;

    public SpriteRenderer(Image image) {
        this.image = image;
    }

    @Override
    public void render() {
        System.out.println("Draw");
    }

}
