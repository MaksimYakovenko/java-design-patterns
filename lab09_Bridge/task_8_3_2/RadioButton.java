public class RadioButton extends Button {
    public RadioButton(Size size) { super(size); }
    public void draw() {
        System.out.println("Setting size to " + size.getSizeName() + "...");
        System.out.println("Drawing a radio button.\n");
    }
}
