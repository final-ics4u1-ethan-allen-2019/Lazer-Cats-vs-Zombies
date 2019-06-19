package engine.math;

/*
    Project title: Lazer Cats vs Zombies
    -----------------------------------------------
    ClassName: Vector 2d
    -----------------------------------------------
    What it does: 2d vector with x and y
    -----------------------------------------------
    For: ICS4U1 - Holik
    -----------------------------------------------
    By: Ethan and Allen
    -----------------------------------------------
    Last Edited: June 18th 2019
 */


public class Vector2 {

    public double x;
    public double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2() {
        x = 0;
        y = 0;
    }

    public Vector2 multiply(double val) {
        return new Vector2(this.x * val, this.y * val);
    }

    public Vector2 add(Vector2 vector2) {
        return new Vector2(this.x + vector2.x, this.y + vector2.y);
    }

    public Vector2 add(double x, double y) {
        return new Vector2(this.x + x, this.y + y);
    }

    public Vector2 subtract(Vector2 vector2) {
        return new Vector2(this.x - vector2.x, this.y - vector2.y);
    }

    public Vector2 subtract(double x, double y) {
        return new Vector2(this.x - x, this.y - y);
    }

    public double hypot() {
        return Math.hypot(this.x, this.y);
    }

    public Vector2 copy() {
        return new Vector2(x, y);
    }

}
