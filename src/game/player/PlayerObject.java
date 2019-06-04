package game.player;

import engine.GameObject;
import engine.scripts.Animator;
import engine.scripts.SpriteRenderer;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class PlayerObject extends GameObject {

    public Player player;

    public PlayerObject(Player player) {
        super();
        this.player = player;
    }

    @Override
    public void load() {

        Animator body, eyes, ears, nose, leftHand, rightHand, torso, head, pants;
        SpriteRenderer bodySr, eyesSr, earsSr, noseSr, leftHandSr, rightHandSr, torsoSr, headSr, pantSr;

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

        ArrayList<Image>[] tor = player.getBodyType().getNose(player.getNoseType());
        torsoSr = new SpriteRenderer(tor[0].get(0));
        torso = new Animator(tor, 0.1, torsoSr);

        addScript(torsoSr);
        addScript(torso);

        ArrayList<Image>[] hea = player.getBodyType().getNose(player.getNoseType());
        headSr = new SpriteRenderer(hea[0].get(0));
        head = new Animator(hea, 0.1, headSr);

        addScript(headSr);
        addScript(head);

        ArrayList<Image>[] pan = player.getBodyType().getNose(player.getNoseType());
        pantSr = new SpriteRenderer(pan[0].get(0));
        pants = new Animator(pan, 0.1, pantSr);

        addScript(pantSr);
        addScript(pants);

        ArrayList<Image>[] lef = player.getBodyType().getNose(player.getNoseType());
        leftHandSr = new SpriteRenderer(lef[0].get(0));
        leftHand = new Animator(lef, 0.1, leftHandSr);

        addScript(leftHandSr);
        addScript(leftHand);

        ArrayList<Image>[] rig = player.getBodyType().getNose(player.getNoseType());
        rightHandSr = new SpriteRenderer(rig[0].get(0));
        rightHand = new Animator(rig, 0.1, rightHandSr);

        addScript(rightHandSr);
        addScript(rightHand);

        addScript(new PlayerScript(leftHand, rightHand, torso, pants, head));

        super.load();
    }
}
