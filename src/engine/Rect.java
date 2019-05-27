package engine;

import engine.math.Vector2;

public class Rect {

    public double x;
    public double y;
    public double width;
    public double length;
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
        length = 0;
        rect = new Vector2[2];
        updateRect();
    }

    public Rect(double x, double y, double width, double length){
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        rect = new Vector2[2];
        updateRect();
    }

    public Rect(Vector2 p1, Vector2 p2){
        this.x = p1.x;
        this.y = p1.y;
        this.width = p2.x;
        this.length = p2.y;
        rect = new Vector2[2];
        updateRect();
    }

    private void updateRect(){
        rect[0].x = x;
        rect[0].y = y;
        rect[1].x = x + width;
        rect[1].y = y + length;
    }

    public Vector2[] getRect() {
        updateRect();
        return rect;
    }
}
