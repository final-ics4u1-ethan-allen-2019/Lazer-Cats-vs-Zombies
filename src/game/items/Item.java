package game.items;

import game.player.Player;
import javafx.scene.image.Image;

public class Item {

    public Enum type;

    public Item(Enum type) {
        this.type = type;
    }

    public Image getImage(Player.Gender gender) {
        if (type instanceof ChestPlate) {
            return ((ChestPlate) type).icon;
        } else if (type instanceof Clothes) {
            return ChestPlate.CHAIN.icon;
        } else if (type instanceof Helmet) {
            return ((Helmet) type).icon;
        } else if (type instanceof Leggings) {
            return ((Leggings) type).icon;
        } else if (type instanceof Weapons) {
            return ((Weapons) type).icon;
        }
        return null;
    }

}
