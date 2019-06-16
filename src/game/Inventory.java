package game;

import engine.Draw;
import engine.input.MouseInput;
import engine.scripts.Script;
import game.items.*;
import game.player.Player;
import javafx.scene.paint.Color;

import java.util.Random;

public class Inventory extends Script {

    private static Random random = new Random();

    private Item[][] items;

    private int maxSize;

    private InventoryType type;

    private Player player;

    public Inventory(int maxSize, InventoryType type) {
        this.maxSize = maxSize;
        this.type = type;

        items = new Item[maxSize/9][9];

        if (type == InventoryType.LOOT) generateRandomLoot();
    }

    public void open(Player player) {
        this.player = player;
    }

    public void close() {
        this.player = null;
    }

    public void generateRandomLoot() {
        int ran = random.nextInt(2) + 1;
        for (int i = 0; i < ran; i++) {
            int r = random.nextInt(5);
            int x = random.nextInt(maxSize/9);
            int y = random.nextInt(9);
            while (true) {
                if (items[x][y] != null) {
                    x = random.nextInt(maxSize / 9);
                    y = random.nextInt(9);
                } else break;
            }
            if (r == 0) {
                int ra = random.nextInt(ChestPlate.values().length);
                items[x][y] = new Item(ChestPlate.values()[ra]);
            } else if (r == 1) {
                int ra = random.nextInt(Clothes.values().length);
                items[x][y] = new Item(Clothes.values()[ra]);
            } else if (r == 2) {
                int ra = random.nextInt(Helmet.values().length);
                items[x][y] = new Item(Helmet.values()[ra]);
            } else if (r == 3) {
                int ra = random.nextInt(Leggings.values().length);
                items[x][y] = new Item(Leggings.values()[ra]);
            } else if (r == 4) {
                int ra = random.nextInt(Weapons.values().length);
                items[x][y] = new Item(Weapons.values()[ra]);
            }
        }
    }

    @Override
    public void render() {
        if (player != null) {
            Draw.setFill(Color.color(0, 0, 0, 0.3));
            Draw.rect(64*4, 64*3, 64*12, 64*((maxSize/9)), true);
            int y = 0;
            for (Item[] itemL : items) {
                int x = 0;
                for (Item item : itemL) {
                    if (item != null) {
                        Draw.drawImage(item.getImage(player.getGender()), x + (64 * 4), y + (64 * 3), item.getImage(player.getGender()).getWidth(), item.getImage(player.getGender()).getHeight(), true);
                    }
                    x += 64;
                }
                y+=64;
            }

            Draw.setFill(Color.BLACK);
            int mx = (int) MouseInput.x, my = (int) MouseInput.y;
            Draw.rect((mx/64)*64, (my/64)*64, 64, 1, true);
            Draw.rect((mx/64)*64, ((my/64)*64)+63, 64, 1, true);
            Draw.rect(((mx/64)*64)+63, (my/64)*64, 1, 64, true);
            Draw.rect((mx/64)*64, (my/64)*64, 1, 64, true);
        }
    }

    public enum InventoryType {

        LOOT,
        PLAYER

    }

}
