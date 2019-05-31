package game.images;

import engine.Cropper;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import java.util.ArrayList;

public class TextureClassifier {

    private static Cropper cropper = new Cropper(new Image("game/images/background/terrain.png"));
    private static ArrayList<ArrayList<WritableImage>> backgroundList = cropper.cropSpriteSheets(32,32);


    //Make different enums for different categories of images
    public enum stills {

        GOTTEM (0, "game/images/GOTCHA.jpg"),
        HUMAN(0, "game/images/spritesheets/body/male/light.png"),
        CATE (0, "game/images/CATE.jpg");

        private final int id;
        private final String url;
        private final Image im;
        stills(int id, String url){
            this.id = id;
            this.url = url;
            this.im = new Image(url);
        }

        public Image getImage() {
            return this.im;
        }
        public String getUrl(){
            return this.url;
        }
        public int getId(){
            return this.id;
        }
    }

    public enum backgroundTiles {
        

    }

    public static stills[] getStillsList(){
        return stills.values();
    }
}
