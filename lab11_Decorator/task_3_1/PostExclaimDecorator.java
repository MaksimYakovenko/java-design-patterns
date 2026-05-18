public class PostExclaimDecorator extends StringDecorator {
    public PostExclaimDecorator(PrintableString wrapped) { super(wrapped); }
    @Override
    public void print() { wrapped.print(); System.out.print("!"); }
    @Override
    public String getValue() { return wrapped.getValue() + "!"; }
}
