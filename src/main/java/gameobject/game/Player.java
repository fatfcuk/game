package gameobject.game;

import engine.GameObject;
import engine.Main;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;


import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.GL_MAX_LIGHTS;
import static org.lwjgl.opengl.GL11.glGetInteger;
import static org.lwjgl.opengl.GL11.glTranslatef;

/**
 * Created by fatfcuk on 17.01.17.
 */
public class Player extends GameObject {

    public static final float SIZE = 32;

    public static final float GRAVITY = 0.5f;
    public static final float SPEED = 4f;


    public Player(float x, float y) {

        /**
         * PLAYER IMAGE
         */
        init(x, y, SIZE, SIZE, "png", "resources/images/bahamut.png");





    }

    public void getInput() {


        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            move(0, 1);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            move(0, -1);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            move(-1, 0);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            move(1, 0);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {

            Keyboard.destroy();
            Display.destroy();
            System.exit(1);
        }
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


    }

    private void move(float magX, float magY) {

        x += getSpeed() * magX;
        y += getSpeed() * magY;


    }


    private float getSpeed() {

        return SPEED;

    }


    /**
     * Updating players values every frame. It can be used for updating player values onr server.
     */
    @Override
    public void update() {

        //  System.out.println("[X:"+getX()+"][Y:"+getY()+"]");
    }


    //MOVING 2d CAMERA
    @Override
    public void render() {




        glTranslatef(Display.getWidth() / 2 - (sprite.getTextureWidth() )/ 2, Display.getHeight() / 2 - (sprite.getTextureHeight()) / 2, 0);
        sprite.render();
        glTranslatef(-x, y, 0);
        System.out.println(sprite.getTextureWidth()+" : "+sprite.getTextureHeight());

    }


}


