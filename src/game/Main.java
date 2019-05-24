package game;

import engine.Game;
import engine.GameObject;
import engine.scenes.GameScene;
import engine.scenes.SceneManager;
import engine.scripts.SpriteRenderer;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Main extends Game {

    @Override
    public void load() {
        ArrayList<GameObject> objects = new ArrayList<>();

        GameObject object = new GameObject();

        object.x = 400;
        object.y = 400;

        object.addScript(new CharacterMovement());
        //object.addScript(new SpriteRenderer(new Image(getClass().getResource("GOTCHA copy.jpg").toString()), 21*2, 24*2));

        objects.add(object);

        GameScene scene = new GameScene(objects);

        SceneManager.addScene(scene);

        SceneManager.setScene(0);
    }

    public static void main(String[] args) {
        new Main().begin(args, 1280, 720, "My name jef");
    }

}
