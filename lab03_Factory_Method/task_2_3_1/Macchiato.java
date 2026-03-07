public class Macchiato extends Beverage {
    public Macchiato() {
        super("Макіато", 20.0, 45.0);
    }

    @Override
    public String getDescription() {
        return "Еспресо з невеликою кількістю молока. Компоненти: кавові зерна (7г), молоко (30мл), вода (30мл)";
    }
}

