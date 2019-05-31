package game;

import engine.Cropper;
import engine.Game;
import engine.GameObject;
import engine.scenes.GameScene;
import engine.scenes.SceneManager;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Main extends Game {

    @Override
    public void load() {
        ArrayList<GameObject> objects = new ArrayList<>();

        //GameObject objecto = new GameObject();

        //objecto.x = 400;
        //objecto.y = 400;

        //objecto.addScript(new SpriteRenderer(TOP_LEFT_LIGHT_STONE_DENT.getImage(), 64, 64));

        //objects.add(objecto);

        GameObject object = new PlayerObject(new Player(Player.BodyType.TANNED2, Player.Gender.FEMALE, Player.NoseType.BIGNOSE, Player.EarType.ELVENEARS, Player.EyeColor.RED, Player.HairType.BANGS, Player.HairColor.BLUE));

        object.x = 400;
        object.y = 400;

        objects.add(object);

        object = new GameObject();

        object.addScript(new Borders());

        objects.add(object);

        GameScene scene = new GameScene(objects);

        SceneManager.addScene(scene);

        SceneManager.setScene(0);
    }

    private ArrayList[] create_sheet(Image image, int length) {
        Cropper cropper = new Cropper(image);
        ArrayList<Image> images = new ArrayList<>();
        for (int x = 1; x < length; x++) {
            images.add(cropper.crop(64*x,512,64,64));
        }
        ArrayList<Image> images1 = new ArrayList<>();
        for (int x = 1; x < length; x++) {
            images1.add(cropper.crop(64*x,576,64,64));
        }
        ArrayList<Image> images2 = new ArrayList<>();
        for (int x = 1; x < length; x++) {
            images2.add(cropper.crop(64*x,640,64,64));
        }
        ArrayList<Image> images3 = new ArrayList<>();
        for (int x = 1; x < length; x++) {
            images3.add(cropper.crop(64*x,704,64,64));
        }
        ArrayList<Image> images4 = new ArrayList<>();
        for (int x = 0; x < 1; x++) {
            images4.add(cropper.crop(64*x,640,64,64));
        }

        return new ArrayList[] {images, images1, images2, images3, images4};
    }

    public static ArrayList<Image>[] loadCharArray(Image image) {
        ArrayList<ArrayList> im = new ArrayList<>();
        Cropper crop = new Cropper(image);

        for (int y = 0; y < 21; y++) {
            ArrayList<Image> images = new ArrayList<>();
            if (y < 4) for (int x = 1; x < 7; x++) {
                images.add(crop.crop(x*64, y*64, 64, 64));
            } else if (y < 8) for (int x = 1; x < 8; x++) {
                images.add(crop.crop(x*64, y*64, 64, 64));
            } else if (y < 12) for (int x = 1; x < 9; x++) {
                images.add(crop.crop(x*64, y*64, 64, 64));
            } else if (y < 16) for (int x = 1; x < 6; x++) {
                images.add(crop.crop(x*64, y*64, 64, 64));
            } else if (y < 20) for (int x = 1; x < 13; x++) {
                images.add(crop.crop(x*64, y*64, 64, 64));
            } else for (int x = 1; x < 6; x++) {
                images.add(crop.crop(x*64, y*64, 64, 64));
            }
            im.add(images);
        }
        ArrayList<Image> images = new ArrayList<>();
        images.add(crop.crop(0, 8*64, 64, 64));
        im.add(images);

        images = new ArrayList<>();
        images.add(crop.crop(0, 9*64, 64, 64));
        im.add(images);

        images = new ArrayList<>();
        images.add(crop.crop(0, 10*64, 64, 64));
        im.add(images);

        images = new ArrayList<>();
        images.add(crop.crop(0, 11*64, 64, 64));
        im.add(images);

        return (ArrayList<Image>[]) im.toArray(new ArrayList[im.size()]);
    }

    public static void main(String[] args) {
        new Main().begin(args, 1280, 720, "My name jef");
    }

}
