package engine;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class Cropper {

    private WritableImage img;

    public Cropper(Image img) {
        this.img = (WritableImage) img;
    }

    public void setImg(WritableImage img) {
        this.img = img;
    }

    public WritableImage crop(int x, int y, int width, int height){
        PixelReader w = img.getPixelReader();
        WritableImage newImg = new WritableImage(w, x, y, width, height);
        return newImg;
    }

    public Image getImg() {
        return img;
    }
}
