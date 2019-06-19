package engine.mapping;

import engine.Draw;
import engine.objects.GameObject;
import engine.Rect;
import javafx.scene.image.Image;


public class Tile extends GameObject {

    protected Image img;
    protected Rect rect;
    protected Map map;
    protected boolean traversable;

    /** Empty constructor
     *
     */
    public Tile(){
        super();
        img = null;
        rect = new Rect();
        traversable = true;
    }

    /** Constructor
     *
     * @param img takes image
     */
    public Tile(Image img){
        super();
        this.img = img;
        rect = new Rect(0,0, this.img.getWidth(), this.img.getHeight());
        traversable = true;
    }

    /** Constructor
     *
     * @param img set image
     * @param rect set rect(dimensions)
     */
    public Tile(Image img, Rect rect){
        super();
        this.img = img;
        this.rect = rect;
        traversable = true;
    }

    /** Constructor
     *
     * @param img set image
     * @param x sets x
     * @param y sets y
     * @param width sets witdh
     * @param height sets height
     */
    public Tile(Image img, double x, double y, double width, double height){
        super();
        this.img = img;
        this.rect = new Rect(x, y, width, height);
        traversable = true;
    }

    /** Renders tile
     *
     */
    @Override
    public void render(){

        //check if in screen
        if (map.getScene().camera.isIn(this.rect.getRect()[0]) || map.getScene().camera.isIn(this.rect.getRect()[1]) || map.getScene().camera.isIn(this.rect.getRect()[0].x, this.rect.getRect()[1].y) || map.getScene().camera.isIn(this.rect.getRect()[1].x, this.rect.getRect()[0].y)){
            Draw.drawImage(img, rect.x, rect.y, rect.width, rect.height);
        }
    }

    /** Sets image
     *
     * @param img desired image
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /** Gets rect
     *
     * @return rect
     */
    public Rect getRect(){
        return this.rect;
    }

    /** sets map
     *
     * @param map parent map
     */
    public void setMap(Map map) {
        this.map = map;
    }

    /** Sets traversable
     *
     * @param traversable true: walkable, false: impassable
     */
    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
    }

    /** Gets traversable
     *
     * @return traversable
     */
    public boolean getTraversable(){
        return traversable;
    }
}
