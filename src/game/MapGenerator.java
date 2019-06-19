package game;

import engine.mapping.DynamicMap;
import engine.mapping.Map;
import engine.mapping.Tile;
import game.images.TextureClassifier.BackgroundTiles;

import java.io.*;
import java.util.Arrays;

/** Generates Maps
 *
 */
public class MapGenerator {

    /** collidable tiles array
     *
     */
    public static BackgroundTiles[] collidable = {BackgroundTiles.LAVA_TILE_0, BackgroundTiles.LAVA_INVERSE_HOLE_BOTTOM_LEFT,
            BackgroundTiles.LAVA_INVERSE_HOLE_BOTTOM_RIGHT, BackgroundTiles.LAVA_INVERSE_HOLE_TOP_LEFT,
            BackgroundTiles.LAVA_INVERSE_HOLE_TOP_RIGHT, BackgroundTiles.LAVA_POOL_CENTER_RIGHT,
            BackgroundTiles.LAVA_POOL_CENTER_LEFT, BackgroundTiles.LAVA_POOL_TOP_MIDDLE, BackgroundTiles.LAVA_POOL_BOTTOM_MIDDLE,
            BackgroundTiles.LAVA_POOL_TOP_MIDDLE, BackgroundTiles.LAVA_POOL_TOP_LEFT, BackgroundTiles.LAVA_POOL_TOP_RIGHT,
            BackgroundTiles.LAVA_POOL_BOTTOM_LEFT, BackgroundTiles.LAVA_POOL_BOTTOM_RIGHT
    };

    /** Generates Dynamic Map
     *
     * @param url
     * @param tileWidth
     * @param tileHeight
     * @return
     */
    public static DynamicMap generateDynamicMap(String url, int tileWidth, int tileHeight){
        DynamicMap map = null;


        try {

            //Gets map dimensions and init objects
            FileReader fileReader = new FileReader(url);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            int[] mapDimensions = getMapDimensions(fileReader);

            //resets file reader
            fileReader = new FileReader(url);
            reader = new BufferedReader(fileReader);

            //initializes map
            map = new DynamicMap(tileWidth, tileHeight, mapDimensions[0], mapDimensions[1]);

            //until file is fully read
            while ((line = reader.readLine()) != null){

                //removes blank lines
                if (line.equals("/n"))
                    continue;

                //splits id
                String[] txt = line.split(" ");

                //for each id
                for (String s : txt){

                    //for each enum val
                    for (BackgroundTiles b : BackgroundTiles.values()){

                        //checks for the id
                        if (b.getId() == Integer.parseInt(s)){

                            //check if in collidable
                            if (Arrays.asList(MapGenerator.collidable).contains(b)){
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


    //gets map dimensions
    private static int[] getMapDimensions(FileReader reader){
        int length = 0;
        int width = 0;
        try {
            //reader inits
            BufferedReader bReader = new BufferedReader(reader);

            //gets width
            width = (bReader.readLine()).split(" ").length;

            //adds one because of readline
            length++;
            while (bReader.readLine() != null)
                length++;

        } catch (Exception e){

        }

        return new int[] {width, length};
    }


}
