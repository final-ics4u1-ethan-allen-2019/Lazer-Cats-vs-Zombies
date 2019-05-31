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
        LIGHT_STONE_0 (0, backgroundList.get(0).get(0)),
        LIGHT_STONE_DENT_TOP_LEFT(1, backgroundList.get(0).get(1)),
        LIGHT_STONE_DENT_TOP_RIGHT(2, backgroundList.get(0).get(2)),
        BROWN_STONE_0 (3, backgroundList.get(0).get(3)),
        BROWN_STONE_DENT_TOP_LEFT(4, backgroundList.get(0).get(4)),
        BROWN_STONE_DENT_TOP_RIGHT(5, backgroundList.get(0).get(5)),
        DARKBROWN_STONE_0 (6, backgroundList.get(0).get(6)),
        DARKBROWN_STONE_DENT_TOP_LEFT(7, backgroundList.get(0).get(7)),
        DARKBROWN_STONE_DENT_TOP_RIGHT(8, backgroundList.get(0).get(8)),
        BLACKSTONE_0 (9, backgroundList.get(0).get(9)),
        BLACK_STONE_DENT_TOP_LEFT(10, backgroundList.get(0).get(10)),
        BLACK_STONE_DENT_TOP_RIGHT(11, backgroundList.get(0).get(11)),
        GREYSTONE_0 (12, backgroundList.get(0).get(12)),
        GREY_STONE_DENT_TOP_LEFT(13, backgroundList.get(0).get(13)),
        GREY_STONE_DENT_TOP_RIGHT(14, backgroundList.get(0).get(14)),
        M_LAVAPOOL (15, backgroundList.get(0).get(15)),
        LAVA_INVERSE_HOLE_DENT_TOP_LEFT(16, backgroundList.get(0).get(16)),
        LAVA_INVERSE_HOLE_DENT_TOP_RIGHT(17, backgroundList.get(0).get(17)),
        M_LIGHT_HOLE (18, backgroundList.get(0).get(18)),
        LIGHT_INVERSE_HOLE_TOP_LEFT(19, backgroundList.get(0).get(19)),
        LIGHT_INVERSE_HOLE_TOP_RIGHT(20, backgroundList.get(0).get(20)),
        M_DARK_HOLE (21, backgroundList.get(0).get(21)),
        DARK_INVERSE_HOLE_TOP_LEFT(22, backgroundList.get(0).get(22)),
        DARK_INVERSE_HOLE_TOP_RIGHT(23, backgroundList.get(0).get(23)),
        M_BLACK_HOLE (24, backgroundList.get(0).get(24)),
        BLACK_INVERSE_HOLE_TOP_LEFT(25, backgroundList.get(0).get(25)),
        BLACK_INVERSE_HOLE_TOP_RIGHT(26, backgroundList.get(0).get(26)),
        M_WATER_HOLE (27, backgroundList.get(0).get(27)),
        WATER_INVERSE_HOLE_TOP_LEFT(28, backgroundList.get(0).get(28)),
        WATER_INVERSE_HOLE_TOP_RIGHT(29, backgroundList.get(0).get(29)),
        CLIFF_EDGE_TOP_LEFT_0 (30, backgroundList.get(0).get(30)),
        CLIFF_EDGE_TOP_RIGHT_0 (31, backgroundList.get(0).get(31)),

        /*EDDDIITES HERESERSERSER
        LIGHT_STONE_1 (0, backgroundList.get(0).get(0)),
        LIGHT_STONE_DENT_TOP_LEFT(1, backgroundList.get(0).get(1)),
        LIGHT_STONE_DENT_TOP_RIGHT(2, backgroundList.get(0).get(2)),
        BROWN_STONE_1 (3, backgroundList.get(0).get(3)),
        BROWN_STONE_DENT_TOP_LEFT(4, backgroundList.get(0).get(4)),
        BROWN_STONE_DENT_TOP_RIGHT(5, backgroundList.get(0).get(5)),
        DARKBROWN_STONE_1 (6, backgroundList.get(0).get(6)),
        DARKBROWN_STONE_DENT_TOP_LEFT(7, backgroundList.get(0).get(7)),
        DARKBROWN_STONE_DENT_TOP_RIGHT(8, backgroundList.get(0).get(8)),
        BLACKSTONE_1 (9, backgroundList.get(0).get(9)),
        BLACK_STONE_DENT_TOP_LEFT(10, backgroundList.get(0).get(10)),
        BLACK_STONE_DENT_TOP_RIGHT(11, backgroundList.get(0).get(11)),
        GREYSTONE_1 (12, backgroundList.get(0).get(12)),
        GREY_STONE_DENT_TOP_LEFT(13, backgroundList.get(0).get(13)),
        GREY_STONE_DENT_TOP_RIGHT(14, backgroundList.get(0).get(14)),
        M_LAVAPOOL (15, backgroundList.get(0).get(15)),
        LAVA_INVERSE_HOLE_TOP_LEFT(16, backgroundList.get(0).get(16)),
        LAVA_INVERSE_HOLE_DENT_TOP_RIGHT(17, backgroundList.get(0).get(17)),
        M_LIGHT_HOLE (18, backgroundList.get(0).get(18)),
        LIGHT_INVERSE_HOLE_TOP_LEFT(19, backgroundList.get(0).get(19)),
        LIGHT_INVERSE_HOLE_TOP_RIGHT(20, backgroundList.get(0).get(20)),
        M_DARK_HOLE (21, backgroundList.get(0).get(21)),
        DARK_INVERSE_HOLE_TOP_LEFT(22, backgroundList.get(0).get(22)),
        DARK_INVERSE_HOLE_TOP_RIGHT(23, backgroundList.get(0).get(23)),
        M_BLACK_HOLE (24, backgroundList.get(0).get(24)),
        BLACK_INVERSE_HOLE_TOP_LEFT(25, backgroundList.get(0).get(25)),
        BLACK_INVERSE_HOLE_TOP_RIGHT(26, backgroundList.get(0).get(26)),
        M_WATER_HOLE (27, backgroundList.get(0).get(27)),
        WATER_INVERSE_HOLE_TOP_LEFT(28, backgroundList.get(0).get(28)),
        WATER_INVERSE_HOLE_TOP_RIGHT(29, backgroundList.get(0).get(29)),
        CLIFF_EDGE_TOP_LEFT_0 (30, backgroundList.get(0).get(30)),
        CLIFF_EDGE_TOP_RIGHT_0 (31, backgroundList.get(0).get(31)),
        */

        ;

        private final int id;
        private final Image im;
        backgroundTiles(int id, Image im){
            this.id = id;
            this.im = im;
        }

        public Image getImage() {
            return this.im;
        }
        public int getId(){
            return this.id;
        }
    }

    public static stills[] getStillsList(){
        return stills.values();
    }
}
