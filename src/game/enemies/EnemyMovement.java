package game.enemies;

import engine.GameObject;
import engine.Time;
import engine.math.Vector2;
import engine.scenes.SceneManager;
import engine.scripts.Animator;
import engine.scripts.Script;
import game.player.PlayerObject;

import java.util.ArrayList;

public class EnemyMovement extends Script {

    private Enemy enemy;

    private ArrayList<PlayerObject> players = new ArrayList<>();

    private PlayerObject engaged;

    private Animator animator;

    @Override
    public void load() {
        enemy = (Enemy) parent;

        for (GameObject object : SceneManager.getCurrentGameScene().getActive()) {
            if (object instanceof PlayerObject) players.add((PlayerObject) object);
        }

        for (Script script : parent.getScripts()) {
            if (script instanceof Animator) animator = (Animator) script;
        }
    }

    @Override
    public void update() {
        // Check to see if you should engage on a new target/stop engaging current
        if (engaged != null && Math.hypot(parent.x-engaged.x, parent.y-engaged.y) < enemy.disengageRange) engaged = null;
        for (PlayerObject player : players) {
            if (Math.hypot(parent.x-player.x, parent.y-player.y) < enemy.activeRange) {
                engaged = player;
            }
        }
        if (engaged == null) {
            animator.setState(23);
        } else {
            int ang = (int) (Math.toDegrees(Math.atan2(parent.y - engaged.y, parent.x - engaged.x)))+180;
            int dir;
            if ((ang >= 225 && ang <= 315)) dir = 0;
            else if ((ang >= 135 && ang <= 225)) dir = 1;
            else if ((ang >= 45 && ang <= 135)) dir = 2;
            else dir = 3;

            animator.setState(8+dir);

            double hyp = Math.hypot(parent.x - engaged.x, parent.y - engaged.y);
            Vector2 vector2 = new Vector2((parent.x - engaged.x)/hyp, (parent.y - engaged.y)/hyp).multiply(160).multiply(Time.deltaTime);
            parent.x -= vector2.x;
            parent.y -= vector2.y;
        }
    }
}
