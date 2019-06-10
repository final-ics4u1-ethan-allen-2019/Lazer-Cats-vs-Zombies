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

    public enum BackgroundTiles {

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
        DARK_INVERSE_HOLE_BOTTOM_LEFT(54, backgroundList.get(1).get(22)),
        DARK_INVERSE_HOLE_BOTTOM_RIGHT(55, backgroundList.get(1).get(23)),
        S_BLACK_HOLE (56, backgroundList.get(1).get(24)),
        BLACK_INVERSE_HOLE_BOTTOM_LEFT(57, backgroundList.get(1).get(25)),
        BLACK_INVERSE_HOLE_BOTTOM_RIGHT(58, backgroundList.get(1).get(26)),
        S_WATER_HOLE (59, backgroundList.get(1).get(27)),
        WATER_INVERSE_HOLE_BOTTOM_LEFT(60, backgroundList.get(1).get(28)),
        WATER_INVERSE_HOLE_BOTTOM_RIGHT(61, backgroundList.get(1).get(29)),
        CLIFF_EDGE_BOTTOM_LEFT_0 (62, backgroundList.get(1).get(30)),
        CLIFF_EDGE_BOTTOM_RIGHT_0 (63, backgroundList.get(1).get(31)),

        //Row 3
        LIGHT_STONE_TOP_LEFT (64, backgroundList.get(2).get(0)),
        LIGHT_STONE_TOP_MIDDLE (65, backgroundList.get(2).get(1)),
        LIGHT_STONE_TOP_RIGHT (66, backgroundList.get(2).get(2)),
        BROWN_STONE_TOP_LEFT (67, backgroundList.get(2).get(3)),
        BROWN_STONE_TOP_MIDDLE (68, backgroundList.get(2).get(4)),
        BROWN_STONE_TOP_RIGHT (69, backgroundList.get(2).get(5)),
        DARK_BROWN_STONE_TOP_LEFT (70, backgroundList.get(2).get(6)),
        DARK_BROWN_STONE_TOP_MIDDLE (71, backgroundList.get(2).get(7)),
        DARK_BROWN_STONE_TOP_RIGHT (72, backgroundList.get(2).get(8)),
        BLACK_STONE_TOP_LEFT (73, backgroundList.get(2).get(9)),
        BLACK_STONE_TOP_MIDDLE (74, backgroundList.get(2).get(10)),
        BLACK_STONE_TOP_RIGHT (75, backgroundList.get(2).get(11)),
        GREY_STONE_TOP_LEFT (76, backgroundList.get(2).get(12)),
        GREY_STONE_TOP_MIDDLE (77, backgroundList.get(2).get(13)),
        GREY_STONE_TOP_RIGHT (78, backgroundList.get(2).get(14)),
        LAVA_POOL_TOP_LEFT (79, backgroundList.get(2).get(15)),
        LAVA_POOL_TOP_MIDDLE (80, backgroundList.get(2).get(16)),
        LAVA_POOL_TOP_RIGHT (81, backgroundList.get(2).get(17)),
        LIGHT_PIT_TOP_LEFT (82, backgroundList.get(2).get(18)),
        LIGHT_PIT_TOP_MIDDLE (83, backgroundList.get(2).get(19)),
        LIGHT_PIT_TOP_RIGHT (84, backgroundList.get(2).get(20)),
        DARK_BROWN_PIT_TOP_LEFT (85, backgroundList.get(2).get(21)),
        DARK_BROWN_PIT_TOP_MIDDLE (86, backgroundList.get(2).get(22)),
        DARK_BROWN_PIT_TOP_RIGHT (87, backgroundList.get(2).get(23)),
        BLACK_HOLE_TOP_LEFT (88, backgroundList.get(2).get(24)),
        BLACK_HOLE_TOP_MIDDLE (89, backgroundList.get(2).get(25)),
        BLACK_HOLE_TOP_RIGHT (90, backgroundList.get(2).get(26)),
        WATER_POOL_TOP_LEFT (91, backgroundList.get(2).get(27)),
        WATER_POOL_PIT_TOP_MIDDLE (92, backgroundList.get(2).get(28)),
        WATER_POOL_PIT_TOP_RIGHT (93, backgroundList.get(2).get(29)),
        CLIFF_EDGE_LEFT_0 (94, backgroundList.get(2).get(30)),
        CLIFF_EDGE_RIGHT_0 (95, backgroundList.get(2).get(31)),

        //Row 4
        LIGHT_STONE_CENTER_LEFT (64, backgroundList.get(3).get(0)),
        LIGHT_STONE_CENTER_MIDDLE (65, backgroundList.get(3).get(1)),
        LIGHT_STONE_CENTER_RIGHT (66, backgroundList.get(3).get(2)),
        BROWN_STONE_CENTER_LEFT (67, backgroundList.get(3).get(3)),
        BROWN_STONE_CENTER_MIDDLE (68, backgroundList.get(3).get(4)),
        BROWN_STONE_CENTER_RIGHT (69, backgroundList.get(3).get(5)),
        DARK_BROWN_STONE_CENTER_LEFT (70, backgroundList.get(3).get(6)),
        DARK_BROWN_STONE_CENTER_MIDDLE (71, backgroundList.get(3).get(7)),
        DARK_BROWN_STONE_CENTER_RIGHT (72, backgroundList.get(3).get(8)),
        BLACK_STONE_CENTER_LEFT (73, backgroundList.get(3).get(9)),
        BLACK_STONE_CENTER_MIDDLE (74, backgroundList.get(3).get(10)),
        BLACK_STONE_CENTER_RIGHT (75, backgroundList.get(3).get(11)),
        GREY_STONE_CENTER_LEFT (76, backgroundList.get(3).get(12)),
        GREY_STONE_CENTER_MIDDLE (77, backgroundList.get(3).get(13)),
        GREY_STONE_CENTER_RIGHT (78, backgroundList.get(3).get(14)),
        LAVA_POOL_CENTER_LEFT (79, backgroundList.get(3).get(15)),
        LAVA_POOL_CENTER_MIDDLE (80, backgroundList.get(3).get(16)),
        LAVA_POOL_CENTER_RIGHT (81, backgroundList.get(3).get(17)),
        LIGHT_PIT_CENTER_LEFT (82, backgroundList.get(3).get(18)),
        LIGHT_PIT_CENTER_MIDDLE (83, backgroundList.get(3).get(19)),
        LIGHT_PIT_CENTER_RIGHT (84, backgroundList.get(3).get(20)),
        DARK_BROWN_PIT_CENTER_LEFT (85, backgroundList.get(3).get(21)),
        DARK_BROWN_PIT_CENTER_MIDDLE (86, backgroundList.get(3).get(22)),
        DARK_BROWN_PIT_CENTER_RIGHT (87, backgroundList.get(3).get(23)),
        BLACK_HOLE_CENTER_LEFT (88, backgroundList.get(3).get(24)),
        BLACK_HOLE_CENTER_MIDDLE (89, backgroundList.get(3).get(25)),
        BLACK_HOLE_CENTER_RIGHT (90, backgroundList.get(3).get(26)),
        WATER_POOL_CENTER_LEFT (91, backgroundList.get(3).get(27)),
        WATER_POOL_PIT_CENTER_MIDDLE (92, backgroundList.get(3).get(28)),
        WATER_POOL_PIT_CENTER_RIGHT (93, backgroundList.get(3).get(29)),
        CLIFF_EDGE_LEFT_1 (94, backgroundList.get(3).get(30)),
        CLIFF_EDGE_RIGHT_1 (95, backgroundList.get(3).get(31)),

        //Row 5
        LIGHT_STONE_BOTTOM_LEFT (96, backgroundList.get(4).get(0)),
        LIGHT_STONE_BOTTOM_MIDDLE (97, backgroundList.get(4).get(1)),
        LIGHT_STONE_BOTTOM_RIGHT (98, backgroundList.get(4).get(2)),
        BROWN_STONE_BOTTOM_LEFT (99, backgroundList.get(4).get(3)),
        BROWN_STONE_BOTTOM_MIDDLE (100, backgroundList.get(4).get(4)),
        BROWN_STONE_BOTTOM_RIGHT (101, backgroundList.get(4).get(5)),
        DARK_BROWN_STONE_BOTTOM_LEFT (102, backgroundList.get(4).get(6)),
        DARK_BROWN_STONE_BOTTOM_MIDDLE (103, backgroundList.get(4).get(7)),
        DARK_BROWN_STONE_BOTTOM_RIGHT (104, backgroundList.get(4).get(8)),
        BLACK_STONE_BOTTOM_LEFT (105, backgroundList.get(4).get(9)),
        BLACK_STONE_BOTTOM_MIDDLE (106, backgroundList.get(4).get(10)),
        BLACK_STONE_BOTTOM_RIGHT (107, backgroundList.get(4).get(11)),
        GREY_STONE_BOTTOM_LEFT (108, backgroundList.get(4).get(12)),
        GREY_STONE_BOTTOM_MIDDLE (109, backgroundList.get(4).get(13)),
        GREY_STONE_BOTTOM_RIGHT (110, backgroundList.get(4).get(14)),
        LAVA_POOL_BOTTOM_LEFT (111, backgroundList.get(4).get(15)),
        LAVA_POOL_BOTTOM_MIDDLE (112, backgroundList.get(4).get(16)),
        LAVA_POOL_BOTTOM_RIGHT (113, backgroundList.get(4).get(17)),
        LIGHT_PIT_BOTTOM_LEFT (114, backgroundList.get(4).get(18)),
        LIGHT_PIT_BOTTOM_MIDDLE (115, backgroundList.get(4).get(19)),
        LIGHT_PIT_BOTTOM_RIGHT (116, backgroundList.get(4).get(20)),
        DARK_BROWN_PIT_BOTTOM_LEFT (117, backgroundList.get(4).get(21)),
        DARK_BROWN_PIT_BOTTOM_MIDDLE (118, backgroundList.get(4).get(22)),
        DARK_BROWN_PIT_BOTTOM_RIGHT (119, backgroundList.get(4).get(23)),
        BLACK_HOLE_BOTTOM_LEFT (120, backgroundList.get(4).get(24)),
        BLACK_HOLE_BOTTOM_MIDDLE (121, backgroundList.get(4).get(25)),
        BLACK_HOLE_BOTTOM_RIGHT (122, backgroundList.get(4).get(26)),
        WATER_POOL_BOTTOM_LEFT (123, backgroundList.get(4).get(27)),
        WATER_POOL_PIT_BOTTOM_MIDDLE (124, backgroundList.get(4).get(28)),
        WATER_POOL_PIT_BOTTOM_RIGHT (125, backgroundList.get(4).get(29)),
        CLIFF_EDGE_LEFT_2 (126, backgroundList.get(4).get(30)),
        CLIFF_EDGE_RIGHT_3 (127, backgroundList.get(4).get(31)),

        //Row 6
        LIGHT_STONE_TILE_0 (128, backgroundList.get(5).get(0)),
        LIGHT_STONE_TILE_1 (129, backgroundList.get(5).get(1)),
        LIGHT_STONE_TILE_2 (130, backgroundList.get(5).get(2)),
        BROWN_STONE_TILE_0 (131, backgroundList.get(5).get(3)),
        BROWN_STONE_TILE_1 (132, backgroundList.get(5).get(4)),
        BROWN_STONE_TILE_2 (133, backgroundList.get(5).get(5)),
        DARK_BROWN_STONE_TILE_0 (134, backgroundList.get(5).get(6)),
        DARK_BROWN_STONE_TILE_1 (135, backgroundList.get(5).get(7)),
        DARK_BROWN_STONE_TILE_2 (136, backgroundList.get(5).get(8)),
        BLACK_STONE_TILE_0 (137, backgroundList.get(5).get(9)),
        BLACK_STONE_TILE_1 (138, backgroundList.get(5).get(10)),
        BLACK_STONE_TILE_2 (139, backgroundList.get(5).get(11)),
        GREY_STONE_TILE_0 (140, backgroundList.get(5).get(12)),
        GREY_STONE_TILE_1 (141, backgroundList.get(5).get(13)),
        GREY_STONE_TILE_2 (142, backgroundList.get(5).get(14)),
        LAVA_TILE_0 (143, backgroundList.get(5).get(15)),
        LAVA_TILE_1 (144, backgroundList.get(5).get(16)),
        LAVA_TILE_2 (145, backgroundList.get(5).get(17)),
        PIT_TILE_0 (146, backgroundList.get(5).get(18)),
        PIT_TILE_1 (147, backgroundList.get(5).get(19)),
        PIT_TILE_2 (148, backgroundList.get(5).get(20)),
        LIGHT_STALAGMITE (149, backgroundList.get(5).get(21)),
        BROWN_STALAGMITE (150, backgroundList.get(5).get(22)),
        BLACK_STALAGMITE (151, backgroundList.get(5).get(23)),
        BLACK_TILE (152, backgroundList.get(5).get(24)),
        WATER_TILE_0 (153, backgroundList.get(5).get(27)),
        WATER_TILE_1 (154, backgroundList.get(5).get(28)),
        WATER_TILE_2 (155, backgroundList.get(5).get(29)),
        REVERSE_CLIFF_LEFT_CORNER (156, backgroundList.get(5).get(30)),
        REVERSE_CLIFF_RIGHT_CORNER (157, backgroundList.get(5).get(31)),

        //STILL MORE
        ;

        private final int id;
        private final Image im;
        BackgroundTiles(int id, Image im){
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
