package game;

import engine.Game;
import engine.GameObject;
import engine.math.Vector2;
import engine.scenes.GameScene;
import engine.scenes.SceneManager;
import engine.scripts.Animator;
import engine.scripts.SpriteRenderer;
import javafx.scene.image.Image;

import java.util.ArrayList;

import static game.images.TextureClassifier.stills.CATE;
import static game.images.TextureClassifier.stills.GOTTEM;

public class Main extends Game {

    @Override
    public void load() {
        ArrayList<GameObject> objects = new ArrayList<>();

        GameObject object = new GameObject();

        object.x = 400;
        object.y = 400;

        object.addScript(new CharacterMovement());
        object.addScript(new SpriteRenderer(new Image(GOTTEM.getUrl()), 40, 40).setOffset(new Vector2(-20, -20)));
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image(GOTTEM.getUrl()));
        images.add(new Image(CATE.getUrl()));
        object.addScript(new Animator(new ArrayList[] {images}, 0));

        objects.add(object);

        object = new GameObject();

        object.addScript(new Borders());

        objects.add(object);

        GameScene scene = new GameScene(objects);

        SceneManager.addScene(scene);

        SceneManager.setScene(0);
    }

    public static void main(String[] args) {
        new Main().begin(args, 1280, 720, "My name jef");
    }

}
