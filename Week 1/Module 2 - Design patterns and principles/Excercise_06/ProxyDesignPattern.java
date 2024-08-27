public class ProxyDesignPattern {

    // Subject Interface
    public interface Graphic {
        void show();
    }

    // Real Subject Class
    public static class ActualImage implements Graphic {
        private String file;

        public ActualImage(String file) {
            this.file = file;
            loadImage();
        }

        private void loadImage() {
            System.out.println("Loading image: " + file);
        }

        @Override
        public void show() {
            System.out.println("Showing image: " + file);
        }
    }

    // Proxy Class
    public static class ImageProxy implements Graphic {
        private ActualImage actualImage;
        private String file;

        public ImageProxy(String file) {
            this.file = file;
        }

        @Override
        public void show() {
            if (actualImage == null) {
                actualImage = new ActualImage(file);
            }
            actualImage.show();
        }
    }

    // Test the Proxy Implementation
    public static void main(String[] args) {
        Graphic img1 = new ImageProxy("picture1.png");
        Graphic img2 = new ImageProxy("picture2.png");

        // Image will be loaded from disk
        img1.show();
        System.out.println("");

        // Image will not be loaded from disk
        img1.show();
        System.out.println("");

        // Image will be loaded from disk
        img2.show();
        System.out.println("");

        // Image will not be loaded from disk
        img2.show();
    }
}
