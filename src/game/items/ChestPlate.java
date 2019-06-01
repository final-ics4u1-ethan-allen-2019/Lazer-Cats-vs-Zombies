package game.items;

import game.Main;
import game.player.Player;
import javafx.scene.image.Image;

import java.util.ArrayList;

public enum ChestPlate {

    CHAIN,
    GOLD,
    LEATHER,
    METAL;

    public ArrayList<Image>[] setMale;
    public ArrayList<Image>[] setFemale;

    ChestPlate() {
        setMale = Main.loadCharArray(new Image("game/images/spritesheets/torso/armor/male/" + this.name().toLowerCase() + ".png"));
        setFemale = Main.loadCharArray(new Image("game/images/spritesheets/torso/armor/female/" + this.name().toLowerCase() + ".png"));
    }

    public ArrayList<Image>[] getSet(Player.Gender gender) {
        switch (gender) {
            case FEMALE:
                return setFemale;
            case MALE:
                return setMale;
        }
        return null;
    }

}
