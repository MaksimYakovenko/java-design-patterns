public class Espresso extends Beverage {
    public Espresso() {
        super("Еспресо", 15.0, 35.0);
    }

    @Override
    public String getDescription() {
        return "Міцна кава з насиченим смаком. Компоненти: кавові зерна (7г), вода (30мл)";
    }
}

