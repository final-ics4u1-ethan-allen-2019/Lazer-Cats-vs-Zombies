package engine.objects;

/*
    Project title: Lazer Cats vs Zombies
    -----------------------------------------------
    ClassName: Button
    -----------------------------------------------
    What it does: Button Class for canvas
    -----------------------------------------------
    For: ICS4U1 - Holik
    -----------------------------------------------
    By: Ethan and Allen
    -----------------------------------------------
    Last Edited: June 18th 2019
 */
import engine.Draw;
import engine.Time;
import engine.input.MouseInput;
import engine.math.Vector2;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Button extends GameObject {

    private Vector2 size;
    private Color color, pressed, hover;

    private Runnable onHover, onPress, onClick, onRelease;

    private boolean isHovering = false, isPressing = false;

    private double time;

    private String text;

    private double fontSize;

    public Button(Vector2 pos, Vector2 size, Color hover, Color pressed, Color color, String text) {
        super();
        this.size = size;
        this.x = pos.x;
        this.y = pos.y;

        this.hover = hover;
        this.pressed = pressed;
        this.color = color;
        this.text = text;
        fontSize = 10;
    }

    public Button(Vector2 pos, Vector2 size, Color hover, Color pressed, Color color, double fontSize, String text) {
        super();
        this.size = size;
        this.x = pos.x;
        this.y = pos.y;

        this.hover = hover;
        this.pressed = pressed;
        this.color = color;
        this.text = text;
        this.fontSize = fontSize;
    }

    public void setOnHover(Runnable runnable) {
        this.onHover = runnable;
    }

    public void setOnPress(Runnable runnable) {
        this.onPress = runnable;
    }

    public void setOnRelease(Runnable onRelease) {
        this.onRelease = onRelease;
    }

    public void setOnClick(Runnable runnable) {
        this.onClick = runnable;
    }

    @Override
    public void update() {
        if (MouseInput.x >= this.x && MouseInput.y >= this.y && MouseInput.x <= this.x+size.x && MouseInput.y <= this.y+size.y) {
            if (isHovering) {
                if (MouseInput.isPressed) {
                    if (isPressing) {
                        time += Time.deltaTime;
                    } else {
                        isPressing = true;
                        if (this.onPress != null) this.onPress.run();
                    }
                }
            } else {
                isHovering = true;
                if (this.onHover != null) this.onHover.run();
            }
        } else {
            isHovering = false;
        }
        if (!MouseInput.isPressed && isPressing) {
            isPressing = false;
            if (this.onRelease != null) this.onRelease.run();
            if (time <= 0.2 && this.onClick != null) this.onClick.run();
            time = 0;
        }
    }

    @Override
    public void render() {
        if (isPressing) {
            Draw.setFill(pressed);
        } else if (isHovering) {
            Draw.setFill(hover);
        } else {
            Draw.setFill(color);
        }

        Draw.rect(this.x, this.y, size.x, size.y, true);

        Draw.setFill(Color.BLACK);

        Draw.setFont(new Font(fontSize));
        Draw.drawText(text, (x + (size.x / 2)) - (Draw.textSize(text) / 2), (y + (size.y / 1.5)), true);
    }

}
