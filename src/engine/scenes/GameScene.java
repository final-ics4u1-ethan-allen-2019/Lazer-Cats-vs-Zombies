package engine.scenes;

import engine.objects.GameObject;
import engine.mapping.Map;
import engine.math.Vector2;

import java.util.ArrayList;

public class GameScene {

    private ArrayList<GameObject> inactive;

    private ArrayList<GameObject> active;

    private ArrayList<GameObject> spawnLater = new ArrayList<>();

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
        active.addAll(spawnLater);
        spawnLater = new ArrayList<>();
        for (GameObject object : active) {
            object.update();
        }
    }

    public void render() {
        for (Map map : maps){
            map.render();
        }
        for (GameObject object : active) {
            object.render();
        }
    }

    public void spawnObject(GameObject object) {
        object.load();
        spawnLater.add(object);
    }

    public ArrayList<GameObject> getActive() {
        return active;
    }
    public void addMap(Map map){
        if (maps == null){
            maps = new ArrayList<>();
        }
        maps.add(map);
    }

}
