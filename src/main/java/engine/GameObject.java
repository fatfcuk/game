package engine;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by fatfcuk on 17.01.17.
 */
public abstract class GameObject {

    //POSITION
    protected float x;
    protected float y;

    protected Sprite sprite;



    public void update() {


    }

    public void render() {

        glPushMatrix();
        glTranslatef(x, y, 0);
        sprite.render();
        glPopMatrix();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSx(){
        return sprite.getSx();
    }
    public float getSy(){
        return sprite.getSy();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    protected void init(float x,float y,float sx, float sy,String extension, String path){

        this.x = x;
        this.y = y;
        this.sprite = new Sprite(sx,sy,extension,path);



    }
}
