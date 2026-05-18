public class PostSpaceDecorator extends StringDecorator {
    public PostSpaceDecorator(PrintableString wrapped) { super(wrapped); }
    @Override
    public void print() { wrapped.print(); System.out.print(" "); }
    @Override
    public String getValue() { return wrapped.getValue() + " "; }
}
