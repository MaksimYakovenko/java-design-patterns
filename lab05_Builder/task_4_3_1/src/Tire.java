public class Tire {
    public enum Season {
        Summer,     // Літня
        Winter,     // Зимова
        AllSeason   // Всесезонна
    }

    final private Season season;    // Сезонність
    final private int width;        // Ширина (мм)
    final private int profile;      // Висота профілю (%)
    final private int diameter;     // Діаметр (дюйми)

    public Tire(Season season, int width, int profile, int diameter) {
        this.season = season;
        this.width = width;
        this.profile = profile;
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Tire{" +
                "season=" + season +
                ", size=" + width + "/" + profile + "R" + diameter +
                '}';
    }
}
