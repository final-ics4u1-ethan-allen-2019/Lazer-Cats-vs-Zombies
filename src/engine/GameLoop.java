package engine;

/*
    Project title: Lazer Cats vs Zombies
    -----------------------------------------------
    ClassName: GameLoop
    -----------------------------------------------
    What it does: Animation loop and update loop
    -----------------------------------------------
    For: ICS4U1 - Holik
    -----------------------------------------------
    By: Ethan and Allen
    -----------------------------------------------
    Last Edited: June 18th 2019
 */
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
            if (scene == SceneManager.getCurrentGameScene()) {
                scene.render();
                scene.lateRender();
            }

        }
    }

}
