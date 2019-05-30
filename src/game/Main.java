package game;

import engine.Cropper;
import engine.Game;
import engine.GameObject;
import engine.scenes.GameScene;
import engine.scenes.SceneManager;
import engine.scripts.Animator;
import engine.scripts.SpriteRenderer;
import javafx.scene.image.Image;

import java.util.ArrayList;

import static game.images.TextureClassifier.stills.HUMAN;

public class Main extends Game {

    @Override
    public void load() {
        ArrayList<GameObject> objects = new ArrayList<>();

        GameObject object = new GameObject();

        object.x = 400;
        object.y = 400;

        object.addScript(new PlayerScript());
        object.addScript(new SpriteRenderer(HUMAN.getImage(), 64, 64));
        Cropper cropper = new Cropper(HUMAN.getImage());
        ArrayList<Image> images = new ArrayList<>();
        for (int x = 1; x < 9; x++) {
            images.add(cropper.crop(64*x,512,64,64));
        }
        ArrayList<Image> images1 = new ArrayList<>();
        for (int x = 1; x < 9; x++) {
            images1.add(cropper.crop(64*x,576,64,64));
        }
        ArrayList<Image> images2 = new ArrayList<>();
        for (int x = 1; x < 9; x++) {
            images2.add(cropper.crop(64*x,640,64,64));
        }
        ArrayList<Image> images3 = new ArrayList<>();
        for (int x = 1; x < 9; x++) {
            images3.add(cropper.crop(64*x,704,64,64));
        }
        ArrayList<Image> images4 = new ArrayList<>();
        for (int x = 0; x < 1; x++) {
            images4.add(cropper.crop(64*x,640,64,64));
        }

        object.addScript(new Animator(new ArrayList[] {images, images1, images2, images3, images4}, 0.1));

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
