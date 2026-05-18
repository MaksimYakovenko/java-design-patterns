public class Main {
    public static void main(String[] args) {
        // 1. Espresso z dvoma porciyamy tsukru
        Beverage espresso = new Espresso();
        espresso = new Sugar(espresso);
        espresso = new Sugar(espresso);
        System.out.println("1. " + espresso);

        // 2. Chorna kava z vershkamy ta dvoma porciyamy tsukru
        Beverage darkRoast1 = new DarkRoast();
        darkRoast1 = new Whip(darkRoast1);
        darkRoast1 = new Sugar(darkRoast1);
        darkRoast1 = new Sugar(darkRoast1);
        System.out.println("2. " + darkRoast1);

        // 3. Chorna kava z kremom ta porciyeyu tsukru
        Beverage darkRoast2 = new DarkRoast();
        darkRoast2 = new Cream(darkRoast2);
        darkRoast2 = new Sugar(darkRoast2);
        System.out.println("3. " + darkRoast2);

        // 4. Kava bez kofeinu z molokom ta dvoma porciyamy tsukru
        Beverage decaf = new Decaf();
        decaf = new Milk(decaf);
        decaf = new Sugar(decaf);
        decaf = new Sugar(decaf);
        System.out.println("4. " + decaf);
    }
}