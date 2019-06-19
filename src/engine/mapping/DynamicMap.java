package engine.mapping;

import engine.Rect;
import engine.math.Vector2;
import engine.scenes.GameScene;
import javafx.scene.image.*;
import java.util.ArrayList;

/** Dyanamic Map
 *
 */
public class DynamicMap extends Map {



    protected ArrayList<ArrayList<Tile>> tileMap;


    /**
     *
     * @param tileWidth
     * @param tileHeight
     * @param mapWidth
     * @param mapHeight
     */
    public DynamicMap( int tileWidth, int tileHeight, int mapWidth, int mapHeight){
        super(tileWidth, tileHeight, mapWidth, mapHeight);
        tileMap = new ArrayList<>();
    }


    /** Gets collided tile
     *
     * @param x desired x
     * @param y desired y
     * @return null if none detected, int array if in a tile
     */
    @Override
    public int[] getCollidedTile(double x, double y){

        for (int row = 0; row < tileMap.size(); row ++){
            for (int col = 0; col < tileMap.get(row).size(); col++){

                //checks if it's in the rect
                if (tileMap.get(row).get(col).getRect().isIn(x, y)){
                    return new int[] {col, row};
                }
            }
        }
        return null;
    }

    /** Gets collided tile but with vector
     *
     * @param vector vector of the point
     * @return null if none detected, int array if in a tile
     */
    @Override
    public int[] getCollidedTile(Vector2 vector){
        for (int row = 0; row < tileMap.size(); row ++){
            for (int col = 0; col < tileMap.get(row).size(); col++){

                //checks if in rect
                if (tileMap.get(row).get(col).getRect().isIn(vector.x, vector.y)){
                    return new int[] {col, row};
                }
            }
        }
        return null;
    }

    /** Adds tile
     *
     * @param tile tile desired
     */
    public void addTile(Tile tile){
        checkEmpty();
        tile.setMap(this);
        tileMap.get(tileMap.size() - 1).add(tile);
    }


    /** Adds tile with image
     *
     * @param img image desired
     */
    public void addTile(Image img){
        checkEmpty();

        //if row is empty
        if (tileMap.get(tileMap.size() - 1).size() == 0) {
            Tile tile = new Tile(img, 0, (tileMap.size()-1) * tileHeight, tileWidth, tileHeight);
            tile.setMap(this);
            tileMap.get(tileMap.size() - 1).add(tile);
        }

        //if not empty
        else{

            //gets last tile data
            ArrayList<Tile> row = tileMap.get(tileMap.size() - 1);
            Rect lastTile = row.get(row.size() - 1).getRect();

            //generates new tile
            Tile tile = new Tile(img, (int)(lastTile.x + tileWidth), (int)(lastTile.y), tileWidth, tileHeight);
            tile.setMap(this);
            tileMap.get(tileMap.size() - 1).add(tile);
        }
    }


    /** Adds tile with image and sets traversable
     *
     * @param img
     * @param traversable
     */
    public void addTile(Image img, boolean traversable ){
        checkEmpty();

        //see other add tile
        if (tileMap.get(tileMap.size() - 1).size() == 0) {
            Tile tile = new Tile(img, 0, (tileMap.size()-1) * tileHeight, tileWidth, tileHeight);
            tile.setMap(this);
            tile.setTraversable(traversable);
            tileMap.get(tileMap.size() - 1).add(tile);

        } else{
            ArrayList<Tile> row = tileMap.get(tileMap.size() - 1);
            Rect lastTile = row.get(row.size() - 1).getRect();
            Tile tile = new Tile(img, (int)(lastTile.x + tileWidth), (int)(lastTile.y), tileWidth, tileHeight);
            tile.setMap(this);
            tile.setTraversable(traversable);
            tileMap.get(tileMap.size() - 1).add(tile);
        }
    }

    /** Fills the tile map
     *
     * @param img image
     */
    @Override
    public void fill(Image img){
        tileMap = new ArrayList<>();

        //for each row
        for (int y = 0; y < tileHeight; y++){
            addRow();

            //for each column
            for (int x = 0; x < tileWidth; x++){

                //adds new tile
                Tile tile = new Tile(img, x* tileWidth, y *tileHeight, tileWidth, tileHeight );
                tile.setMap(this);
                addTile(tile);
            }
        }
    }

    /** Adds row
     *
     */
    public void addRow(){
        tileMap.add(new ArrayList<Tile>());
    }

    /** Renders all tiles
     *
     */
    @Override
    public void render(){  tileMap.forEach(tileList -> { tileList.forEach(tile -> {tile.render();}); }); }

    /** Gets tile according index
     *
     * @param x tile column
     * @param y tile row
     * @return desired tile
     */
    @Override
    public Tile getTile(int x, int y){
        return tileMap.get(y).get(x);
    }

    //checks if tile map is empty or uninitialized
    private void checkEmpty(){

        //if not initialized
        if (tileMap == null){
            tileMap = new ArrayList<>();
            addRow();
        }

        //if empty
        else if (tileMap.size() < 1){
            addRow();
        }
    }


}