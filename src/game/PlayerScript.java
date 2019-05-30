package game;

import engine.Game;
import engine.Time;
import engine.input.KeyboardInput;
import engine.math.Vector2;
import engine.scenes.SceneManager;
import engine.scripts.Animator;
import engine.scripts.Script;
import javafx.scene.input.KeyCode;

public class PlayerScript extends Script {

    Animator anim;

    @Override
    public void load() {
        for (Script script : parent.getScripts()) {
            if (script instanceof Animator) {
                anim = (Animator) script;
                break;
            }
        }
    }

    @Override
    public void update() {
        boolean moving = false;
        if (KeyboardInput.isKeyDown(KeyCode.W)) {
            anim.setState(0);
            parent.y -= 200 * Time.deltaTime;
            moving = true;
        }
        if (KeyboardInput.isKeyDown(KeyCode.S)) {
            anim.setState(2);
            parent.y += 200 * Time.deltaTime;
            moving = true;
        }
        if (KeyboardInput.isKeyDown(KeyCode.A)) {
            anim.setState(1);
            parent.x -= 200 * Time.deltaTime;
            moving = true;
        }
        if (KeyboardInput.isKeyDown(KeyCode.D)) {
            anim.setState(3);
            parent.x += 200 * Time.deltaTime;
            moving = true;
        }
        if (!moving) anim.setState(4);

        SceneManager.getCurrentGameScene().cameraPosition = new Vector2(parent.x-(Game.getWidth()/2), parent.y-(Game.getHeight()/2));
    }
}
