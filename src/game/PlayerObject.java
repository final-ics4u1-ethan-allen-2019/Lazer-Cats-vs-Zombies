package game;

import engine.GameObject;
import engine.scripts.Animator;
import engine.scripts.SpriteRenderer;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class PlayerObject extends GameObject {

    private Player player;

    public PlayerObject(Player player) {
        super();
        this.player = player;
    }

    @Override
    public void load() {

        Animator body, eyes, ears, nose;
        SpriteRenderer bodySr, eyesSr, earsSr, noseSr;

        ArrayList<Image>[] bod = player.getBodyType().getGender(player.getGender());
        bodySr = new SpriteRenderer(bod[0].get(0));
        body = new Animator(bod, 0.1, bodySr);

        addScript(bodySr);
        addScript(body);

        ArrayList<Image>[] eye = player.getEyeColor().images;
        eyesSr = new SpriteRenderer(eye[0].get(0));
        eyes = new Animator(eye, 0.1, eyesSr);

        addScript(eyesSr);
        addScript(eyes);

        ArrayList<Image>[] ear = player.getBodyType().getEars(player.getEarType());
        earsSr = new SpriteRenderer(ear[0].get(0));
        ears = new Animator(ear, 0.1, earsSr);

        addScript(earsSr);
        addScript(ears);

        ArrayList<Image>[] nos = player.getBodyType().getNose(player.getNoseType());
        noseSr = new SpriteRenderer(nos[0].get(0));
        nose = new Animator(nos, 0.1, noseSr);

        addScript(noseSr);
        addScript(nose);

        addScript(new PlayerScript());

        super.load();
    }
}
