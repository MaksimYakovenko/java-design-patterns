public abstract class Beverage {
    protected final int sugar;
    protected final ServingMethod servingMethod;
    public Beverage(int sugar, ServingMethod servingMethod) {
        this.sugar = sugar;
        this.servingMethod = servingMethod;
    }
    public abstract void prepare();
    public abstract void drink();
    public abstract int cost();
}