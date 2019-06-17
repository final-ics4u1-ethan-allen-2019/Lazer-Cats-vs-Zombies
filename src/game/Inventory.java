package game;

import engine.Draw;
import engine.input.MouseInput;
import engine.math.Vector2;
import engine.scenes.SceneManager;
import engine.scripts.Script;
import game.items.*;
import game.player.PlayerObject;
import game.player.PlayerScript;
import javafx.scene.paint.Color;

import java.util.Random;

public class Inventory extends Script {

    private static Random random = new Random();

    private Item[][] items;

    private int maxSize, sizeX;

    private InventoryType type;

    private PlayerObject player;

    private Item holding;

    private boolean held;

    public Inventory(int maxSize, int sizeX, InventoryType type) {
        this.maxSize = maxSize;
        this.sizeX = sizeX;
        this.type = type;

        items = new Item[maxSize/sizeX][sizeX];

        if (type == InventoryType.LOOT) generateRandomLoot();
    }

    public void open(PlayerObject player) {
        this.player = player;
    }

    public void close() {
        if (holding != null) {
            SceneManager.getCurrentGameScene().spawnObject(new ItemEntity(new Vector2(player.x, player.y), holding));
        }
        this.player = null;
        holding = null;
    }

    public void generateRandomLoot() {
        int ran = random.nextInt(2) + 1;
        for (int i = 0; i < ran; i++) {
            int r = random.nextInt(5);
            int x = random.nextInt(maxSize/sizeX);
            int y = random.nextInt(sizeX);
            while (true) {
                if (items[x][y] != null) {
                    x = random.nextInt(maxSize / sizeX);
                    y = random.nextInt(sizeX);
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
    public void update() {
        if (this.player != null) {
            int mx = (int) MouseInput.x, my = (int) MouseInput.y;

            if ((mx / 64) - 4 >= 0 && (mx / 64) - 4 <= 4 && (my / 64) - 3 >= 0 && (my / 64) - 3 <= 2 && MouseInput.isPressed && !held) {
                held = true;
                if (holding == null && items[(my / 64) - 3][(mx / 64) - 4] != null) {
                    holding = items[(my / 64) - 3][(mx / 64) - 4];
                    items[(my / 64) - 3][(mx / 64) - 4] = null;
                } else if (items[(my / 64) - 3][(mx / 64) - 4] == null && holding != null) {
                    items[(my / 64) - 3][(mx / 64) - 4] = holding;
                    holding = null;
                }
            } else if ((mx / 64) - 9 >= 0 && (mx / 64) - 9 <= 3 && (my / 64) - 3 >= 0 && (my / 64) - 3 <= 2 && MouseInput.isPressed && !held) {
                held = true;
                if (holding == null && player.player.getInventory().items[(my / 64) - 3][(mx / 64) - 9] != null) {
                    holding = player.player.getInventory().items[(my / 64) - 3][(mx / 64) - 9];
                    player.player.getInventory().items[(my / 64) - 3][(mx / 64) - 9] = null;
                } else if (player.player.getInventory().items[(my / 64) - 3][(mx / 64) - 9] == null && holding != null) {
                    player.player.getInventory().items[(my / 64) - 3][(mx / 64) - 9] = holding;
                    holding = null;
                }
            } else if ((mx / 64) - 13 >= 0 && (mx / 64) - 13 <= 2 && (my / 64) - 3 >= 0 && (my / 64) - 3 <= 2 && MouseInput.isPressed && !held) {
                int x = (mx/64) - 13, y = (my/64) - 3;
                if (x == 1 && y == 0) {
                    if (player.player.getHelmet() != null && holding == null) {
                        holding = new Item(player.player.getHelmet());
                        player.player.setHelmet(null);
                        for (Script script : player.getScripts()) {
                            if (script instanceof PlayerScript) {
                                ((PlayerScript) script).itemsChanged();
                            }
                        }
                    } else if (player.player.getHelmet() == null && holding != null && holding.type instanceof Helmet) {
                        player.player.setHelmet((Helmet) holding.type);
                        holding = null;
                        for (Script script : player.getScripts()) {
                            if (script instanceof PlayerScript) {
                                ((PlayerScript) script).itemsChanged();
                            }
                        }
                    }
                } else if (x == 1 && y == 1) {
                    if (player.player.getChestPlate() != null && holding == null) {
                        holding = new Item(player.player.getChestPlate());
                        player.player.setChestPlate(null);
                        for (Script script : player.getScripts()) {
                            if (script instanceof PlayerScript) {
                                ((PlayerScript) script).itemsChanged();
                            }
                        }
                    } else if (player.player.getChestPlate() == null && holding != null && holding.type instanceof ChestPlate) {
                        player.player.setChestPlate((ChestPlate) holding.type);
                        holding = null;
                        for (Script script : player.getScripts()) {
                            if (script instanceof PlayerScript) {
                                ((PlayerScript) script).itemsChanged();
                            }
                        }
                    }
                } else if (x == 1 && y == 2) {
                    if (player.player.getLeggings() != null && holding == null) {
                        holding = new Item(player.player.getLeggings());
                        player.player.setLeggings(null);
                        for (Script script : player.getScripts()) {
                            if (script instanceof PlayerScript) {
                                ((PlayerScript) script).itemsChanged();
                            }
                        }
                    } else if (player.player.getLeggings() == null && holding != null && holding.type instanceof Leggings) {
                        player.player.setLeggings((Leggings) holding.type);
                        holding = null;
                        for (Script script : player.getScripts()) {
                            if (script instanceof PlayerScript) {
                                ((PlayerScript) script).itemsChanged();
                            }
                        }
                    }
                } else if (x == 0 && y == 1) {
                    if (player.player.getRightHand() != null && holding == null) {
                        holding = new Item(player.player.getRightHand());
                        player.player.setRightHand(null);
                        for (Script script : player.getScripts()) {
                            if (script instanceof PlayerScript) {
                                ((PlayerScript) script).itemsChanged();
                            }
                        }
                    } else if (player.player.getRightHand() == null && holding != null && holding.type instanceof Weapons) {
                        player.player.setRightHand((Weapons) holding.type);
                        holding = null;
                        for (Script script : player.getScripts()) {
                            if (script instanceof PlayerScript) {
                                ((PlayerScript) script).itemsChanged();
                            }
                        }
                    }
                }
                held = true;
            } else if (MouseInput.isPressed && !held && holding != null) {
                SceneManager.getCurrentGameScene().spawnObject(new ItemEntity(new Vector2(player.x, player.y), holding));
                holding = null;
            } else if (!MouseInput.isPressed) {
                held = false;
            }
            Draw.setFill(Color.BLACK);
            Draw.drawText(((mx / 64) - 4) + "/" + ((my / 64) - 3), 10, 50, true);
            Draw.drawText(((mx / 64) - 13) + "/" + ((my / 64) - 3), 10, 90, true);
        }
    }

    @Override
    public void render() {
        if (player != null) {
            Draw.setFill(Color.color(0, 0, 0, 0.3));
            Draw.rect(64*4, 64*3, 64*12, 64*3, true);
            int y = 0;
            for (Item[] itemL : items) {
                int x = 0;
                for (Item item : itemL) {
                    if (item != null) {
                        Draw.drawImage(item.getImage(player.player.getGender()), x + (64 * 4), y + (64 * 3), item.getImage(player.player.getGender()).getWidth(), item.getImage(player.player.getGender()).getHeight(), true);
                    }
                    x += 64;
                }
                y += 64;
            }

            y = 0;
            for (Item[] itemL : player.player.getInventory().items) {
                int x = 0;
                for (Item item : itemL) {
                    if (item != null) {
                        Draw.drawImage(item.getImage(player.player.getGender()), x + (64 * 9), y + (64 * 3), item.getImage(player.player.getGender()).getWidth(), item.getImage(player.player.getGender()).getHeight(), true);
                    }
                    x += 64;
                }
                y += 64;
            }

            if (player.player.getHelmet() != null) {
                Draw.drawImage(player.player.getHelmet().icon, (64*14), (64*3), player.player.getHelmet().icon.getWidth(), player.player.getHelmet().icon.getHeight(), true);
            }
            if (player.player.getChestPlate() != null) {
                Draw.drawImage(player.player.getChestPlate().icon, (64*14), (64*4), player.player.getChestPlate().icon.getWidth(), player.player.getChestPlate().icon.getHeight(), true);
            }
            if (player.player.getLeggings() != null) {
                Draw.drawImage(player.player.getLeggings().icon, (64*14), (64*5), player.player.getLeggings().icon.getWidth(), player.player.getLeggings().icon.getHeight(), true);
            }
            if (player.player.getRightHand() != null) {
                Draw.drawImage(player.player.getRightHand().icon, (64*13), (64*4), 64, 64, true);
            }

            if (holding != null) {
                Draw.drawImage(holding.getImage(player.player.getGender()), MouseInput.x-32, MouseInput.y-32, holding.getImage(player.player.getGender()).getWidth(), holding.getImage(player.player.getGender()).getHeight(), true);
            }

            Draw.setFill(Color.WHITE);
            Draw.rect(64*9, 64*3, 1, 64*3, true);
            Draw.rect(64*13, 64*3, 1, 64*3, true);
            int mx = (int) MouseInput.x, my = (int) MouseInput.y;
            if ((mx/64) - 4 >= 0 && (mx/64) - 4 <= 11 && (my/64) - 3 >= 0 && (my/64) - 3 <= 2) {
                Draw.rect((mx / 64) * 64, (my / 64) * 64, 64, 1, true);
                Draw.rect((mx / 64) * 64, ((my / 64) * 64) + 63, 64, 1, true);
                Draw.rect(((mx / 64) * 64) + 63, (my / 64) * 64, 1, 64, true);
                Draw.rect((mx / 64) * 64, (my / 64) * 64, 1, 64, true);
            }
        }
    }

    public enum InventoryType {

        LOOT,
        PLAYER

    }

}
