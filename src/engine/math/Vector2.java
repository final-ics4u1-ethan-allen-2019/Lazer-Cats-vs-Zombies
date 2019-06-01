package engine.math;

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

    public Vector2 copy() {
        return new Vector2(x, y);
    }

}
