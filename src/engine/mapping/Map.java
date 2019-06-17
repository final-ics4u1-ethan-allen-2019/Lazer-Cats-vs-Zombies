package engine.mapping;

import engine.math.Vector2;
import engine.objects.GameObject;
import engine.scenes.GameScene;
import javafx.scene.image.Image;

public class Map extends GameObject {

    private Tile[][] tileMap;
    protected String mapData;
    protected int tileWidth;
    protected int tileHeight;
    protected int mapWidth;
    protected int mapHeight;
    protected GameScene scene;

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

    @Override
    public void render(){
        for (Tile[] row : tileMap) {
            for (Tile tile : row){
                tile.render();
            }
        }
    }


    public int[] getCollidedTile(Vector2 vector){
        for (int row = 0; row < tileMap.length; row ++){
            for (int col = 0; col < tileMap[row].length; col++){
                if (tileMap[row][col].getRect().isIn(vector.x, vector.y)){
                    return new int[] {row, col};
                }
            }
        }
        return null;
    }


    public int[] getCollidedTile(double x, double y){
        for (int row = 0; row < tileMap.length; row ++){
            for (int col = 0; col < tileMap[row].length; col++){
                if (tileMap[row][col].getRect().isIn(x, y)){
                    return new int[] {row, col};
                }
            }
        }
        return null;
    }

    public void setScene(GameScene scene) {
        this.scene = scene;
    }

    public GameScene getScene() {
        return scene;
    }

    public Tile getTile(int x, int y){
        return tileMap[y][x];
    }
}