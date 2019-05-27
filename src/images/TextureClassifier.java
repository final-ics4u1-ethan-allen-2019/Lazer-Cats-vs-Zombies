package images;

import java.net.URL;
import java.util.ArrayList;

public class TextureClassifier {

    public enum textures{

        GOTTEM (0, "images/GOTCHA.jpg");


        private final int id;
        private final String url;
        textures(int id, String url){
            this.id = id;
            this.url = url;
        }

        public String getUrl(){
            return this.url;
        }
        public String getId(){
            return this.url;
        }
    }

    public static textures[] getTextureList(){
        return textures.values();
    }
}
