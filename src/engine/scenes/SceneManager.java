package engine.scenes;

import java.util.ArrayList;

public class SceneManager {

    private static ArrayList<GameScene> scenes = new ArrayList<>();

    public static void getCurrentGameScene() {

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
