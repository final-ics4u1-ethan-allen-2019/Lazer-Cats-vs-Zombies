package engine;

/*
    Project title: Lazer Cats vs Zombies
    -----------------------------------------------
    ClassName: Time
    -----------------------------------------------
    What it does: Keeps track of time
    -----------------------------------------------
    For: ICS4U1 - Holik
    -----------------------------------------------
    By: Ethan and Allen
    -----------------------------------------------
    Last Edited: June 18th 2019
 */

/** Gets time
 *
 */
public class Time {

    public static double deltaTime = 0, fps = 0;
    private static long lastTime = 0, startTime = 0;

    /** Updates time
     *
     * @param nanoTime current time
     */
    public static void updateTime(long nanoTime) {
        if (startTime == 0) {
            lastTime = nanoTime;
            startTime = nanoTime;
        } else {
            deltaTime = nanoTime - lastTime;
            deltaTime /= 1000000000d;
            fps = 1d/deltaTime;
            lastTime = nanoTime;
        }
    }

    /** Gets time elapsed
     *
     * @return current time
     */
    public static long getTotalTime() {
        return lastTime - startTime;
    }

}
