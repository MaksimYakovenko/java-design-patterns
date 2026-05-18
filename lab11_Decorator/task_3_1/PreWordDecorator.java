public class PreWordDecorator extends StringDecorator {
    private final String word;
    public PreWordDecorator(PrintableString wrapped, String word) {
        super(wrapped);
        this.word = word;
    }
    @Override
    public void print() { System.out.print(word); wrapped.print(); }
    @Override
    public String getValue() { return word + wrapped.getValue(); }
}
