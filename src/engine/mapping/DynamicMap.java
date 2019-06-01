package engine.mapping;

import engine.GameObject;

import java.util.ArrayList;

public class DynamicMap extends Map {
    //WIP
    private ArrayList<ArrayList<Tile>> tiles;
    private String mapData;

    public DynamicMap(String url){
        super(url);
    }

    public void addTile(Tile tile, int x, int y){
        tiles.get(y).add(x, tile);
    }

    public void addRow(){
        tiles.add(new ArrayList<Tile>());
    }

    @Override
    public void render(){  tiles.forEach( tileList -> { tileList.forEach(tile -> {tile.render();}); }); }
}
