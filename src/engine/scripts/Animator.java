package engine.scripts;

import engine.Time;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import java.util.ArrayList;

public class Animator extends Script {

    private ArrayList<Image>[] images;

    private SpriteRenderer renderer;

    private double change;
    private double last;

    private int current;
    private int state;

    public Animator(ArrayList<Image>[] images, double change) {
        this.images = images;

        this.change = change;
    }

    @Override
    public void load() {
        for (Script script : parent.getScripts()) {
            if (script instanceof SpriteRenderer) {
                renderer = (SpriteRenderer) script;
                break;
            }
        }
    }

    @Override
    public void update() {
        if (renderer != null) {
            last += Time.deltaTime;
            if (last >= change) {
                current++;
                if (current >= images[state].size()) current = 0;
                renderer.setImage(images[state].get(current));
                last = 0;
            }
        }
    }

    public void setState(int state) {
        this.state = state;
    }
}
