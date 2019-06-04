package game.player;

import game.Main;
import game.items.*;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Player {

    private BodyType bodyType;
    private Gender gender;
    private NoseType noseType;
    private EarType earType;
    private EyeColor eyeColor;
    private HairType hairType;
    private HairColor hairColor;

    private Weapons leftHand, rightHand = Weapons.SPEAR;

    private Clothes torso, pants, head;

    private Helmet helmet = Helmet.SPEAR;
    private ChestPlate chestPlate = ChestPlate.CHAIN;
    private Leggings leggings = Leggings.METAL;

    private int health = 50;

    private Runnable onDeath;

    public Player(BodyType bodyType, Gender gender, NoseType noseType, EarType earType, EyeColor eyeColor, HairType hairType, HairColor hairColor) {
        this.bodyType = bodyType;
        this.gender = gender;
        this.noseType = noseType;
        this.earType = earType;
        this.eyeColor = eyeColor;
        this.hairType = hairType;
        this.hairColor = hairColor;
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

    public Clothes getTorso() {
        return torso;
    }

    public Clothes getHead() {
        return head;
    }

    public Clothes getPants() {
        return pants;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public HairType getHairType() {
        return hairType;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    public ChestPlate getChestPlate() {
        return chestPlate;
    }

    public Leggings getLeggings() {
        return leggings;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public void setChestPlate(ChestPlate chestPlate) {
        this.chestPlate = chestPlate;
    }

    public void setLeggings(Leggings leggings) {
        this.leggings = leggings;
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

    public enum HairType {

        BANGS,
        BANGSLONG,
        BANGSLONG2,
        BANGSSHORT,
        BEDHEAD,
        BUNCHES,
        JEWFRO,
        LONG,
        LONGHAWK,
        LONGKNOT,
        LOOSE,
        MESSY1,
        MESSY2,
        MOHAWK,
        PAGE,
        PAGE2,
        PARTED,
        PIXIE,
        PLAIN,
        PONYTAIL,
        PONYTAIL2,
        PRINCESS,
        SHORTHAWK,
        SHORTKNOT,
        SHOULDERL,
        SHOULDERR,
        SWOOP,
        UNKEMPT,
        XLONG,
        XLONGKNOT;

        public ArrayList<Image>[] getSet(HairColor color) {
            return Main.loadCharArray(new Image("game/images/spritesheets/hair/male/" + this.name().toLowerCase() + "/" + color.name().toLowerCase().replace("_", "-") + ".png"));
        }

    }

    public enum HairColor {

        BLACK,
        BLONDE,
        BLONDE2,
        BLUE,
        BLUE2,
        BROWN,
        BROWN2,
        BRUNETTE,
        BRUNETTE2,
        DARK_BLONDE,
        GOLD,
        GRAY,
        GRAY2,
        GREEN,
        GREEN2,
        LIGHT_BLONDE,
        LIGHT_BLONDE2,
        PINK,
        PINK2,
        PURPLE,
        RAVEN,
        RAVEN2,
        REDHEAD,
        REDHEAD2,
        RUBY_RED,
        WHITE,
        WHITE_BLONDE,
        WHITE_BLONDE2,
        WHITE_CYAN;

    }

}