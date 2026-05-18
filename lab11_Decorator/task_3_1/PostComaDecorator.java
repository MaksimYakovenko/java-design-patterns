public class PostComaDecorator extends StringDecorator {
    public PostComaDecorator(PrintableString wrapped) { super(wrapped); }
    @Override
    public void print() { wrapped.print(); System.out.print(","); }
    @Override
    public String getValue() { return wrapped.getValue() + ","; }
}
