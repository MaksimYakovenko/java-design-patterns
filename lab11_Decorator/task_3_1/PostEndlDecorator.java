public class PostEndlDecorator extends StringDecorator {
    public PostEndlDecorator(PrintableString wrapped) { super(wrapped); }
    @Override
    public void print() { wrapped.print(); System.out.print("\n"); }
    @Override
    public String getValue() { return wrapped.getValue() + "\n"; }
}
