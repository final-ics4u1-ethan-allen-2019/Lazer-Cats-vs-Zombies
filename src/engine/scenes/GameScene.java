package engine.scenes;

import engine.Game;
import engine.Rect;
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

    public Rect camera = new Rect(cameraPosition, new Vector2(cameraPosition.x + Game.getWidth(), cameraPosition.y + Game.getHeight()));

    public GameScene(ArrayList<GameObject> objects) {
        inactive = objects;
    }
    public GameScene(ArrayList<GameObject> objects, ArrayList<Map> maps1) {
        inactive = objects;
        //System.out.println(maps1.size());
        this.maps = (ArrayList<Map>) maps1.clone();
        for (Map map : maps){
            map.setScene(this);
        }
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
        camera.x = cameraPosition.x;
        camera.y = cameraPosition.y;
        camera.updateRect();
    }

    public void render() {
        
        if (maps != null) {
            for (Map map : maps) {
                map.render();
            }
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
}
