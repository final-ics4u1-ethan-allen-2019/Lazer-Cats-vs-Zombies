package game;

import engine.Draw;
import engine.Game;
import engine.Time;
import engine.input.KeyboardInput;
import engine.math.Vector2;
import engine.scenes.SceneManager;
import engine.scripts.Animator;
import engine.scripts.Script;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class PlayerScript extends Script {

    ArrayList<Animator> animators = new ArrayList<>();

    private Animator leftHand, rightHand;

    private Player player;

    public PlayerScript(Animator leftHand, Animator rightHand) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }

    @Override
    public void load() {
        player = ((PlayerObject) parent).player;
        for (Script script : parent.getScripts()) {
            if (script instanceof Animator) {
                animators.add((Animator) script);
            }
        }
    }

    @Override
    public void update() {
        for (Animator animator : animators) {
            animator.setCurrent(animators.get(0).getCurrent());
        }
        boolean moving = false;
        if (KeyboardInput.isKeyDown(KeyCode.W)) {
            for (Animator animator : animators) {
                animator.setState(8);
            }
            parent.y -= 200 * Time.deltaTime;
            moving = true;
        }
        if (KeyboardInput.isKeyDown(KeyCode.S)) {
            for (Animator animator : animators) {
                animator.setState(10);
            }
            parent.y += 200 * Time.deltaTime;
            moving = true;
        }
        if (KeyboardInput.isKeyDown(KeyCode.A)) {
            for (Animator animator : animators) {
                animator.setState(9);
            }
            parent.x -= 200 * Time.deltaTime;
            moving = true;
        }
        if (KeyboardInput.isKeyDown(KeyCode.D)) {
            for (Animator animator : animators) {
                animator.setState(11);
            }
            parent.x += 200 * Time.deltaTime;
            moving = true;
        }
        if (!moving) for (Animator animator : animators) {
            animator.setState(21);
        }

        rightHand.setImages(player.getRightHand().getImageSet(player.getGender()));

        SceneManager.getCurrentGameScene().cameraPosition = new Vector2(parent.x-(Game.getWidth()/2), parent.y-(Game.getHeight()/2));
    }

//    @Override
//    public void render() {
//        int y = 0;
//        for (Animator anim : animators) {
//            Draw.drawText(anim.getState() + "", 0, 20+(20*y), true);
//            y++;
//        }
//    }
}
