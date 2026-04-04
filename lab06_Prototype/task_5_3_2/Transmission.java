public class Transmission implements Cloneable {

}
    public void setGearCount(int gearCount) { this.gearCount = gearCount; }
    public void setType(String type) { this.type = type; }
    // Setters

    public int getGearCount() { return gearCount; }
    public String getType() { return type; }
    // Getters

    }
        return String.format("Transmission{type='%s', gearCount=%d}", type, gearCount);
    public String toString() {
    @Override

    }
        }
            throw new AssertionError("Cloning not supported", e);
        } catch (CloneNotSupportedException e) {
            return (Transmission) super.clone();
        try {
    public Transmission clone() {
    @Override

    }
        this.gearCount = gearCount;
        this.type = type;
    public Transmission(String type, int gearCount) {

    private int gearCount; // Кількість передач
    private String type; // Механічна (manual) або автоматична (automatic)
