package engine.mapping;

import engine.Rect;
import engine.math.Vector2;
import engine.scenes.GameScene;
import javafx.scene.image.*;
import java.util.ArrayList;

public class DynamicMap extends Map {



    protected ArrayList<ArrayList<Tile>> tileMap;


    public DynamicMap(){
        super();
        tileMap = new ArrayList<>();
    }

    public DynamicMap( int tileWidth, int tileHeight, int mapWidth, int mapHeight){
        super(tileWidth, tileHeight, mapWidth, mapHeight);
        tileMap = new ArrayList<>();
    }

    @Override
    public int[] getCollidedTile(double x, double y){
        for (int row = 0; row < tileMap.size(); row ++){
            for (int col = 0; col < tileMap.get(row).size(); col++){
                if (tileMap.get(row).get(col).getRect().isIn(x, y)){
                    return new int[] {row, col};
                }
            }
        }
        return null;
    }

    @Override
    public int[] getCollidedTile(Vector2 vector){
        for (int row = 0; row < tileMap.size(); row ++){
            for (int col = 0; col < tileMap.get(row).size(); col++){
                if (tileMap.get(row).get(col).getRect().isIn(vector.x, vector.y)){
                    return new int[] {row, col};
                }
            }
        }
        return null;
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
        tile.setMap(this);
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
        } else if (tileMap.size() < 1){
            addRow();
        }

        if (tileMap.get(tileMap.size() - 1).size() == 0) {
           // System.out.printf("X: %d Y: %d   -   ", 0 , (tileMap.size()-1) * tileHeight);
            Tile tile = new Tile(img, 0, (tileMap.size()-1) * tileHeight, tileWidth, tileHeight);
            tile.setMap(this);
            tileMap.get(tileMap.size() - 1).add(tile);
           // System.out.print(tileMap.size() - 1);

        } else{
           // System.out.print(tileMap.size() - 1);
            ArrayList<Tile> row = tileMap.get(tileMap.size() - 1);
            Rect lastTile = row.get(row.size() - 1).getRect();
           // System.out.printf("X: %d Y: %d   -   ", (int)(lastTile.x ) , (int)(lastTile.y));
            Tile tile = new Tile(img, (int)(lastTile.x + tileWidth), (int)(lastTile.y), tileWidth, tileHeight);
            tile.setMap(this);
            tileMap.get(tileMap.size() - 1).add(tile);
        }
    }

    public void addTile(Image img, boolean traversable ){
        if (tileMap == null){
            tileMap = new ArrayList<>();
            addRow();
        } else if (tileMap.size() < 1){
            addRow();
        }

        if (tileMap.get(tileMap.size() - 1).size() == 0) {
            // System.out.printf("X: %d Y: %d   -   ", 0 , (tileMap.size()-1) * tileHeight);
            Tile tile = new Tile(img, 0, (tileMap.size()-1) * tileHeight, tileWidth, tileHeight);
            tile.setMap(this);
            tile.setTraversable(traversable);
            tileMap.get(tileMap.size() - 1).add(tile);
            // System.out.print(tileMap.size() - 1);

        } else{
            // System.out.print(tileMap.size() - 1);
            ArrayList<Tile> row = tileMap.get(tileMap.size() - 1);
            Rect lastTile = row.get(row.size() - 1).getRect();
            // System.out.printf("X: %d Y: %d   -   ", (int)(lastTile.x ) , (int)(lastTile.y));
            Tile tile = new Tile(img, (int)(lastTile.x + tileWidth), (int)(lastTile.y), tileWidth, tileHeight);
            tile.setMap(this);
            tile.setTraversable(traversable);
            tileMap.get(tileMap.size() - 1).add(tile);
        }
    }


    @Override
    public void fill(Image img){
        tileMap = new ArrayList<>();
        for (int y = 0; y < tileHeight; y++){
            addRow();
            for (int x = 0; x < tileWidth; x++){
                Tile tile = new Tile(img, x* tileWidth, y *tileHeight, tileWidth, tileHeight );
                tile.setMap(this);
                addTile(tile);
            }
        }
    }

    public void addRow(){
        tileMap.add(new ArrayList<Tile>());
    }

    @Override
    public void render(){  tileMap.forEach(tileList -> { tileList.forEach(tile -> {tile.render();}); }); }

    @Override
    public Tile getTile(int x, int y){
        return tileMap.get(y).get(x);
    }
}