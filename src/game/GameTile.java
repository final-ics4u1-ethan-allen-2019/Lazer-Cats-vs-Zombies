package game;

import engine.mapping.Tile;
import game.images.TextureClassifier.BackgroundTiles;

public class GameTile extends Tile {

    private BackgroundTiles tileType;

    public GameTile(BackgroundTiles tileType) {
        super(tileType.getImage());
        this.tileType = tileType;
    }

    @Override
    public void render(){

    }

}
