package engine.scenes;

import engine.GameObject;
import engine.mapping.Map;

import java.util.ArrayList;

public class GameScene {

    private ArrayList<GameObject> inactive;

    private ArrayList<GameObject> active;

    private ArrayList<Map> maps;

    public GameScene(ArrayList<GameObject> objects) {
        inactive = objects;
    }

    void unload() {
        active = null;
    }

    void load() {
        active = (ArrayList<GameObject>) inactive.clone();
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
        active.add(object);
    }

}
