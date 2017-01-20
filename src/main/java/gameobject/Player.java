package gameobject;

import engine.GameObject;
import engine.Sprite;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;


import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

/**
 * Created by fatfcuk on 17.01.17.
 */
public class Player extends GameObject {

    public static final float SIZE = 32;

    public static final float GRAVITY = 0.5f;
    public static final float SPEED = 4f;


    public Player(float x, float y) {

        init(x, y,  SIZE, SIZE,"jpg","resources/images/kitty.jpg");


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
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){

            jump();


        }


    }

    private void move(float magX, float magY) {

        x += getSpeed() * magX;
        y += getSpeed() * magY;


    }

    private void jump(){





    }

    private float getSpeed() {

        return SPEED;

    }


    //PLAYER POSITION UPDATE
    @Override
    public void update(){

      //  System.out.println("[X:"+getX()+"][Y:"+getY()+"]");
    }


    //MOVING 2d CAMERA
    @Override
    public void render() {

        glTranslatef(Display.getWidth()/2-Player.SIZE/2,Display.getHeight()/2-Player.SIZE/2,0);
        sprite.render();
        glTranslatef(-x, -y, 0);
    }



}


