package game.enemies;

import engine.GameObject;
import engine.scripts.Animator;
import engine.scripts.SpriteRenderer;
import game.Main;
import javafx.scene.image.Image;

public class Enemy extends GameObject {

    // OGRE

    private String file;
    public int activeRange, disengageRange, damage;

    public Enemy(String file, int activeRange, int disengageRange, int damage) {
        super();

        this.file = file;
        this.activeRange = activeRange;
        this.disengageRange = disengageRange;
        this.damage = damage;

    }

    @Override
    public void load() {
        // Add scripts
        addScript(new EnemyMovement());

        SpriteRenderer r = new SpriteRenderer(new Image(file), 64, 64);
        addScript(new Animator(Main.loadCharArray(new Image(file)), 0.15, r));
        addScript(r);

        // Loads scripts
        super.load();
    }
}
