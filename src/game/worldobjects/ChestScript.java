package game.worldobjects;

import engine.Cropper;
import engine.scripts.Script;
import engine.scripts.SpriteRenderer;
import game.Inventory;
import game.images.TextureClassifier;
import game.player.Player;
import javafx.scene.image.Image;

public class ChestScript extends Script {

    private static Image unopened, opened;
    private SpriteRenderer renderer;
    private Inventory inventory;

    @Override
    public void load() {
        for (Script script : parent.getScripts()) {
            if (script instanceof SpriteRenderer) {
                renderer = (SpriteRenderer) script;
            } else if (script instanceof Inventory) {
                inventory = (Inventory) script;
            }
        }

        Cropper cropper = new Cropper(TextureClassifier.stills.CHESTS.getImage());
        if (unopened == null) {
            unopened = cropper.crop(0,0,32,32);
            opened = cropper.crop(0,32,32,32);
        }
    }

    public void open(Player player) {
        renderer.setImage(opened);
        inventory.open(player);
        inventory.generateRandomLoot();
    }

    public void close() {
        renderer.setImage(unopened);
        inventory.close();
    }

}
