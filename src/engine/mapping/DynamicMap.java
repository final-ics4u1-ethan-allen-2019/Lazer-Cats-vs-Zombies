package engine.mapping;

import engine.Rect;
import javafx.scene.image.*;
import java.util.ArrayList;

public class DynamicMap extends Map {
    //WIP
    protected ArrayList<ArrayList<Tile>> tileMap;


    public DynamicMap(){
        super();
        tileMap = new ArrayList<>();
    }

    public DynamicMap( int tileWidth, int tileHeight, int mapWidth, int mapHeight){
        super(tileWidth, tileHeight, mapWidth, mapHeight);
        tileMap = new ArrayList<>();
    }

    public void addTile(Tile tile, int x, int y){
        tileMap.get(y).add(x, tile);
    }

    public void addTile(Tile tile){
        if (tileMap == null){
            tileMap = new ArrayList<>();
            addRow();
        } else if (tileMap.size() <= 1){
            addRow();
        }
        if (tileMap.get(tileMap.size() - 1).size() == 0) {
            tileMap.get(tileMap.size() - 1).add(tile);
        } else{
            ArrayList<Tile> row = tileMap.get(tileMap.size() - 1);
            Rect lastTile = row.get(row.size() - 1).getRect();
            tileMap.get(tileMap.size() - 1).add(tile);
        }
    }

    public void addTile(Image img){
        if (tileMap == null){
            tileMap = new ArrayList<>();
            addRow();
        } else if (tileMap.size() <= 1){
            addRow();
        }
        if (tileMap.get(tileMap.size() - 1).size() == 0) {
            tileMap.get(tileMap.size() - 1).add(new Tile(img, 0, tileMap.size() * tileHeight, tileWidth, tileHeight));
        } else{
            ArrayList<Tile> row = tileMap.get(tileMap.size() - 1);
            Rect lastTile = row.get(row.size() - 1).getRect();
            tileMap.get(tileMap.size() - 1).add(new Tile(img, (int)(lastTile.x + tileWidth), (int)(lastTile.y), tileWidth, tileHeight));
        }
    }


    @Override
    public void fill(Image img){
        tileMap = new ArrayList<>();
        for (int y = 0; y < tileHeight; y++){
            addRow();
            for (int x = 0; x < tileWidth; x++){
                addTile(new Tile(img, x* tileWidth, y *tileHeight, tileWidth, tileHeight ));
            }
        }
    }

    public void addRow(){
        tileMap.add(new ArrayList<Tile>());
    }

    @Override
    public void render(){  tileMap.forEach(tileList -> { tileList.forEach(tile -> {tile.render();}); }); }
}