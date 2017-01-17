package engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by fatfcuk on 17.01.17.
 */
public class Main {

    private static Game game;


    public static void main(String args[]) {

        initDisplay();
        initGl();
        initGame();

        gameLoop();

        cleanUp();
    }

    private static void initDisplay() {


        try {
            Display.setDisplayMode(new DisplayMode(1280 , 720));
            Display.create();
            Display.setVSyncEnabled(true);
            Keyboard.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    private static void initGl() {

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glDisable(GL_DEPTH_TEST);

        glClearColor(0, 0, 0, 0);


    }

    private static void initGame(){

     game = new Game();


    }

    private static void gameLoop() {

        while(!Display.isCloseRequested()){

            getInput();
            update();
            render();


        }

    }

    private static void cleanUp(){

        Display.destroy();
        Keyboard.destroy();
    }

    private static void getInput(){

        game.getInput();

    }
    private static void update(){

        game.update();

    }

    private static void render(){

        glClear(GL_COLOR_BUFFER_BIT);
        glLoadIdentity();

        game.render();

        Display.update();
        Display.sync(100);

    }
}
