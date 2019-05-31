package game.items;

import game.Main;
import game.player.Player;
import javafx.scene.image.Image;

import java.util.ArrayList;

public enum Clothes {

    BANDANA(Color.RED, ClothingType.HEAD),
    SKIRT(Color.BROWN, ClothingType.SKIRT),
    MAGENTA_PANTS(Color.MAGENTA, ClothingType.PANTS),
    RED_PANTS(Color.RED, ClothingType.PANTS),
    TEAL_PANTS(Color.TEAL, ClothingType.PANTS),
    WHITE_PANTS(Color.WHITE, ClothingType.PANTS),
    BROWN_SHIRT(Color.BROWN, ClothingType.TORSO),
    MAROON_SHIRT(Color.MAROON, ClothingType.TORSO),
    TEAL_SHIRT(Color.TEAL, ClothingType.TORSO),
    WHITE_SHIRT(Color.WHITE, ClothingType.TORSO);

    public ArrayList<Image>[] setMale;
    public ArrayList<Image>[] setFemale;
    public final Color color;
    public final ClothingType clothingType;

    Clothes(Color color, ClothingType clothingType) {
        this.color = color;
        this.clothingType = clothingType;

        switch (clothingType) {
            case TORSO:
                setMale = Main.loadCharArray(new Image("game/images/spritesheets/torso/shirts/male/" + this.color.name().toLowerCase() + ".png"));
                setFemale = Main.loadCharArray(new Image("game/images/spritesheets/torso/shirts/female/" + this.color.name().toLowerCase() + ".png"));
                break;
            case PANTS:
                setMale = Main.loadCharArray(new Image("game/images/spritesheets/legs/pants/male/" + this.color.name().toLowerCase() + ".png"));
                setFemale = Main.loadCharArray(new Image("game/images/spritesheets/legs/pants/female/" + this.color.name().toLowerCase() + ".png"));
                break;
            case SKIRT:
                setMale = Main.loadCharArray(new Image("game/images/spritesheets/legs/skirt/male/" + this.color.name().toLowerCase() + ".png"));
                setFemale = Main.loadCharArray(new Image("game/images/spritesheets/legs/skirt/female/" + this.color.name().toLowerCase() + ".png"));
                break;
            case HEAD:
                setMale = Main.loadCharArray(new Image("game/images/spritesheets/head/bandanas/male/" + this.color.name().toLowerCase() + ".png"));
                setFemale = Main.loadCharArray(new Image("game/images/spritesheets/head/bandanas/female/" + this.color.name().toLowerCase() + ".png"));
        }
    }

    public ArrayList<Image>[] getSet(Player.Gender gender) {
        switch (gender) {
            case MALE:
                return setMale;
            case FEMALE:
                return setFemale;
        }
        return null;
    }

    public enum ClothingType {

        HEAD,
        PANTS,
        SKIRT,
        TORSO;

    }

    public enum Color {

        BROWN,
        MAROON,
        TEAL,
        WHITE,
        MAGENTA,
        RED;

    }

}
