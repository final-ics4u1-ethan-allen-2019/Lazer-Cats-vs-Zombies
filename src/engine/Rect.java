package engine;

public class Rect {

    private double x;
    private double y;
    private double width;
    private double length;
    private double[][] rect;
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
        rect = new double[2][2];
        updateRect();
    }

    public Rect(double x, double y, double width, double length){
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        rect = new double[2][2];
        updateRect();
    }

    public void updateRect(){
        rect[0][0] = x;
        rect[0][1] = y;
        rect[1][0] = x + width;
        rect[1][1] = y + length;
    }
}
