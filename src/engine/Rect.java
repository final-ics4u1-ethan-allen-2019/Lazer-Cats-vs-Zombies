package engine;

import engine.math.Vector2;

public class Rect {

    public double x;
    public double y;
    public double width;
    public double height;
    private Vector2[] rect;
    /*
    double[][] rect works like this
    [0] = point 1
    [1] = point 2

       [0]------|
        |       |
        |       |
        |------[1]

     */
    public Rect(){
        x = 0;
        y = 0;
        width = 0;
        height = 0;
        rect = new Vector2[2];
        rect[0] = new Vector2();
        rect[1] = new Vector2();
        updateRect();
    }

    public Rect(double x, double y, double width, double length){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = length;
        this.rect = new Vector2[2];
        rect[0] = new Vector2();
        rect[1] = new Vector2();
        updateRect();
    }

    public Rect(Vector2 p1, Vector2 p2){
        this.x = p1.x;
        this.y = p1.y;
        this.width = p2.x;
        this.height = p2.y;
        rect = new Vector2[2];
        rect[0] = new Vector2();
        rect[1] = new Vector2();
        updateRect();
    }

    private void updateRect(){
        rect[0].x = x;
        rect[0].y = y;
        rect[1].x = x + width;
        rect[1].y = y + height;
    }

    public Vector2[] getRect() {
        updateRect();
        return rect;
    }

    public boolean isIn(double x, double y){
        if (x > this.x && x < rect[1].x && y > this.y && y < rect[1].y){
            System.out.println("X: " + this.x + "   Y: " + this.y + "   X2: " + rect[1].x + "   Y2: " + rect[1].y);
            return true;
        }
        return false;
    }
}
