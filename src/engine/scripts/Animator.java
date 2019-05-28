package engine.scripts;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import java.util.ArrayList;

public class Animator extends Script {

    private ArrayList<Image> images;

    private SpriteRenderer renderer;

    public Animator(ArrayList<Image> images) {
        this.images = images;
    }

    @Override
    public void load() {
        for (Script script : parent.getScripts()) {
            if (script instanceof SpriteRenderer) {
                renderer = (SpriteRenderer) script;
                break;
            }
        }
        WritableImage image = new WritableImage(images.get(0).getPixelReader(), 0, 0, 10, 10);
        Image i = image;
    }
}
