public class Tire implements Cloneable {
    private String brand; // Бренд гуми
    private String season; // Сезон (літня, зимова, всесезонна)
    private String size; // Розмір (наприклад, 205/55R16)

    public Tire(String brand, String season, String size) {
        this.brand = brand;
        this.season = season;
        this.size = size;
    }

    @Override
    public Tire clone() {
        try {
            return (Tire) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return String.format("Tire{brand='%s', season='%s', size='%s'}", brand, season, size);
    }

    // Getters
    public String getBrand() { return brand; }
    public String getSeason() { return season; }
    public String getSize() { return size; }

    // Setters
    public void setBrand(String brand) { this.brand = brand; }
    public void setSeason(String season) { this.season = season; }
    public void setSize(String size) { this.size = size; }
}

