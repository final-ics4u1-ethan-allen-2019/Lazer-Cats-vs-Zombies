package game;

import javafx.scene.image.Image;

import java.util.ArrayList;

public enum Armor {

    GOLD(ArmorClass.CHEST, Player.Gender.MALE, 0);

    public final ArmorClass armorClass;
    public final Player.Gender gender;
    public final int armorPoints;

    public ArrayList<Image>[] images;

    Armor(ArmorClass armorClass, Player.Gender gender, int armorPoints) {
        this.armorClass = armorClass;
        this.gender = gender;
        this.armorPoints = armorPoints;

        switch (armorClass) {
            case LEGS:
                images = null;
                break;
            case CHEST:
                images = Main.loadCharArray(new Image("images/spritesheets/torso/" + this.name().toLowerCase() + "/chest_" + gender.name().toLowerCase() + ".png"));
                break;
            case HELMET:
                images = null;
                break;
        }
    }

    public enum ArmorClass {

        LEGS,
        CHEST,
        HELMET;

    }

}
