package game;

import engine.GameObject;
import engine.Main;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;

/**
 * Created by ja on 22.01.2017.
 */
public class Options {

    private ArrayList<GameObject> gameObjects;

    public Options() {


        gameObjects = new ArrayList<GameObject>();
    }

    public void getInput() {

        if (Keyboard.isKeyDown(Keyboard.KEY_1)) {
            Main.gameState = Main.State.MAINMENU;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_2)) {
            Main.gameState = Main.State.OPTIONS;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_3)) {
            Main.gameState = Main.State.GAME;
        }
        if (Keyboard.isKeyDown((Keyboard.KEY_4))) {
            Main.gameState = Main.State.ABOUT;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            Keyboard.destroy();
            Display.destroy();
            System.exit(1);
        }
    }

    public void update() {

        for (GameObject g : gameObjects) {
            g.update();
        }

    }

    public void render() {

        for (GameObject g : gameObjects) {
            g.render();
        }

    }
}
