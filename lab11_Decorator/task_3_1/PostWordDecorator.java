public class PostWordDecorator extends StringDecorator {
    private final String word;
    public PostWordDecorator(PrintableString wrapped, String word) {
        super(wrapped);
        this.word = word;
    }
    @Override
    public void print() { wrapped.print(); System.out.print(word); }
    @Override
    public String getValue() { return wrapped.getValue() + word; }
}
