package engine;

import engine.input.KeyboardInput;
import engine.input.MouseInput;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class Game extends Application {

    private static Scene scene;
    private static Stage primaryStage;

    private static double width, height;
    private static String title;

    /**
     * Start the game.
     * @param args Launch arguments.
     * @param width Desired width of the window.
     * @param height Desired height of the window.
     * @param title Desired title of the window.
     */
    public void begin(String[] args, double width, double height, String title) {
        Game.width = width;
        Game.height = height;
        Game.title = title;

        this.load();

        launch(args);
    }

    /**
     * Start the game.
     * @param args Launch arguments.
     * @param width Desired width of the window.
     * @param height Desired height of the window.
     */
    public void begin(String[] args, double width, double height) {
        Game.width = width;
        Game.height = height;
        Game.title = "Allen Lu & Ethan Simms Engine";

        launch(args);
    }

    /**
     * Start the game.
     * @param args Launch arguments.
     * @param title Desired title of the window.
     */
    public void begin(String[] args, String title) {
        Game.width = 600;
        Game.height = 400;
        Game.title = title;

        launch(args);
    }

    /**
     * Start the game.
     * @param args Launch arguments.
     */
    public void begin(String[] args) {
        Game.width = 600;
        Game.height = 400;
        Game.title = "Allen Lu & Ethan Simms Engine";

        launch(args);
    }

    /**
     * Get the width of the window.
     * @return the width of the window.
     */
    public static double getWidth() {
        return width;
    }

    /**
     * Get the height of the window
     * @return the height of the window.
     */
    public static double getHeight() {
        return height;
    }

    public void load() {

    }

    @Override
    public void start(Stage primaryStage) {
        Game.primaryStage = primaryStage;
        Game.primaryStage.setTitle(title);

        Group root = new Group();

        Canvas canvas = new Canvas(width, height);
        root.getChildren().add(canvas);

        scene = new Scene(root);
        KeyboardInput keyboardInput = new KeyboardInput();
        scene.setOnKeyPressed(keyboardInput);
        scene.setOnKeyReleased(keyboardInput);
        MouseInput mouseInput = new MouseInput();
        scene.setOnMouseMoved(mouseInput);
        scene.setOnMouseDragged(mouseInput);
        scene.setOnMousePressed(mouseInput);
        scene.setOnMouseReleased(mouseInput);
        primaryStage.setScene(scene);

        Draw.init(canvas.getGraphicsContext2D());

        new GameLoop().start();

        primaryStage.setResizable(false);

        primaryStage.show();
    }

}
