package engine.mapping;

import engine.GameObject;

public class Map extends GameObject {

    private Tile[][] tileMap;
    private String mapData;

    public Map(Tile[][] map, String mapData){
        tileMap = map;
        this.mapData = mapData;
    }

    public Map(String mapData){
        this.mapData = mapData;
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
