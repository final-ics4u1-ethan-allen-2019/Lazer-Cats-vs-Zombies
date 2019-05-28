package engine.scenes;

import engine.GameObject;
import engine.mapping.Map;
import engine.math.Vector2;

import java.util.ArrayList;

public class GameScene {

    private ArrayList<GameObject> inactive;

    private ArrayList<GameObject> active;

    private ArrayList<Map> maps;

    public Vector2 cameraPosition = new Vector2();

    public GameScene(ArrayList<GameObject> objects) {
        inactive = objects;
    }

    void unload() {
        active = null;
    }

    void load() {
        active = (ArrayList<GameObject>) inactive.clone();
        onLoad();
    }

    public void onLoad() {
        for (GameObject object : active) {
            object.load();
        }
    }

    public void update() {
        for (GameObject object : active) {
            object.update();
        }
    }

    public void render() {
        for (GameObject object : active) {
            object.render();
        }
    }

    public void spawnObject(GameObject object) {
        object.load();
        active.add(object);
    }

}
