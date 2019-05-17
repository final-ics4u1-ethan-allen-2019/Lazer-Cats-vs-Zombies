package engine;

public class Time {

    public static double deltaTime = 0, fps = 0;
    private static long lastTime = 0, startTime = 0;

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

    public static long getTotalTime() {
        return lastTime - startTime;
    }

}
