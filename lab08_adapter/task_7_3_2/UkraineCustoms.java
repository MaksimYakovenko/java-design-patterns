public class UkraineCustoms implements Customs {
    private static final float USD_TO_UAH = 36.5f; // приклад курсу

    @Override
    public float vehiclePrice(Auto a) {
        // Для автівки в UAH повертаємо приблизну оцінку (на основі простого правила)
        // Ми припустимо, що model містить тип (Car/Truck) — для демо використаємо просте оцінювання
        float baseUsd = a.model.toLowerCase().contains("truck") ? 40000f : 20000f;
        baseUsd -= a.age * 1000;
        baseUsd -= a.mileage * 0.05f;
        if (a.damaged) baseUsd *= 0.7f;
        baseUsd = Math.max(1000f, baseUsd);
        return baseUsd * USD_TO_UAH;
    }

    @Override
    public float tax(Auto a) {
        float price = vehiclePrice(a);
        // Просте правило: митний збір = 10% від ціни + фіксована плата 500 UAH
        return price * 0.1f + 500f;
    }
}

