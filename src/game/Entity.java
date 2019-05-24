package game;

import engine.Draw;
import engine.GameObject;
import engine.input.MouseInput;

public class Entity extends GameObject {

    @Override
    public void render() {
        Draw.rect(MouseInput.x-5, MouseInput.y-5, 10, 10);
    }
}
