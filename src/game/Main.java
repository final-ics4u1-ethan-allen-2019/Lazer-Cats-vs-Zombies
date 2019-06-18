package game;

import engine.Cropper;
import engine.Game;
import engine.mapping.DynamicMap;
import engine.mapping.Map;
import engine.math.Vector2;
import engine.objects.Button;
import engine.objects.GameObject;
import engine.scenes.GameScene;
import engine.scenes.SceneManager;
import engine.scripts.SpriteRenderer;
import game.enemies.Enemy;
import game.images.TextureClassifier;
import game.player.Player;
import game.player.PlayerObject;
import game.worldobjects.Chest;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Main extends Game {

    @Override
    public void load() {
        ArrayList<GameObject> objects = new ArrayList<>();

        GameObject objecto = new GameObject();
        objecto.x = 400;
        objecto.y = 400;

        objecto.addScript(new SpriteRenderer(TextureClassifier.BackgroundTiles.WATER_TILE_1.getImage(), 64, 64));
        objects.add(objecto);

        ArrayList<Map> maps = new ArrayList<Map>();
        maps.add(MapGenerator.generateDynamicMap("src/maps/Blacked.txt",32, 32));
        maps.add(MapGenerator.generateDynamicMap("src/maps/LavaMap.txt", 32 ,32));
        System.out.print(maps.size());
        objects.add(new Enemy("game/images/spritesheets/body/male/orc.png", 300, 600, 10));

        objects.add(new Chest());

        //GameScene scene = new GameScene(objects);
        GameScene scene = new GameScene(objects, maps);

        SceneManager.addScene(scene);

        SceneManager.addScene(createCharacterSelect());

        SceneManager.addScene(createStartScene());

        SceneManager.addScene(createIntructionScene());

        SceneManager.setScene(2);
    }

    private static GameScene createCharacterSelect() {
        ArrayList<GameObject> objects = new ArrayList<>();

        GameObject object = new GameObject();
        object.y = (Game.getHeight()/2)-200;
        object.x = (Game.getWidth()/2)-160;

        SpriteRenderer body = new SpriteRenderer(Player.BodyType.values()[0].getGender(Player.Gender.MALE)[2].get(0), 320, 320);
        object.addScript(body);

        SpriteRenderer hair = new SpriteRenderer(Player.HairType.values()[0].getSet(Player.HairColor.BLUE)[2].get(0), 320, 320);
        object.addScript(hair);

        SpriteRenderer eyes = new SpriteRenderer(Player.EyeColor.values()[0].images[2].get(0), 320, 320);
        object.addScript(eyes);

        SpriteRenderer ear = new SpriteRenderer(Player.BodyType.values()[0].getEars(Player.EarType.ELVENEARS)[2].get(0), 320, 320);
        object.addScript(ear);

        SpriteRenderer nose = new SpriteRenderer(Player.BodyType.values()[0].getNose(Player.NoseType.BIGNOSE)[2].get(0), 320, 320);
        object.addScript(nose);

        CharacterSelect c = new CharacterSelect(body, hair, eyes, ear, nose);
        object.addScript(c);

        objects.add(object);

        Button b = new Button(new Vector2(64*7, 350), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "<-");
        b.setOnClick(c::prevBody);
        objects.add(b);

        b = new Button(new Vector2((64*12)+32, 350), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "->");
        b.setOnClick(c::nextBody);
        objects.add(b);

        b = new Button(new Vector2(64*7, 230), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "<-");
        b.setOnClick(c::prevHair);
        objects.add(b);

        b = new Button(new Vector2((64*12)+32, 230), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "->");
        b.setOnClick(c::nextHair);
        objects.add(b);

        b = new Button(new Vector2(64*6, 230), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "<-");
        b.setOnClick(c::prevHairColor);
        objects.add(b);

        b = new Button(new Vector2((64*13)+32, 230), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "->");
        b.setOnClick(c::nextHairColor);
        objects.add(b);

        b = new Button(new Vector2(64*7, 270), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "<-");
        b.setOnClick(c::prevEye);
        objects.add(b);

        b = new Button(new Vector2((64*12)+32, 270), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "->");
        b.setOnClick(c::nextEye);
        objects.add(b);

        b = new Button(new Vector2(64*7, 310), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "<-");
        b.setOnClick(c::prevEar);
        objects.add(b);

        b = new Button(new Vector2((64*12)+32, 310), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "->");
        b.setOnClick(c::nextEar);
        objects.add(b);

        b = new Button(new Vector2(64*6, 350), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "<-");
        b.setOnClick(c::prevGender);
        objects.add(b);

        b = new Button(new Vector2((64*13)+32, 350), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "->");
        b.setOnClick(c::nextGender);
        objects.add(b);

        b = new Button(new Vector2(64*7, 390), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "<-");
        b.setOnClick(c::prevNose);
        objects.add(b);

        b = new Button(new Vector2((64*12)+32, 390), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "->");
        b.setOnClick(c::nextNose);
        objects.add(b);

        b = new Button(new Vector2((64*16)+32, 600), new Vector2(30, 30), Color.LIGHTGRAY, Color.TRANSPARENT, Color.TRANSPARENT, "GO");
        b.setOnClick(() -> {
            GameObject obj = new PlayerObject(c.makePlayer());

            obj.x = 1000;
            obj.y = 1000;

            SceneManager.setScene(0);
            SceneManager.getCurrentGameScene().spawnObject(obj);
        });
        objects.add(b);

        return new GameScene(objects);
    }

    public static GameScene createStartScene(){
        ArrayList<GameObject> objects = new ArrayList<>();
        ArrayList<Map> maps = new ArrayList<>();


        Vector2 buttonSize = new Vector2(200,50);


        Button b = new Button(new Vector2(640 - 400/2, 200 - 200/2), new Vector2(400,75), Color.WHITE, Color.WHITE, Color.WHITE, 32, "Lazer Cats vs Zombies");
        objects.add(b);

        b = new Button(new Vector2(640 - buttonSize.x/2, 350 - buttonSize.y/2), buttonSize, Color.GREENYELLOW, Color.RED, Color.DEEPSKYBLUE, 20, "PLAY");
        b.setOnClick(() ->{
            SceneManager.setScene(1);
        });
        objects.add(b);

        b = new Button(new Vector2(640 - buttonSize.x/2, 350 - buttonSize.y/2), buttonSize, Color.GREENYELLOW, Color.RED, Color.DEEPSKYBLUE, 20, "PLAY");
        b.setOnClick(() ->{
            SceneManager.setScene(1);
        });
        objects.add(b);

        b = new Button(new Vector2(640 - buttonSize.x/2, 250 - buttonSize.y/2), buttonSize, Color.GREENYELLOW, Color.RED, Color.DEEPSKYBLUE, 20, "INSTRUCTIONS");
        b.setOnClick(() ->{
            SceneManager.setScene(3);
        });
        objects.add(b);

        maps.add(MapGenerator.generateDynamicMap("src/maps/Blacked.txt", 32, 32));

        GameScene scene = new GameScene(objects, maps);
        return scene;
    }

    private static GameScene createIntructionScene(){
        ArrayList<GameObject> objects = new ArrayList<>();
        ArrayList<Map> maps = new ArrayList<>();


        Vector2 textSize = new Vector2(400,75);

        Vector2 buttonSize = new Vector2(200,50);


        Button b = new Button(new Vector2(640 - textSize.x/2, 100 - textSize.y/2), textSize, Color.WHITE, Color.WHITE, Color.WHITE, 20, "W, A, S, D to control");
        objects.add(b);

        b = new Button(new Vector2(640 - textSize.x/2, 200 - textSize.y/2), textSize, Color.WHITE, Color.WHITE, Color.WHITE, 20, "Don't Let the Goblins touch you");
        objects.add(b);

        b = new Button(new Vector2(640 - textSize.x/2, 300 - textSize.y/2), textSize, Color.WHITE, Color.WHITE, Color.WHITE, 20, "Left Click on enemies to attack");
        objects.add(b);

        b = new Button(new Vector2(1000 - buttonSize.x/2, 600 - buttonSize.y/2), buttonSize, Color.GREENYELLOW, Color.RED, Color.DEEPSKYBLUE, 20, "Back");
        b.setOnClick(() ->{
            SceneManager.setScene(2);
        });
        objects.add(b);

        return new GameScene(objects, maps);

    }

    // Create spritesheet array
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
        new Main().begin(args, 1280, 700, "My name jef");
    }

}
