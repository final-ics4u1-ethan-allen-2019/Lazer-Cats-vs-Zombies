package game;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Player {

    private BodyType bodyType;
    private Gender gender;
    private NoseType noseType;
    private EarType earType;
    private EyeColor eyeColor;

    private Weapons leftHand;
    private Weapons rightHand = Weapons.SPEAR;

    public Player(BodyType bodyType, Gender gender, NoseType noseType, EarType earType, EyeColor eyeColor) {
        this.bodyType = bodyType;
        this.gender = gender;
        this.noseType = noseType;
        this.earType = earType;
        this.eyeColor = eyeColor;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public EarType getEarType() {
        return earType;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public Gender getGender() {
        return gender;
    }

    public NoseType getNoseType() {
        return noseType;
    }

    public Weapons getLeftHand() {
        return leftHand;
    }

    public Weapons getRightHand() {
        return rightHand;
    }

    public enum BodyType {

        DARK,
        DARK2,
        DARKELF,
        DARKELF2,
        LIGHT,
        TANNED,
        TANNED2;

        final ArrayList<Image>[] playerMale;
        final ArrayList<Image>[] playerFemale;
        final ArrayList<Image>[] bignose;
        final ArrayList<Image>[] buttonnose;
        final ArrayList<Image>[] straightnose;
        final ArrayList<Image>[] bigears;
        final ArrayList<Image>[] elvenears;

        BodyType() {
            playerMale = Main.loadCharArray(new Image("game/images/spritesheets/body/male/" + this.name().toLowerCase() + ".png"));
            playerFemale = Main.loadCharArray(new Image("game/images/spritesheets/body/female/" + this.name().toLowerCase() + ".png"));
            bignose = Main.loadCharArray(new Image("game/images/spritesheets/body/male/nose/bignose_" + this.name().toLowerCase() + ".png"));
            buttonnose = Main.loadCharArray(new Image("game/images/spritesheets/body/male/nose/buttonnose_" + this.name().toLowerCase() + ".png"));
            straightnose = Main.loadCharArray(new Image("game/images/spritesheets/body/male/nose/straightnose_" + this.name().toLowerCase() + ".png"));
            bigears = Main.loadCharArray(new Image("game/images/spritesheets/body/male/ears/bigears_" + this.name().toLowerCase() + ".png"));
            elvenears = Main.loadCharArray(new Image("game/images/spritesheets/body/male/ears/elvenears_" + this.name().toLowerCase() + ".png"));
        }

        public ArrayList<Image>[] getNose(NoseType type) {
            switch (type) {
                case BIGNOSE:
                    return bignose;
                case BUTTONNOSE:
                    return buttonnose;
                case STRAIGHTNOSE:
                    return straightnose;
            }
            return null;
        }

        public ArrayList<Image>[] getEars(EarType type) {
            switch (type) {
                case BIGEARS:
                    return bigears;
                case ELVENEARS:
                    return elvenears;
            }
            return null;
        }

        public ArrayList<Image>[] getGender(Gender gender) {
            switch (gender) {
                case MALE:
                    return playerMale;
                case FEMALE:
                    return playerFemale;
            }
            return null;
        }
    }

    public enum Gender {

        MALE,
        FEMALE,
        EITHER;

    }

    public enum EarType {

        BIGEARS,
        ELVENEARS;

    }

    public enum NoseType {

        BIGNOSE,
        BUTTONNOSE,
        STRAIGHTNOSE;

    }

    public enum EyeColor {

        BLUE(),
        BROWN(),
        GRAY(),
        GREEN(),
        ORANGE(),
        PURPLE(),
        RED(),
        YELLOW();

        final ArrayList<Image>[] images;
        EyeColor() {
            images = Main.loadCharArray(new Image("game/images/spritesheets/body/male/eyes/" + this.name().toLowerCase() + ".png"));
        }

    }
}