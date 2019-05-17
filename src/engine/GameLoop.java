package engine;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

    @Override
    public void handle(long now) {
        Time.updateTime(now);

        // Scene update

        // Scene draw

    }

}
