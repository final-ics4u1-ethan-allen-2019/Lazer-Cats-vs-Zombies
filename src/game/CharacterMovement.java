package game;

import engine.Draw;
import engine.Time;
import engine.input.MouseInput;
import engine.scripts.Script;

public class CharacterMovement extends Script {

    @Override
    public void update() {
        double hyp = Math.hypot(parent.x-MouseInput.x, parent.y-MouseInput.y);
        parent.x -= ((parent.x - MouseInput.x) / hyp) * 100 * Time.deltaTime;
        parent.y -= ((parent.y - MouseInput.y) / hyp) * 100 * Time.deltaTime;
//        parent.x = MouseInput.x;
//        parent.y = MouseInput.y;
    }

    @Override
    public void render() {
        Draw.rect(parent.x-5, parent.y-5, 10, 10);
    }
}
