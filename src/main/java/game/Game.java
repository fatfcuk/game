package game;

import engine.GameObject;
import gameobject.Player;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;

/**
 * Created by fatfcuk on 17.01.17.
 */
public class Game {


    private ArrayList<GameObject> gameObjects;

    private Player player;


    public Game() {

        gameObjects = new ArrayList<GameObject>();

        player = new Player(Display.getWidth() / 2 - Player.SIZE / 2, Display.getHeight() / 2 - Player.SIZE / 2);



        gameObjects.add(player);

    }

    public void getInput() {

        player.getInput();

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
