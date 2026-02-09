public class ConcreteCreator2 extends Creator {
    @Override
    public Product createProduct() {
        return new Product2();
    }
}

