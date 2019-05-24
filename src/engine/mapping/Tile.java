package engine.mapping;

import engine.Rect;
import javafx.scene.image.Image;

public class Tile {
    //WIP
    private Image img;
    private Rect rect;

    public Tile(){
        img = null;
        rect = new Rect();
    }

    public Tile(Image img){
        this.img = img;
        rect = new Rect(0,0, this.img.getWidth(), this.img.getHeight());
    }

    public Tile(Image img, Rect rect){
        this.img = img;
        this.rect = rect;
    }


}
