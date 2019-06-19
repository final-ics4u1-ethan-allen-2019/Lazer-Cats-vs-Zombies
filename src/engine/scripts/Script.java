package engine.scripts;

import engine.objects.GameObject;

/** Script
 * Allows for manipulating of parent game object
 */
public class Script {

    protected GameObject parent;

    /** Constructor
     *
     */
    public Script() {

    }

    /** Sets the parent object
     *
     * @param parent the parent object
     */
    public void setParent(GameObject parent) {
        this.parent = parent;
    }

    /** Load images and stuff like that here
     *
     */
    public void load() {

    }

    /** Draw stuff here
     *
     */
    public void render() {

    }

    /** Do any movement and non draw code here
     *
     */
    public void update() {

    }

    /** Used to draw UI mainly
     *
     */
    public void lateRender() {

    }

}
