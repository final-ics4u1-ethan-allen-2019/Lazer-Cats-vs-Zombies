package engine.mapping;

import engine.objects.GameObject;
import javafx.scene.image.Image;

public class Map extends GameObject {

    private Tile[][] tileMap;
    protected String mapData;
    protected int tileWidth;
    protected int tileHeight;
    protected int mapWidth;
    protected int mapHeight;

    public Map(Tile[][] map, String mapData){
        if (map != null) {
            tileMap = map;
            this.mapData = mapData;
            tileWidth = (int)tileMap[0][0].getRect().width;
            tileHeight = (int)tileMap[0][0].getRect().height;
            mapWidth = tileMap[0].length;
            mapHeight = tileMap.length;
        }
    }

    public Map(){
        tileMap = null;
        mapData = null;
        tileWidth = 32;
        tileHeight = 32;
        mapHeight = 32;
        mapWidth = 32;
    }

    public Map(int mapWidth, int mapHeight){
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.tileWidth = 32;
        this.tileHeight = 32;
    }

    public Map(int tileWidth, int tileHeight, int mapWidth, int mapHeight){
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
    }

    public Map(String mapData){
        this.mapData = mapData;
    }

    public void fill(Image img){
        tileMap = new Tile[tileHeight][tileWidth];
        for (int y = 0; y < tileMap.length; y++){
            for (int x = 0; x < tileMap[y].length; x++){
                tileMap[y][x] = new Tile(img, tileWidth * x, tileHeight * y, tileWidth, tileHeight);
            }
        }
    }

    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }

    @Override
    public void render(){
        for (Tile[] row : tileMap) {
            for (Tile tile : row){
                tile.render();
            }
        }
    }
}
