package engine;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import static org.lwjgl.opengl.GL11.*;

public class Sprite {

    private Texture texture;


    private float sx;
    private float sy;
    private String extension;
    private String path;


    /**
     *
     * @param sx
     * @param sy
     * @param extension
     * @param path
     */
    public Sprite(float sx, float sy, String extension, String path) {

        this.sx = sx;
        this.sy = sy;
        this.extension = extension;
        this.path = path;
    }


    public void render() {

        try {
            initTexture();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        Color.white.bind();
        texture.bind();
        glBegin(GL_QUADS);


        glTexCoord2f(0, 0);
        glVertex2f(0, 0);
        glTexCoord2f(0, 1);
        glVertex2f(0, texture.getTextureHeight());
        glTexCoord2f(1, 1);
        glVertex2f(texture.getTextureWidth(), texture.getTextureHeight());
        glTexCoord2f(1, 0);
        glVertex2f(texture.getTextureWidth(), 0);

            texture.release();
        glEnd();


    }

    public float getSx() {
        return sx;
    }

    public void setSx(float sx) {
        this.sx = sx;
    }

    public float getSy() {
        return sy;
    }

    public void setSy(float sy) {
        this.sy = sy;
    }

    public void initTexture() throws Exception {

        texture = TextureLoader.getTexture(extension, ResourceLoader.getResourceAsStream(path));

    }
}
