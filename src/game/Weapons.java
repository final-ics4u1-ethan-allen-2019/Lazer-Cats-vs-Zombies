package game;

import javafx.scene.image.Image;

import java.util.ArrayList;

public enum Weapons {

    DAGGER(HoldType.RIGHT_HAND, AttackType.SLASH, Player.Gender.EITHER),
    SPEAR(HoldType.RIGHT_HAND, AttackType.POKE, Player.Gender.EITHER),
    WOODWAND(HoldType.RIGHT_HAND, AttackType.MAGIC, Player.Gender.EITHER),
    STEELWAND(HoldType.RIGHT_HAND, AttackType.MAGIC, Player.Gender.FEMALE),
    BOW(HoldType.RIGHT_HAND, AttackType.RANGED, Player.Gender.EITHER),
    GREATBOW(HoldType.RIGHT_HAND, AttackType.RANGED, Player.Gender.EITHER),
    RECURVEBOW(HoldType.RIGHT_HAND, AttackType.RANGED, Player.Gender.EITHER);

    public final HoldType holdType;
    public final AttackType attackType;
    public final Player.Gender gender;

    public final ArrayList<Image>[] imageSetMale;
    public final ArrayList<Image>[] imageSetFemale;

    Weapons(HoldType holdType, AttackType attackType, Player.Gender gender) {
        this.holdType = holdType;
        this.attackType = attackType;
        this.gender = gender;

        if (attackType.equals(AttackType.RANGED)) {
            imageSetMale = Main.loadCharArray(new Image("game/images/spritesheets/weapons/" + this.holdType.name().toLowerCase().replace("_", " ") + "/either/" + this.name().toLowerCase() + ".png"));
            imageSetFemale = Main.loadCharArray(new Image("game/images/spritesheets/weapons/" + this.holdType.name().toLowerCase().replace("_", " ") + "/either/" + this.name().toLowerCase() + ".png"));
        } else {
            if (gender.equals(Player.Gender.EITHER)) {
                imageSetMale = Main.loadCharArray(new Image("game/images/spritesheets/weapons/" + this.holdType.name().toLowerCase().replace("_", " ") + "/male/" + this.name().toLowerCase() + "_male.png"));
                imageSetFemale = Main.loadCharArray(new Image("game/images/spritesheets/weapons/" + this.holdType.name().toLowerCase().replace("_", " ") + "/female/" + this.name().toLowerCase() + "_female.png"));
            } else {
                imageSetMale = null;
                imageSetFemale = Main.loadCharArray(new Image("game/images/spritesheets/weapons/" + this.holdType.name().toLowerCase().replace("_", " ") + "/female/" + this.name().toLowerCase() + "_female.png"));
            }
        }
    }

    public ArrayList<Image>[] getImageSet(Player.Gender gender) {
        switch (gender) {
            case MALE:
                return imageSetMale;
            case FEMALE:
                return imageSetFemale;
        }
        return null;
    }

    public enum HoldType {

        TWO_HANDED,
        LEFT_HAND,
        RIGHT_HAND;

    }

    public enum AttackType {

        RANGED,
        MAGIC,
        SLASH,
        POKE;

    }

}
