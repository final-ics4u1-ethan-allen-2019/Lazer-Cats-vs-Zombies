package engine.scripts;

import engine.Time;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Animator extends Script {

    private ArrayList<Image>[] images;

    private SpriteRenderer renderer;

    private double change;
    private double last;

    private int current;
    private int state;

    public boolean enabled = true;

    private boolean loop = true;

    public Animator(ArrayList<Image>[] images, double change, SpriteRenderer renderer) {
        this.images = images;

        this.change = change;

        this.renderer = renderer;
    }

    @Override
    public void update() {
        if (renderer != null && images != null && enabled) {
            last += Time.deltaTime;
            if (last >= change) {
                current++;
                if (current >= images[state].size()) {
                    current = images[state].size()-1;
                    if (!loop) enabled = false;
                    else current = 0;
                }
                renderer.setImage(images[state].get(current));
                last = 0;
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getCurrent() {
        return this.current;
    }

    public int getState() {
        return this.state;
    }

    public void setImages(ArrayList<Image>[] images) {
        this.images = images;
    }

    public ArrayList<Image>[] getImages() {
        return images;
    }
}
