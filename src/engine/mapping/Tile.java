package engine.mapping;

import engine.Draw;
import engine.objects.GameObject;
import engine.Rect;
import javafx.scene.image.Image;


public class Tile extends GameObject {

    protected Image img;
    protected Rect rect;
    protected Map map;

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

    public Tile(Image img, double x, double y, double width, double height){
        super();
        this.img = img;
        this.rect = new Rect(x, y, width, height);
    }

    @Override
    public void render(){
        if (map.getScene().camera.isIn(this.rect.getRect()[0]) || map.getScene().camera.isIn(this.rect.getRect()[1]) || map.getScene().camera.isIn(this.rect.getRect()[0].x, this.rect.getRect()[1].y) || map.getScene().camera.isIn(this.rect.getRect()[1].x, this.rect.getRect()[0].y)){
            Draw.drawImage(img, rect.x, rect.y, rect.width, rect.height);
        }
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Rect getRect(){
        return this.rect;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
