package game.worldobjects;

import engine.Cropper;
import engine.objects.GameObject;
import engine.scripts.SpriteRenderer;
import game.Inventory;
import game.images.TextureClassifier;

public class Chest extends GameObject {

    @Override
    public void load() {
        Cropper crop = new Cropper(TextureClassifier.stills.CHESTS.getImage());
        addScript(new SpriteRenderer(crop.crop(0, 0, 32, 32)));
        addScript(new Inventory(27, Inventory.InventoryType.LOOT));
        addScript(new ChestScript());

        super.load();
    }

}
