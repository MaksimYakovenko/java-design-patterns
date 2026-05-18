public class CheckboxButton extends Button {
    public CheckboxButton(Size size) { super(size); }
    public void draw() {
        System.out.println("Setting size to " + size.getSizeName() + "...");
        System.out.println("Drawing a checkbox button.\n");
    }
}
