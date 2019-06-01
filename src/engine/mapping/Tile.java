package engine.mapping;

import engine.Draw;
import engine.GameObject;
import engine.Rect;
import javafx.scene.image.Image;


public class Tile extends GameObject {

    private Image img;
    private Rect rect;
    public Tile(){
        super();
        img = null;
        rect = new Rect();
    }

    public Tile(Image img){
        super();
        this.img = img;
        rect = new Rect(0,0, this.img.getWidth(), this.img.getHeight());
    }

    public Tile(Image img, Rect rect){
        super();
        this.img = img;
        this.rect = rect;
    }

    public Tile(Image img, int x, int y, int width, int height){
        super();
        this.img = img;
        this.rect = new Rect(x, y, width, height);
    }

    @Override
    public void render(){
        Draw.drawImage(img, rect.x, rect.y, rect.width, rect.length);
    }


}
