package game;

import engine.Game;
import engine.math.Vector2;
import engine.scenes.SceneManager;
import engine.scripts.Script;

public class CharacterMovement extends Script {

    @Override
    public void update() {


        SceneManager.getCurrentGameScene().cameraPosition = new Vector2(parent.x-(Game.getWidth()/2), parent.y-(Game.getHeight()/2));
    }
}
