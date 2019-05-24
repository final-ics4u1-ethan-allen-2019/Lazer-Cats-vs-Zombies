package game;

import engine.Draw;
import engine.Game;
import engine.Time;
import engine.input.MouseInput;
import engine.math.Vector2;
import engine.scripts.Script;

public class CharacterMovement extends Script {

    Vector2 velocity = new Vector2();

    boolean holding = false;

    double px, py;

    @Override
    public void update() {
        double x = parent.x;
        double y = parent.y;

        double hyp = Math.hypot(x-(MouseInput.x), y-(MouseInput.y));

        if ((hyp <= 20 && MouseInput.isPressed) || (holding && MouseInput.isPressed)) {
            velocity.x = 0;
            velocity.y = 0;

            parent.x = MouseInput.x;
            parent.y = MouseInput.y;
            holding = true;
        } else {
            if (holding) {
                velocity.x = (MouseInput.x - px) * 20;
                velocity.y = (MouseInput.y - py) * 20;
                holding = false;
            }
            velocity.y += 980 * Time.deltaTime;

            parent.x += velocity.x * Time.deltaTime;
            parent.y += velocity.y * Time.deltaTime;
        }

        px = MouseInput.x;
        py = MouseInput.y;
        if (parent.x-20 < 0) {
            velocity.x *= -0.9;
            parent.x = 20;
        } else if (parent.x+20 > Game.getWidth()) {
            velocity.x *= -0.9;
            parent.x = Game.getWidth()-20;
        }

        if (parent.y-20 < 0) {
            velocity.y *= -0.9;
            velocity.x *= 0.9;
            parent.y = 20;
        } else if (parent.y+20 > Game.getHeight()) {
            velocity.y *= -0.9;
            velocity.x *= 0.9;
            parent.y = Game.getHeight()-20;
        }
    }

    @Override
    public void render() {
        Draw.ellipse(parent.x-20, parent.y-20, 40, 40);
    }
}
