package game.enemies;

import engine.objects.GameObject;
import engine.math.Vector2;
import engine.scripts.Animator;
import engine.scripts.SpriteRenderer;
import game.Main;
import javafx.scene.image.Image;

public class Enemy extends GameObject {

    // OGRE

    private String file;
    public int activeRange, disengageRange, damage;

    private int health = 50;

    private Runnable onDeath;

    public Enemy(String file, int activeRange, int disengageRange, int damage) {
        super();

        this.x = (int)(1000*Math.random()) + 1000;
        this.y = (int)(1000*Math.random()) + 1000;
        this.file = file;
        this.activeRange = activeRange;
        this.disengageRange = disengageRange;
        this.damage = damage;

    }

    @Override
    public void load() {
        // Add scripts
        addScript(new EnemyMovement());

        SpriteRenderer r = new SpriteRenderer(new Image(file), 64, 64).setOffset(new Vector2(-32, -32));
        addScript(new Animator(Main.loadCharArray(new Image(file)), 0.15, r));
        addScript(r);

        // Loads scripts
        super.load();
    }

    public void setOnDeath(Runnable onDeath) {
        this.onDeath = onDeath;
    }

    public int getHealth() {
        return health;
    }

    public void damage(int amount) {
        if (health != 0) {
            health -= amount;
            if (health <= 0) {
                health = 0;
                onDeath.run();
            }
        }
    }

    public void heal(int amount) {
        health += amount;
        if (health > 50) health = 50;
    }
}
