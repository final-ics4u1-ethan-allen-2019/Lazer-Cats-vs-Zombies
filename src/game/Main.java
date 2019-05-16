package game;

import engine.GameObject;
import engine.scripts.SpriteRenderer;

import java.util.ArrayList;

public class Main {

    static ArrayList<GameObject> objects = new ArrayList<>();

    public static void main(String[] args) {
        GameObject gm = new GameObject();

        gm.addScript(new SpriteRenderer(null));

        objects.add(gm);

        Entity entity = new Entity();

        entity.addScript(new CharacterMovement());

        objects.add(entity);

        while (true) {
            loop();
        }
    }

    public static void loop() {
        for (GameObject object : objects) {
            object.update();
        }
        for (GameObject object : objects) {
            object.render();
        }
    }

}
