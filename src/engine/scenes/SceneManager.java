package engine.scenes;
/*
    Project title: Lazer Cats vs Zombies
    -----------------------------------------------
    ClassName: SceneManager
    -----------------------------------------------
    What it does: holds all scenes
    -----------------------------------------------
    For: ICS4U1 - Holik
    -----------------------------------------------
    By: Ethan and Allen
    -----------------------------------------------
    Last Edited: June 18th 2019
 */
import java.util.ArrayList;

/** Scene Manager
 * @see GameScene
 */
public class SceneManager {

    private static ArrayList<GameScene> scenes = new ArrayList<>();
    private static int currentId;

    /** Gets the current/active game scene
     *
     * @return the current game scene
     */
    public static GameScene getCurrentGameScene() {
        return scenes.get(currentId);
    }

    /** Sets the active scene to the scene id
     *
     * @param id the id of the scene you would like to set
     */
    public static void setScene(int id) {
        GameScene scene = scenes.get(currentId);
        if (scene != null) scene.unload();
        currentId = id;
        scene = scenes.get(id);
        if (scene != null) scene.load();
    }

    /** Add a scene to the scene list
     *
     * @param scene Scene you would like to add
     */
    public static void addScene(GameScene scene) {
        scenes.add(scene);
    }

    /** Remove a scene from the scene list
     *
     * @param scene the scene you would like to remove
     */
    public static void removeScene(GameScene scene) {
        scenes.remove(scene);
    }

    /** Remove a scene from the scene list
     *
     * @param num the scene you would like to remove using id
     */
    public static void removeScene(int num) {
        scenes.remove(num);
    }

}
