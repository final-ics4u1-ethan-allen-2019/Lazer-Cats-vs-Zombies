package engine.mapping;

/*
    Project title: Lazer Cats vs Zombies
    -----------------------------------------------
    ClassName: Map
    -----------------------------------------------
    What it does: Map superclass
    -----------------------------------------------
    For: ICS4U1 - Holik
    -----------------------------------------------
    By: Ethan and Allen
    -----------------------------------------------
    Last Edited: June 18th 2019
 */

import engine.math.Vector2;
import engine.objects.GameObject;
import engine.scenes.GameScene;
import javafx.scene.image.Image;

/** Constant map
 *
 */
public class Map extends GameObject {

    private Tile[][] tileMap;
    protected String mapData;
    protected int tileWidth;
    protected int tileHeight;
    protected int mapWidth;
    protected int mapHeight;
    protected GameScene scene;

    /** Constructor with tile map
     *
     * @param map 2d Tile arrray
     * @param mapData url
     */
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

    /** Empty map constructor
     *
     */
    public Map(){
        tileMap = null;
        mapData = null;
        tileWidth = 32;
        tileHeight = 32;
        mapHeight = 32;
        mapWidth = 32;
    }

    /** Map constructor
     *
     * @param mapWidth desired map width in tiles
     * @param mapHeight desired map length in tiles
     */
    public Map(int mapWidth, int mapHeight){
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.tileWidth = 32;
        this.tileHeight = 32;
    }

    /** Map constructor with editable tile dimensions
     *
     * @param tileWidth desired tile width
     * @param tileHeight desired tile height
     * @param mapWidth desired map width in tiles
     * @param mapHeight desired map length in tiles
     */
    public Map(int tileWidth, int tileHeight, int mapWidth, int mapHeight){
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
    }

    /** Constructor with map data
     *
     * @param mapData url
     */
    public Map(String mapData){
        this.mapData = mapData;
    }

    /** Fills map
     *
     * @param img
     */
    public void fill(Image img){
        tileMap = new Tile[tileHeight][tileWidth];

        //each row
        for (int y = 0; y < tileMap.length; y++){

            //each col
            for (int x = 0; x < tileMap[y].length; x++){
                tileMap[y][x] = new Tile(img, tileWidth * x, tileHeight * y, tileWidth, tileHeight);
            }
        }
    }

    /** Renders all tiles
     *
     */
    @Override
    public void render(){
        for (Tile[] row : tileMap) {
            for (Tile tile : row){
                tile.render();
            }
        }
    }


    /** Gets collided tile
     *
     * @param vector point vector
     * @return desired tile indices; null if invalid
     */
    public int[] getCollidedTile(Vector2 vector){
        for (int row = 0; row < tileMap.length; row ++){
            for (int col = 0; col < tileMap[row].length; col++){

                //checks if in
                if (tileMap[row][col].getRect().isIn(vector.x, vector.y)){
                    return new int[] {row, col};
                }
            }
        }
        return null;
    }


    /** Gets collided tile
     *
     * @param x point x
     * @param y point y
     * @return desired tile indices; null if invalid
     */
    public int[] getCollidedTile(double x, double y){
        for (int row = 0; row < tileMap.length; row ++){
            for (int col = 0; col < tileMap[row].length; col++){

                //checks collision
                if (tileMap[row][col].getRect().isIn(x, y)){
                    return new int[] {row, col};
                }
            }
        }
        return null;
    }

    /** Setter for scene
     *
     * @param scene given scene
     */
    public void setScene(GameScene scene) {
        this.scene = scene;
    }

    /** Gets scene
     *
     * @return scene
     */
    public GameScene getScene() {
        return scene;
    }

    /** Gets desired tile
     *
     * @param x tile map col
     * @param y tile map row
     * @return tile
     */
    public Tile getTile(int x, int y){
        return tileMap[y][x];
    }
}