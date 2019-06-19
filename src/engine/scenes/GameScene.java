package engine.scenes;
/*
    Project title: Lazer Cats vs Zombies
    -----------------------------------------------
    ClassName: Game Scene
    -----------------------------------------------
    What it does: standard scene class for canvas
    -----------------------------------------------
    For: ICS4U1 - Holik
    -----------------------------------------------
    By: Ethan and Allen
    -----------------------------------------------
    Last Edited: June 18th 2019
 */
import engine.Game;
import engine.Rect;
import engine.objects.GameObject;
import engine.mapping.Map;
import engine.math.Vector2;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/** Standard game scene for canvas
 *
 */
public class GameScene {


    private ArrayList<GameObject> inactive;

    private ArrayList<GameObject> active;

    private ArrayList<GameObject> spawnLater = new ArrayList<>();

    private ArrayList<Map> maps;

    public Vector2 cameraPosition = new Vector2();

    public Rect camera = new Rect(cameraPosition, new Vector2(cameraPosition.x + Game.getWidth(), cameraPosition.y + Game.getHeight()));

    /** Constructor
     *
     * @param objects game objects
     */
    public GameScene(ArrayList<GameObject> objects) {
        inactive = objects;
    }

    /** Constructor
     *
     * @param objects game objects
     * @param maps1 maps
     */
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

    /** Loads scene
     *
     */
    public void onLoad() {
        active.forEach(GameObject::load);
    }

    /** Updates Scene
     *
     */
    public void update() {
        try {
            active.forEach(GameObject::update);
        } catch (ConcurrentModificationException ignored) {
            update();
        }
        active.addAll(spawnLater);
        spawnLater = new ArrayList<>();

        //updates cam pos
        camera.x = cameraPosition.x;
        camera.y = cameraPosition.y;
        camera.updateRect();
    }

    /** Renders all objects and maps
     *
     */
    public void render() {
        if (maps != null) {
            for (Map map : maps) {
                map.render();
            }
        }
        active.forEach(GameObject::render);
    }

    /** Delayed rendering
     *
     */
    public void lateRender() {
        active.forEach(GameObject::lateRender);
    }

    /** Spawns object onto scene
     *
     * @param object desired object
     */
    public void spawnObject(GameObject object) {
        object.load();
        spawnLater.add(object);
    }

    /** Gets active objects
     *
     * @return active objects
     */
    public ArrayList<GameObject> getActive() {
        return active;
    }

    /** Gets maps
     *
     * @return maps
     */
    public ArrayList<Map> getMaps() {
        return maps;
    }
}
