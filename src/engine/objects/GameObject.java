package engine.objects;

/*
    Project title: Lazer Cats vs Zombies
    -----------------------------------------------
    ClassName: Game Object
    -----------------------------------------------
    What it does: Game Object general class for inheritance
    -----------------------------------------------
    For: ICS4U1 - Holik
    -----------------------------------------------
    By: Ethan and Allen
    -----------------------------------------------
    Last Edited: June 18th 2019
 */
import engine.scripts.Script;

import java.util.ArrayList;

/** Game Object
 *
 * @see Script
 */
public class GameObject {

    protected ArrayList<Script> scripts = new ArrayList<>();
    /** x Location of the game object
     * y Location of the game object
     */
    public double x, y;

    /** Constructor
     *
     * @param scripts List of scripts to give game object
     * @param x x Location
     * @param y y Location
     */
    @Deprecated
    public GameObject(ArrayList<Script> scripts, double x, double y) {
        this.scripts = scripts;
        this.x = x;
        this.y = y;
    }

    /** Constructor
     *
     */
    public GameObject() {

    }

    /** Run the load function for each script
     *
     */
    public void load() {
        scripts.forEach(Script::load);
    }

    /** Run the update function for each script
     *
     */
    public void update() {
        scripts.forEach(Script::update);
    }

    /** Run the render function for each script
     *
     */
    public void render() {
        scripts.forEach(Script::render);
    }

    /** Run the lateRender function for each script
     *
     */
    public void lateRender() {
        scripts.forEach((Script::lateRender));
    }

    /** Gets the list of scripts
     *
     * @return the List of scripts
     */
    public ArrayList<Script> getScripts() {
        return scripts;
    }

    /** Add a script to the game object
     *
     * @param script Script you would like to add
     */
    public void addScript(Script script) {
        script.setParent(this);
        scripts.add(script);
    }

}
