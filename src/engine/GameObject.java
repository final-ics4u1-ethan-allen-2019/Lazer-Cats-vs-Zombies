package engine;

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
        for (Script script : scripts) {
            script.load();
        }
    }

    public void update() {
        for (Script script : scripts) {
            script.update();
        }
    }

    public void render() {
        for (Script script : scripts) {
            script.render();
        }
    }

    public ArrayList<Script> getScripts() {
        return scripts;
    }

    public void addScript(Script script) {
        script.setParent(this);
        scripts.add(script);
    }

}
