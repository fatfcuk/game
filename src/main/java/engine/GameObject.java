package engine;

/**
 * Created by fatfcuk on 17.01.17.
 */
public abstract class GameObject {

    //POSITION
    private float x;
    private float y;



 //   private Animation animation;

    public void update(){

        

    }

    public void render(){



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


}
