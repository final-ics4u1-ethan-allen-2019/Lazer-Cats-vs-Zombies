package game.images;

public class TextureClassifier {

    public enum textures{

        GOTTEM (0, "game/images/GOTCHA.jpg");


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
