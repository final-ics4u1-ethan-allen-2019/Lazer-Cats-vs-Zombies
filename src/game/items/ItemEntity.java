package game.items;

import engine.math.Vector2;
import engine.objects.GameObject;

public class ItemEntity extends GameObject {

    private Item type;

    public ItemEntity(Vector2 location, Item type) {
        x = location.x;
        y = location.y;

        this.type = type;
    }

    @Override
    public void load() {
        addScript(new ItemEntityScript(type));
        type = null;

        super.load();
    }
}
