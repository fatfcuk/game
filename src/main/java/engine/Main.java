package engine;

import game.About;
import game.Game;
import game.MainMenu;
import game.Options;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by fatfcuk on 17.01.17.
 */
public class Main {

    public enum State {
        MAINMENU, GAME, OPTIONS,ABOUT
    }

    public static State gameState = State.MAINMENU;


    /**
     * STATES
     */
    private static Game game;
    private static MainMenu mainMenu;
    private static Options options;
    private static About about;


    public static void main(String args[]) {


        initDisplay();
        initGl();

        /**
         * INITIALIZING STATES
         */
        initStates();

        gameLoop();
        cleanUp();
    }


    private static void initDisplay() {


        try {

            Display.setDisplayMode(new DisplayMode(1960, 1080));
            Display.setFullscreen(true);

            Display.create();
            Display.setVSyncEnabled(true);
            Keyboard.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    private static void initGl() {

        glEnable(GL_TEXTURE_2D);
        glDisable(GL_DEPTH_TEST);
        glClearColor(0, 0, 0, 0);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glMatrixMode(GL_MODELVIEW);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
        glMatrixMode(GL_MODELVIEW);


    }


    private static void gameLoop() {

        while (!Display.isCloseRequested()) {

            getInput();
            update();
            render();


        }

    }

    private static void cleanUp() {

        Display.destroy();
        Keyboard.destroy();
    }

    private static void getInput() {

        switch (gameState) {
            case MAINMENU:
                mainMenu.getInput();
                break;
            case OPTIONS:
                options.getInput();
                break;
            case GAME:
                game.getInput();
                break;
            case ABOUT:
                about.getInput();
                break;
            default:
                break;
        }


    }

    private static void update() {

        switch (gameState) {
            case MAINMENU:
                mainMenu.update();
                break;
            case OPTIONS:
                options.update();
                break;
            case GAME:
                game.update();
                break;
            case ABOUT:
                about.update();
                break;
            default:
                break;
        }


    }

    private static void render() {

        glClear(GL_COLOR_BUFFER_BIT);
        glLoadIdentity();

        switch (gameState) {
            case MAINMENU:
                mainMenu.render();
                break;
            case OPTIONS:
                options.render();
                break;
            case GAME:
                game.render();
                break;
            case ABOUT:
                about.render();
                break;
            default:
                break;
        }

        Display.update();
        Display.sync(60);

    }

    private static void initGame() {

        game = new Game();


    }

    private static void initMainMenu() {

        mainMenu = new MainMenu();
    }

    private static void initOptions() {


        options = new Options();
    }

    private static void initAbout(){

        about = new About();
    }

    private static void initStates() {

        initMainMenu();
        initGame();
        initOptions();
        initAbout();

    }

}
