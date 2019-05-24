package game;

import engine.Game;
import engine.GameObject;
import engine.scenes.GameScene;
import engine.scenes.SceneManager;

import java.util.ArrayList;

public class Main extends Game {

    public static void main(String[] args) {
        ArrayList<GameObject> objects = new ArrayList<>();

        GameObject object = new GameObject();

        object.x = 400;
        object.y = 400;

        object.addScript(new CharacterMovement());

        objects.add(object);

        GameScene scene = new GameScene(objects);

        SceneManager.addScene(scene);

        SceneManager.setScene(0);

        new Main().begin(args, 1280, 720, "My name jef");
    }

}
