package game;

import engine.mapping.DynamicMap;
import engine.mapping.Map;
import engine.mapping.Tile;
import game.images.TextureClassifier.BackgroundTiles;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MapGenerator {

    public static BackgroundTiles[] uncollidable = {BackgroundTiles.LAVA_TILE_0, BackgroundTiles.LAVA_INVERSE_HOLE_BOTTOM_LEFT,
            BackgroundTiles.LAVA_INVERSE_HOLE_BOTTOM_RIGHT, BackgroundTiles.LAVA_INVERSE_HOLE_TOP_LEFT,
            BackgroundTiles.LAVA_INVERSE_HOLE_TOP_RIGHT, BackgroundTiles.LAVA_POOL_CENTER_RIGHT,
            BackgroundTiles.LAVA_POOL_CENTER_LEFT, BackgroundTiles.LAVA_POOL_TOP_MIDDLE, BackgroundTiles.LAVA_POOL_BOTTOM_MIDDLE,
            BackgroundTiles.LAVA_POOL_TOP_MIDDLE
    };
    public static DynamicMap generateDynamicMap(String url){
        DynamicMap map = new DynamicMap(32, 32, 100, 100);
        try {
            FileReader fileReader = new FileReader(url);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null){
                String[] txt = line.split(" ");
                for (String s : txt){

                    for (BackgroundTiles b : BackgroundTiles.values()){
                        if (b.getId() == Integer.parseInt(s)){
                            if (Arrays.asList(MapGenerator.uncollidable).contains(b)){
                                map.addTile(b.getImage(), false);
                            } else{
                                map.addTile(b.getImage());
                            }
                        }
                    }
                }
                map.addRow();
            }
        } catch (Exception e){
            System.out.println("Load Failed");
            e.printStackTrace();
        }


        return map;
    }

    //WIP
    public static Map generateMap(String  url){
        Map map = new Map(url);
        try {
            FileReader fileReader = new FileReader(url);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            Tile[][] tileMap = new Tile[countLines(url)][line.length()];

        } catch (Exception e){

        }
        return map;
    }

    //MEGA COPY AND PASTE
    public static int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];

            int readChars = is.read(c);
            if (readChars == -1) {
                // bail out if nothing to read
                return 0;
            }

            // make it easy for the optimizer to tune this loop
            int count = 0;
            while (readChars == 1024) {
                for (int i=0; i<1024;) {
                    if (c[i++] == '\n') {
                        ++count;
                    }
                }
                readChars = is.read(c);
            }

            // count remaining characters
            while (readChars != -1) {
                System.out.println(readChars);
                for (int i=0; i<readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
                readChars = is.read(c);
            }

            return count == 0 ? 1 : count;
        } finally {
            is.close();
        }
    }


}
