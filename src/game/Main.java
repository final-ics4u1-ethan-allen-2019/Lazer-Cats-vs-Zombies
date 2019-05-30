package game;

import engine.Cropper;
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
import static game.images.TextureClassifier.stills.HUMAN;

public class Main extends Game {

    @Override
    public void load() {
        ArrayList<GameObject> objects = new ArrayList<>();

        GameObject object = new GameObject();

        object.x = 400;
        object.y = 400;

        object.addScript(new CharacterMovement());
        object.addScript(new SpriteRenderer(HUMAN.getImage()));
        Cropper cropper = new Cropper(HUMAN.getImage());
        ArrayList<Image> images = new ArrayList<>();
        for (int x = 0; x < 8; x++) {
            images.add(cropper.crop(60*x,400,60,80));
        }
        object.addScript(new Animator(new ArrayList[] {images}, 0.15));

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
