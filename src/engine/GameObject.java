package engine;

import engine.scripts.Script;

import java.util.ArrayList;

public class GameObject {

    protected ArrayList<Script> scripts;
    public double x, y;

    public GameObject(ArrayList<Script> scripts, double x, double y) {
        this.scripts = scripts;
        this.x = x;
        this.y = y;
    }

    public GameObject() {
        scripts = new ArrayList<>();
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

    public void addScript(Script script) {
        scripts.add(script);
    }

}
