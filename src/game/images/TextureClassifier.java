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
        SKIRT(0, "game/images/spritesheets/legs/skirt/male/brown.png"),
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

        //Row 1
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
        LAVA_INVERSE_HOLE_TOP_LEFT(16, backgroundList.get(0).get(16)),
        LAVA_INVERSE_HOLE_TOP_RIGHT(17, backgroundList.get(0).get(17)),
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

        //Row 2
        LIGHT_STONE_1 (32, backgroundList.get(1).get(0)),
        LIGHT_STONE_DENT_BOTTOM_LEFT(33, backgroundList.get(1).get(1)),
        LIGHT_STONE_DENT_BOTTOM_RIGHT(34, backgroundList.get(1).get(2)),
        BROWN_STONE_1 (35, backgroundList.get(1).get(3)),
        BROWN_STONE_DENT_BOTTOM_LEFT(36, backgroundList.get(1).get(4)),
        BROWN_STONE_DENT_BOTTOM_RIGHT(37, backgroundList.get(1).get(5)),
        DARKBROWN_STONE_1 (38, backgroundList.get(1).get(6)),
        DARKBROWN_STONE_DENT_BOTTOM_LEFT(39, backgroundList.get(1).get(7)),
        DARKBROWN_STONE_DENT_BOTTOM_RIGHT(40, backgroundList.get(1).get(8)),
        BLACKSTONE_1 (41, backgroundList.get(1).get(9)),
        BLACK_STONE_DENT_BOTTOM_LEFT(42, backgroundList.get(1).get(10)),
        BLACK_STONE_DENT_BOTTOM_RIGHT(43, backgroundList.get(1).get(11)),
        GREYSTONE_1 (44, backgroundList.get(1).get(12)),
        GREY_STONE_DENT_BOTTOM_LEFT(45, backgroundList.get(1).get(13)),
        GREY_STONE_DENT_BOTTOM_RIGHT(46, backgroundList.get(1).get(14)),
        S_LAVAPOOL (47, backgroundList.get(1).get(15)),
        LAVA_INVERSE_HOLE_BOTTOM_LEFT(48, backgroundList.get(1).get(16)),
        LAVA_INVERSE_HOLE_BOTTOM_RIGHT(49, backgroundList.get(1).get(17)),
        S_LIGHT_HOLE (50, backgroundList.get(1).get(18)),
        LIGHT_INVERSE_HOLE_BOTTOMSLEFT(51, backgroundList.get(1).get(19)),
        LIGHT_INVERSE_HOLE_BOTTOM_RIGHT(52, backgroundList.get(1).get(20)),
        S_DARK_HOLE (53, backgroundList.get(1).get(21)),
        DARK1INVERSE_HOLE_BOTTOM_LEFT(54, backgroundList.get(1).get(22)),
        DARK_INVERSE_HOLE_BOTTOM_RIGHT(55, backgroundList.get(1).get(23)),
        S_BLACK_HOLE (56, backgroundList.get(1).get(24)),
        BLACK_INVERSE_HOLE_BOTTOM_LEFT(57, backgroundList.get(1).get(25)),
        BLACK_INVERSE_HOLE_BOTTOM_RIGHT(58, backgroundList.get(1).get(26)),
        S_WATER_HOLE (59, backgroundList.get(1).get(27)),
        WATER_INVERSE_HOLE_BOTTOM_LEFT(60, backgroundList.get(1).get(28)),
        WATER_INVERSE_HOLE_BOTTOM_RIGHT(61, backgroundList.get(1).get(29)),
        CLIFF_EDGE_BOTTOM_LEFT_0 (62, backgroundList.get(1).get(30)),
        CLIFF_EDGE_BOTTOM_RIGHT_0 (63, backgroundList.get(1).get(31)),


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
