package game;

import engine.FontLoader;
import engine.GameObject;
import engine.Main;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.Font;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by ja on 22.01.2017.
 */
public class MainMenu {

    private ArrayList<GameObject> gameObjects;

    private TrueTypeFont font;


    public MainMenu() {


        gameObjects = new ArrayList<GameObject>();

        try{
            font = FontLoader.loadFontFromFile("resources/fonts/inktank.ttf",50f,true);
        }catch(Exception e){
            e.printStackTrace();
        }





    }

    public void getInput() {

        if(Keyboard.isKeyDown(Keyboard.KEY_1)){

            Main.gameState= Main.State.MAINMENU;

        }
        if(Keyboard.isKeyDown(Keyboard.KEY_2)){

            Main.gameState = Main.State.OPTIONS;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_3)){
            Main.gameState = Main.State.GAME;

        }
        if(Keyboard.isKeyDown((Keyboard.KEY_4))){

            Main.gameState = Main.State.ABOUT;
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){

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

        font.drawString(100,50,"PLAY", Color.white);
        font.drawString(100,150,"OPTIONS", Color.white);
        font.drawString(100,250,"ABOUT", Color.white);
        font.drawString(100,350,"EXIT", Color.white);


        for (GameObject g : gameObjects) {
            g.render();
        }

    }




}
