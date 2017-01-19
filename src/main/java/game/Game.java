package game;

import engine.GameObject;
import gameobject.Player;
import gameobject.Wall;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;

/**
 * Created by fatfcuk on 17.01.17.
 */
public class Game {


    private ArrayList<GameObject> gameObjects;

    private Player player;
    private Wall wall;


    public Game() {

        gameObjects = new ArrayList<GameObject>();

        player = new Player(Display.getWidth() / 2 - Player.SIZE / 2, Display.getHeight() / 2 - Player.SIZE / 2);
        wall = new Wall(30,30,15,213,22,50,100);


        gameObjects.add(player);
        gameObjects.add(wall);

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
