package engine;

import engine.scenes.GameScene;
import engine.scenes.SceneManager;
import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

    @Override
    public void handle(long now) {
        Time.updateTime(now);

        Draw.clear();

        GameScene scene = SceneManager.getCurrentGameScene();

        if (scene != null) {
            // Scene update
            scene.update();

            // Scene draw
            scene.render();
        }
    }

}
