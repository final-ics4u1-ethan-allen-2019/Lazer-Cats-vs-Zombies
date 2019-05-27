package game;

import engine.Draw;
import engine.Game;
import engine.scripts.Script;

public class Borders extends Script {

    @Override
    public void render() {
        Draw.rect(0, -1, Game.getWidth(), 1);
        Draw.rect(Game.getWidth()-1, 0, 1, Game.getHeight());
        Draw.rect(0, 0, 1, Game.getHeight());
        Draw.rect(0, Game.getHeight(), Game.getWidth(), 1);
    }
}
