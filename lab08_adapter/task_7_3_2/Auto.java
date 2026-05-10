public class Auto {
    public int age;
    public String model;
    public boolean damaged;
    public int mileage;

    public Auto(int age, String model, boolean damaged, int mileage) {
        this.age = age;
        this.model = model;
        this.damaged = damaged;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return String.format("Auto %s (age=%d, damaged=%b, mileage=%d)", model, age, damaged, mileage);
    }
}

