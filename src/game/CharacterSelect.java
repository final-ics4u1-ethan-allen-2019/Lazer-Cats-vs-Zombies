package game;

import engine.scripts.Script;
import engine.scripts.SpriteRenderer;
import game.player.Player;

public class CharacterSelect extends Script {

    private SpriteRenderer body, hair, eyes, ears, nose;

    private int b, h, hc, ey, ea, n, g;

    public CharacterSelect(SpriteRenderer body, SpriteRenderer hair, SpriteRenderer eyes, SpriteRenderer ears, SpriteRenderer nose) {
        this.body = body;
        this.hair = hair;
        this.eyes = eyes;
        this.ears = ears;
        this.nose = nose;
    }

    public void nextBody() {
        b++;
        if (b == Player.BodyType.values().length) b = 0;

        body.setImage(Player.BodyType.values()[b].getGender(Player.Gender.values()[g])[2].get(0));
    }

    public void prevBody() {
        b--;
        if (b == -1) b = Player.BodyType.values().length-1;

        body.setImage(Player.BodyType.values()[b].getGender(Player.Gender.values()[g])[2].get(0));
    }

    public void nextHair() {
        h++;
        if (h == Player.HairType.values().length) h = 0;

        hair.setImage(Player.HairType.values()[h].getSet(Player.HairColor.values()[hc])[2].get(0));
    }

    public void prevHair() {
        h--;
        if (h == -1) h = Player.HairType.values().length-1;

        hair.setImage(Player.HairType.values()[h].getSet(Player.HairColor.values()[hc])[2].get(0));
    }

    public void nextHairColor() {
        hc++;
        if (hc == Player.HairColor.values().length) hc = 0;

        hair.setImage(Player.HairType.values()[h].getSet(Player.HairColor.values()[hc])[2].get(0));
    }

    public void prevHairColor() {
        hc--;
        if (hc == -1) hc = Player.HairColor.values().length-1;

        hair.setImage(Player.HairType.values()[h].getSet(Player.HairColor.values()[hc])[2].get(0));
    }

    public void nextEye() {
        ey++;
        if (ey == Player.EyeColor.values().length) ey = 0;

        eyes.setImage(Player.EyeColor.values()[ey].images[2].get(0));
    }

    public void prevEye() {
        ey--;
        if (ey == -1) ey = Player.EarType.values().length-1;

        eyes.setImage(Player.EyeColor.values()[ey].images[2].get(0));
    }

    public void nextEar() {
        ea++;
        if (ea == Player.EarType.values().length) ea = 0;

        ears.setImage(Player.BodyType.values()[b].getEars(Player.EarType.values()[ea])[2].get(0));
    }

    public void prevEar() {
        ea--;
        if (ea == -1) ea = Player.EarType.values().length-1;

        ears.setImage(Player.BodyType.values()[b].getEars(Player.EarType.values()[ea])[2].get(0));
    }

    public void nextNose() {
        n++;
        if (n == Player.NoseType.values().length) n = 0;

        nose.setImage(Player.BodyType.values()[b].getNose(Player.NoseType.values()[n])[2].get(0));
    }

    public void prevNose() {
        n--;
        if (n == -1) n = Player.NoseType.values().length-1;

        nose.setImage(Player.BodyType.values()[b].getNose(Player.NoseType.values()[n])[2].get(0));
    }

    public void nextGender() {
        g++;
        if (g == Player.Gender.values().length-1) g = 0;

        body.setImage(Player.BodyType.values()[b].getGender(Player.Gender.values()[g])[2].get(0));
    }

    public void prevGender() {
        g--;
        if (g == -1) g = Player.Gender.values().length-2;

        body.setImage(Player.BodyType.values()[b].getGender(Player.Gender.values()[g])[2].get(0));
    }

    public Player makePlayer() {
        return new Player(Player.BodyType.values()[b], Player.Gender.values()[g], Player.NoseType.values()[n], Player.EarType.values()[ea], Player.EyeColor.values()[ey], Player.HairType.values()[h], Player.HairColor.values()[hc]);
    }

}
