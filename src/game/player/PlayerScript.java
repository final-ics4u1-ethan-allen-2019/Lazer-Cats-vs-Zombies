package game.player;

import engine.Game;
import engine.Time;
import engine.input.KeyboardInput;
import engine.input.MouseInput;
import engine.math.Vector2;
import engine.scenes.SceneManager;
import engine.scripts.Animator;
import engine.scripts.Script;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class PlayerScript extends Script {

    ArrayList<Animator> animators = new ArrayList<>();

    private Animator leftHand, rightHand, torso, pants, head;

    private Player player;

    private boolean set;

    public PlayerScript(Animator leftHand, Animator rightHand, Animator torso, Animator pants, Animator head) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.torso = torso;
        this.pants = pants;
        this.head = head;
    }

    @Override
    public void load() {
        player = ((PlayerObject) parent).player;
        for (Script script : parent.getScripts()) {
            if (script instanceof Animator) {
                animators.add((Animator) script);
            }
        }
        itemsChanged();
    }

    @Override
    public void update() {
        // Sync animators
        for (Animator animator : animators) {
            animator.setCurrent(animators.get(0).getCurrent());
        }

        // Direction
        int ang = (int) (Math.toDegrees(Math.atan2(((Game.getHeight()/2)-MouseInput.y), (Game.getWidth()/2- MouseInput.x))))+180;
        int dir;
        if ((ang >= 225 && ang <= 315)) dir = 0;
        else if ((ang >= 135 && ang <= 225)) dir = 1;
        else if ((ang >= 45 && ang <= 135)) dir = 2;
        else dir = 3;

        // Attacking
        boolean attacking = MouseInput.isPressed;
        if (attacking) {
            int state = 12;

            if (player.getRightHand() != null) switch (player.getRightHand().attackType) {
                case RANGED:
                    state = 16;
                case MAGIC:
                    state = 12;
                case POKE:
                    state = 4;
                case SLASH:
                    state = 12;
            }

            for (Animator animator : animators) {
                animator.setState(state+dir);
            }
        }

        // Movement
        boolean moving = false;
        if (KeyboardInput.isKeyDown(KeyCode.W) && !attacking) {
            for (Animator animator : animators) {
                animator.setState(8);
            }
            parent.y -= 200 * Time.deltaTime;
            moving = true;
        }
        if (KeyboardInput.isKeyDown(KeyCode.S) && !attacking) {
            for (Animator animator : animators) {
                animator.setState(10);
            }
            parent.y += 200 * Time.deltaTime;
            moving = true;
        }
        if (KeyboardInput.isKeyDown(KeyCode.A) && !attacking) {
            for (Animator animator : animators) {
                animator.setState(9);
            }
            parent.x -= 200 * Time.deltaTime;
            moving = true;
        }
        if (KeyboardInput.isKeyDown(KeyCode.D) && !attacking) {
            for (Animator animator : animators) {
                animator.setState(11);
            }
            parent.x += 200 * Time.deltaTime;
            moving = true;
        }

        // Static looking direction
        if (!(moving || attacking)) {
            for (Animator animator : animators) {
                animator.setState(21+dir);
            }
        }

        SceneManager.getCurrentGameScene().cameraPosition = new Vector2(parent.x-(Game.getWidth()/2)+32, parent.y-(Game.getHeight()/2)+32);
    }

    public void itemsChanged() {
        if (player.getRightHand() == null) rightHand.setImages(null);
        else rightHand.setImages(player.getRightHand().getImageSet(player.getGender()));
        if (player.getTorso() == null) torso.setImages(null);
        else torso.setImages(player.getTorso().getSet(player.getGender()));
        if (player.getPants() == null) pants.setImages(null);
        else pants.setImages(player.getPants().getSet(player.getGender()));
        if (player.getHead() == null) {
            if (player.getHairType() == null) head.setImages(null);
            else head.setImages(player.getHairType().getSet(player.getHairColor()));
        } else head.setImages(player.getHead().getSet(player.getGender()));
    }
}
