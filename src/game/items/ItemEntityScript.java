package game.items;

import engine.Draw;
import engine.scripts.Script;
import game.player.Player;

public class ItemEntityScript extends Script {

    private Item type;

    public ItemEntityScript(Item type) {
        this.type = type;
    }

    @Override
    public void render() {
        Draw.drawImage(type.getImage(Player.Gender.MALE), parent.x, parent.y);
    }
}
