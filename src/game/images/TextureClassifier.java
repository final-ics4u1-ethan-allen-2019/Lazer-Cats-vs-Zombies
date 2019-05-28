package game.images;

import engine.Cropper;

public class TextureClassifier {

    private Cropper cropper;

    //Make different enums for different categories of images
    public enum stills {

        GOTTEM (0, "game/images/GOTCHA.jpg"),
        CATE (0, "game/images/CATE.jpg");

        private final int id;
        private final String url;
        stills(int id, String url){
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

    public static stills[] getTextureList(){
        return stills.values();
    }
}
