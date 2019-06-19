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

/** Vector for 2 dimensions
 *
 */
public class Vector2 {

    /** x position
     *
     */
    public double x;

    /** y position
     *
     */
    public double y;

    /** Constructor
     *
     * @param x desired x
     * @param y desired y
     */
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /** Empty constructor
     *
     */
    public Vector2() {
        x = 0;
        y = 0;
    }

    /** Vector scalar mulitplication
     *
     * @param val desired scaling
     * @return new scaled Vector2 object
     */
    public Vector2 multiply(double val) {
        return new Vector2(this.x * val, this.y * val);
    }

    /** Vector addition
     *
     * @param vector2 other vector
     * @return added resultant Vector2
     */
    public Vector2 add(Vector2 vector2) {
        return new Vector2(this.x + vector2.x, this.y + vector2.y);
    }

    /** Vector addition with x and y
     *
     * @param x desired x
     * @param y desired y
     * @return added resultant Vector2
     */
    public Vector2 add(double x, double y) {
        return new Vector2(this.x + x, this.y + y);
    }

    /** Vector subtraction
     *
     * @param vector2 other vector
     * @return subtracted resultant vector
     */
    public Vector2 subtract(Vector2 vector2) {
        return new Vector2(this.x - vector2.x, this.y - vector2.y);
    }

    /** Vector Subtraction
     *
     * @param x other x
     * @param y other y
     * @return subtracted resultant vector
     */
    public Vector2 subtract(double x, double y) {
        return new Vector2(this.x - x, this.y - y);
    }

    /** Gets hypotenuse
     *
     * @return hypotenuse of the vector
     */
    public double hypot() {
        return Math.hypot(this.x, this.y);
    }

    /** Copies vector
     *
     * @return a new instance of the vector
     */
    public Vector2 copy() {
        return new Vector2(x, y);
    }

}
