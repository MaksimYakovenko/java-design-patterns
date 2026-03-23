public class Car {
    public enum CarColor {   // Колір автомобіля
        White,  //  Білий
        Black,  //  Чорний
        Red,    //  Червоний
        Grey    //  Сірий
    }

    public enum Type {  //  Тип кузову автомобіля
        Sedan,      //  Седан
        Hatchback,  //  Хетчбек
        SUV         //  Кросовер
    }

    final private Type type;                  //  Тип кузову
    final private CarColor carColor;          //  Колір
    final private Engine engine;              //  Двигун
    final private Transmission transmission;  //  Трансмісія
    final private Wheel wheel;                //  Колеса
    final private Tire tire;                  //  Шини

    public Car(Type type, CarColor carColor, Engine engine,
               Transmission transmission, Wheel wheel, Tire tire) {
        this.type = type;
        this.carColor = carColor;
        this.engine = engine;
        this.transmission = transmission;
        this.wheel = wheel;
        this.tire = tire;
    }

    @Override
    public String toString() {
        return "Car:\n" +
                "type=" + type +
                ",\ncarColor=" + carColor +
                ",\nengine=" + engine +
                ",\ntransmission=" + transmission +
                ",\nwheel=" + wheel +
                ",\ntire=" + tire +
                '\n';
    }
}

