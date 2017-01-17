package engine;

/**
 * Created by fatfcuk on 17.01.17.
 */
public class Frame {

    //AMOUNT OF TIME THAT SUPOSED TO TAKE
    private int length;
    //IMAGES
    private Sprite sprite;
    //HOW MANY TIMES IT WAS DISPLAYED
    private int numDisplayed;


    public Frame(Sprite sprite, int length){
        this.sprite = sprite;
        this.length = length;

        numDisplayed = 0;

    }


    public boolean render() {

        sprite.render();
        numDisplayed++;

        if(numDisplayed>=length){
            numDisplayed=0;
            return true;

        }
        return false;

    }
}
