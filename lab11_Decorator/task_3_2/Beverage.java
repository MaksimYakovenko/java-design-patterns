public abstract class Beverage {
    protected String description = "Unknown Beverage";
    public String description() { return description; }
    public abstract double cost();
    @Override
    public String toString() {
        return description() + " -> $" + String.format("%.2f", cost());
    }
}