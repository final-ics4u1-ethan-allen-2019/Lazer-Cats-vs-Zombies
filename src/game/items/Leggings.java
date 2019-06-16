package game.items;

import game.Main;
import game.player.Player;
import javafx.scene.image.Image;

import java.util.ArrayList;

public enum Leggings {

    GOLD,
    METAL;

    public ArrayList<Image>[] setMale;
    public ArrayList<Image>[] setFemale;
    public Image icon;

    Leggings() {
        setMale = Main.loadCharArray(new Image("game/images/spritesheets/legs/armor/male/" + this.name().toLowerCase() + ".png"));
        setFemale = Main.loadCharArray(new Image("game/images/spritesheets/legs/armor/female/" + this.name().toLowerCase() + ".png"));

        icon = new Image("game/images/icons/armor/legs/" + this.name().toLowerCase() + "_icon.png");
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
