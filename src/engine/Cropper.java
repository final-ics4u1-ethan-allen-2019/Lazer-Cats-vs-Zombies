package engine;

/*
    Project title: Lazer Cats vs Zombies
    -----------------------------------------------
    ClassName: Cropper
    -----------------------------------------------
    What it does: crops images for easy use
    -----------------------------------------------
    For: ICS4U1 - Holik
    -----------------------------------------------
    By: Ethan and Allen
    -----------------------------------------------
    Last Edited: June 18th 2019
 */
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

import java.util.ArrayList;

public class Cropper {

    private Image img;

    /**
     * directions
     */
    public enum directions {
        NORTHEAST,
        NORTHWEST,
        SOUTHEAST,
        SOUTHWEST,
    }

    /** Constructor with image
     *
     * @param img desired image
     */
    public Cropper(Image img) {
        this.img = img;
    }

    /** Sets image
     *
     * @param img desired image
     */
    public void setImg(WritableImage img) {
        this.img = img;
    }

    /** Crops and image and returns it
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @return
     */
    public WritableImage crop(int x, int y, int width, int height){
        PixelReader w = img.getPixelReader();
        WritableImage newImg = new WritableImage(w, x, y, width, height);
        return newImg;
    }

    /** Gets image
     *
     * @return image
     */
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

        //initializes the pixel reader
        PixelReader w = img.getPixelReader();

        //iterates through the rows
        for(int y = 0; y < Math.floor(img.getHeight()/height) * height; y+= height){
            ArrayList<WritableImage> row = new ArrayList<>();

            //iterates through image
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

        //edits parameters based on direction
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


        //Instead of doing it rows and then columns does columns and then rows
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
