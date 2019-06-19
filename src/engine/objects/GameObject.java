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

public class GameObject {

    protected ArrayList<Script> scripts = new ArrayList<>();
    public double x, y;

    public GameObject(ArrayList<Script> scripts, double x, double y) {
        this.scripts = scripts;
        this.x = x;
        this.y = y;
    }

    public GameObject() {

    }

    public void load() {
        scripts.forEach(Script::load);
    }

    public void update() {
        scripts.forEach(Script::update);
    }

    public void render() {
        scripts.forEach(Script::render);
    }

    public void lateRender() {
        scripts.forEach((Script::lateRender));
    }

    public ArrayList<Script> getScripts() {
        return scripts;
    }

    public void addScript(Script script) {
        script.setParent(this);
        scripts.add(script);
    }

}
