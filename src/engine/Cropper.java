package engine;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

import java.util.ArrayList;

public class Cropper {

    private Image img;

    public enum directions {
        NORTHEAST,
        NORTHWEST,
        SOUTHEAST,
        SOUTHWEST,
    }

    public Cropper(Image img) {
        this.img = img;
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

    /** This loops and generates all images in the spritesheets
     *
     * @param width width of the desired image
     * @param height height of the desired image
     * @return a 2d Array list of Writable images cropped in rows left to right, and columns up to down
     */
    public ArrayList<ArrayList<WritableImage>> cropSpriteSheets(int width, int height){
        ArrayList<ArrayList<WritableImage>> textures = new ArrayList<>();
        PixelReader w = img.getPixelReader();
        for(int y = 0; y < Math.floor(img.getHeight()/height) * height; y+= height){
            ArrayList<WritableImage> row = new ArrayList<>();
            for(int x = 0; x < Math.floor(img.getWidth()/width) * width; x+= width){
                row.add(new WritableImage(w, x, y, width, height));
            }
            textures.add(row);
        }
        return textures;
    }


    /** Crops images in a pattern with more flexibility
     *
     * @param width     width of the cropped image
     * @param height    height of the cropped image
     * @param dir       the direction in which the array's information will be arranged in
     * @param startX    the x coordinate which the cropping starts
     * @param startY    the y coordinate which the cropping starts
     * @param reverseOrder reverses the layout of the arraylist so that its sorted by columns(x) by row(y)  (E.g textures.get(x).get(y))
     * @return 2d array list with all the textures
     */
    public ArrayList<ArrayList<WritableImage>> cropSpriteSheets(int width, int height, directions dir, int startX, int startY, boolean reverseOrder){
        ArrayList<ArrayList<WritableImage>> textures = new ArrayList<>();
        PixelReader w = img.getPixelReader();

        switch (dir){
            case NORTHEAST:
                height = Math.abs(height) * -1;
                width = Math.abs(width);
                break;
            case SOUTHEAST:
                height = Math.abs(height);
                width = Math.abs(width);
                break;
            case NORTHWEST:
                height = Math.abs(height) * -1;
                width = Math.abs(width) * -1;
                break;
            case SOUTHWEST:
                height = Math.abs(height);
                width = Math.abs(width) * -1;
                break;
        }


        if (reverseOrder){
            for(int x = startX; x < Math.floor(img.getHeight()/height) * height; x+= width){
                ArrayList<WritableImage> row = new ArrayList<>();
                for(int y = startY; y < Math.floor(img.getWidth()/width) * width; y+= height){
                    row.add(new WritableImage(w, x, y, width, height));
                }
                textures.add(row);
            }
        }
        else {
            for (int y = startY; y < Math.floor(img.getHeight() / height) * height; y += height) {
                ArrayList<WritableImage> row = new ArrayList<>();
                for (int x = startX; x < Math.floor(img.getWidth() / width) * width; x += width) {
                    row.add(new WritableImage(w, x, y, width, height));
                }
                textures.add(row);
            }
        }
        return textures;
    }
}
