package game;

import engine.Draw;
import engine.mapping.Tile;
import game.images.TextureClassifier.BackgroundTiles;

public class GameTile extends Tile {

    private BackgroundTiles tileType;

    public GameTile(BackgroundTiles tileType, int x, int y, int tileWitdth, int tileHeight) {
        super(tileType.getImage(), x, y, tileWitdth, tileHeight);
        this.tileType = tileType;
    }


}
