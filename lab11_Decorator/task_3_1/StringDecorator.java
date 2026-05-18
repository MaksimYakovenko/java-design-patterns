public abstract class StringDecorator extends PrintableString {
    protected PrintableString wrapped;
    public StringDecorator(PrintableString wrapped) {
        super(wrapped.getValue());
        this.wrapped = wrapped;
    }
    @Override
    public abstract void print();
}
