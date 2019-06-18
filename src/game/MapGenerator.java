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
            BackgroundTiles.LAVA_POOL_TOP_MIDDLE, BackgroundTiles.LAVA_POOL_TOP_LEFT, BackgroundTiles.LAVA_POOL_TOP_RIGHT,
            BackgroundTiles.LAVA_POOL_BOTTOM_LEFT, BackgroundTiles.LAVA_POOL_BOTTOM_RIGHT
    };
    public static DynamicMap generateDynamicMap(String url, int tileWidth, int tileHeight){
        DynamicMap map = null;
        try {
            FileReader fileReader = new FileReader(url);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            int[] mapDimensions = getMapDimensions(fileReader);
            fileReader = new FileReader(url);
            reader = new BufferedReader(fileReader);
            map = new DynamicMap(tileWidth, tileHeight, mapDimensions[0], mapDimensions[1]);
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
            int[] mapDimensions = getMapDimensions(fileReader);
            Tile[][] tileMap = new Tile[mapDimensions[0]][mapDimensions[1]];

        } catch (Exception e){

        }
        return map;
    }


    public static int[] getMapDimensions(FileReader reader){
        int length = 0;
        int width = 0;
        try {
            BufferedReader bReader = new BufferedReader(reader);
            width = (bReader.readLine()).split(" ").length;
            length++;
            while (bReader.readLine() != null) {
                length++;
            }
        } catch (Exception e){

        }

        return new int[] {width, length};
    }


}
