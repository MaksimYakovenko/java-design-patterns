public class Latte extends Beverage {
    public Latte() {
        super("Латте", 25.0, 55.0);
    }

    @Override
    public String getDescription() {
        return "М'яка кава з великою кількістю молока. Компоненти: кавові зерна (7г), молоко (150мл), вода (30мл)";
    }
}

