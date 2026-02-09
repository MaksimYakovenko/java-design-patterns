public abstract class Creator {
    public abstract Product createProduct();
    public void someOperation() {
        Product p = createProduct();
        p.doSomething();
    }
}

