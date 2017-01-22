package engine;

import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.TrueTypeFont;

import java.io.InputStream;
import java.awt.Font;

/**
 * Created by Jędrzej "fatfcuk" Sieja on 22.01.2017.
 */
public class FontLoader {

    public FontLoader() {

    }

    public static TrueTypeFont loadFontFromFile(String path, float size, boolean antiAlias) throws Exception {

        InputStream inputStream = ResourceLoader.getResourceAsStream(path);
        Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        awtFont = awtFont.deriveFont(size);

        System.out.println("Loaded font: "+path);
        return new TrueTypeFont(awtFont, antiAlias);
    }
}
