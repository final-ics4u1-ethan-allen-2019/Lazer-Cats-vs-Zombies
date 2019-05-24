package engine.scenes;

import java.util.ArrayList;

public class SceneManager {

    private static ArrayList<GameScene> scenes = new ArrayList<>();
    private static int currentId;

    public static GameScene getCurrentGameScene() {
        return scenes.get(currentId);
    }

    public static void setScene(int id) {
        GameScene scene = scenes.get(currentId);
        if (scene != null) scene.unload();
        currentId = id;
        scene = scenes.get(id);
        if (scene != null) scene.load();
    }

    public static void addScene(GameScene scene) {
        scenes.add(scene);
    }

    public static void removeScene(GameScene scene) {
        scenes.remove(scene);
    }

    public static void removeScene(int num) {
        scenes.remove(num);
    }

}
