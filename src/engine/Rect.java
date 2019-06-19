package engine;

/*
    Project title: Lazer Cats vs Zombies
    -----------------------------------------------
    ClassName: Rect
    -----------------------------------------------
    What it does: Rectangle class for 2d
    -----------------------------------------------
    For: ICS4U1 - Holik
    -----------------------------------------------
    By: Ethan and Allen
    -----------------------------------------------
    Last Edited: June 18th 2019
 */
import engine.math.Vector2;


/** Rectangle Class
 *
 */
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

    /**
     * Empty Constructor
     */
    public Rect() {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
        rect = new Vector2[2];
        rect[0] = new Vector2();
        rect[1] = new Vector2();
        updateRect();
    }

    /**
     * Constructor
     *
     * @param x      desired x
     * @param y      desired y
     * @param width  desired witdth
     * @param length desired height
     */
    public Rect(double x, double y, double width, double length) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = length;
        this.rect = new Vector2[2];
        rect[0] = new Vector2();
        rect[1] = new Vector2();
        updateRect();
    }

    /**
     * Constructor with vectors
     *
     * @param p1 top left corner
     * @param p2 bottom right corner
     */
    public Rect(Vector2 p1, Vector2 p2) {
        this.x = p1.x;
        this.y = p1.y;
        this.width = p2.x;
        this.height = p2.y;
        rect = new Vector2[2];
        rect[0] = new Vector2();
        rect[1] = new Vector2();
        updateRect();
    }

    //updates rect
    public void updateRect() {
        rect[0].x = x;
        rect[0].y = y;
        rect[1].x = x + width;
        rect[1].y = y + height;
    }

    /**
     * Gets rect
     *
     * @return returns rect
     */
    public Vector2[] getRect() {
        updateRect();
        return rect;
    }

    /**
     * Checks if a pair of coordinates are in the rect
     *
     * @param x target x
     * @param y target y
     * @return true if in; false if not
     */
    public boolean isIn(double x, double y) {
        if (x > this.x && x < rect[1].x && y > this.y && y < rect[1].y) {
            return true;
        }
        return false;
    }

    /**
     * Checks collision for a point
     *
     * @param vector vector given
     * @return true if in; false if not
     */
    public boolean isIn(Vector2 vector) {
        if (vector.x > this.x && vector.x < rect[1].x && vector.y > this.y && vector.y < rect[1].y) {
            return true;
        }
        return false;
    }
}