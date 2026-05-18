public class ImageButton extends Button {
    private final String imagePath;
    public ImageButton(Size size, String imagePath) { super(size); this.imagePath = imagePath; }
    public void draw() {
        System.out.println("Setting size to " + size.getSizeName() + "...");
        System.out.println("Drawing an image button with image: " + imagePath + "\n");
    }
}
