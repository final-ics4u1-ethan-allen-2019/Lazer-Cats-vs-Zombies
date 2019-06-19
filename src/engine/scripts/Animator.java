package engine.scripts;

import engine.Time;
import javafx.scene.image.Image;

import java.util.ArrayList;

/** Animator
 *
 * Animates the sprite renderer
 * @see Script
 */
public class Animator extends Script {

    private ArrayList<Image>[] images;

    private SpriteRenderer renderer;

    private double change;
    private double last;

    private int current;
    private int state;

    /** Set whether animator is enabled or not
     *
     */
    public boolean enabled = true;

    private boolean loop = true;

    /** Constructor
     *
     * @param images Array of Lists of images to animator each array list in the array corresponds to the state
     * @param change How fast or slow you want to animate
     * @param renderer The connected spriterender you with to animate
     */
    public Animator(ArrayList<Image>[] images, double change, SpriteRenderer renderer) {
        this.images = images;

        this.change = change;

        this.renderer = renderer;
    }

    /** Called by GameObject
     * @see engine.objects.GameObject
     */
    @Override
    public void update() {
        if (renderer != null && images != null && enabled) {
            last += Time.deltaTime;
            if (last >= change) {
                current++;
                if (current >= images[state].size()) {
                    current = images[state].size()-1;
                    if (!loop) enabled = false;
                    else current = 0;
                }
                renderer.setImage(images[state].get(current));
                last = 0;
            }
        }
    }

    /** Sets if animator is looping
     *
     * @param loop looping or not
     */
    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    /** Sets current state of animator
     *
     * @param state the state
     */
    public void setState(int state) {
        this.state = state;
    }

    /** Sets the current image
     *
     * @param current current image
     */
    public void setCurrent(int current) {
        this.current = current;
    }

    /** Gets the current image
     *
     * @return current image
     */
    public int getCurrent() {
        return this.current;
    }

    /** Gets the current state
     *
     * @return the current state
     */
    public int getState() {
        return this.state;
    }

    /** Sets the image set
     *
     * @param images Image set
     */
    public void setImages(ArrayList<Image>[] images) {
        this.images = images;
        if (this.renderer != null) this.renderer.setImage(null);
    }

    /** Gets the image set
     *
     * @return the image set
     */
    public ArrayList<Image>[] getImages() {
        return images;
    }
}
