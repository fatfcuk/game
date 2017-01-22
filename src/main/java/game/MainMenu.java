package game;

import engine.FontLoader;
import engine.GameObject;
import engine.Main;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.Font;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by ja on 22.01.2017.
 */
public class MainMenu {

    private ArrayList<GameObject> gameObjects;


    private TrueTypeFont font;


    public MainMenu() {


        gameObjects = new ArrayList<GameObject>();

        try {
            font = FontLoader.loadFontFromFile("resources/fonts/inktank.ttf", 50f, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

        glScalef(2f, 2f, 0f);


        font.drawString(150, 100, "PLAY", Color.white);
        font.drawString(150, 200, "OPTIONS", Color.white);
        font.drawString(150, 300, "ABOUT", Color.white);
        font.drawString(150, 400, "EXIT", Color.white);


        for (GameObject g : gameObjects) {
            g.render();
        }

    }


}
