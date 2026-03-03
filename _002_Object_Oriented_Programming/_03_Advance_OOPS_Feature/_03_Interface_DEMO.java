package _03_Advance_OOPS_Feature;

// 🔹 First Interface
interface Vehicle {

    // 🔸 Constant (public static final by default)
    int MAX_SPEED = 120;

    // 🔸 Abstract Method (public abstract by default)
    void start();

    // 🔸 Default Method (Java 8)
    default void fuelType() {
        System.out.println("Vehicle uses general fuel.");
    }

    // 🔸 Static Method (Java 8)
    static void vehicleInfo() {
        System.out.println("Vehicles are used for transportation.");
    }

    // 🔸 Private Method (Java 9)
    private void internalCheck() {
        System.out.println("Performing internal vehicle check...");
    }

    // Default method using private method
    default void service() {
        internalCheck();
        System.out.println("Vehicle servicing completed.");
    }
}


// 🔹 Second Interface
interface Electric {

    void charge();

    // Default method
    default void fuelType() {
        System.out.println("Vehicle uses electricity.");
    }
}


// 🔹 Class implementing multiple interfaces
public class _03_Interface_DEMO implements Vehicle, Electric {

    String name;

    _03_Interface_DEMO(String name) {
        this.name = name;
    }

    // Implementing abstract method from Vehicle
    @Override
    public void start() {
        System.out.println(name + " is starting...");
    }

    // Implementing abstract method from Electric
    @Override
    public void charge() {
        System.out.println(name + " is charging...");
    }

    // 🔥 Diamond Problem Resolution
    // Both Vehicle and Electric have fuelType() default method
    // So we MUST override it
    @Override
    public void fuelType() {
        System.out.println(name + " is an electric vehicle.");
        
        // Accessing specific interface default method
        Vehicle.super.fuelType();
        Electric.super.fuelType();
    }

    public static void main(String[] args) {

        _03_Interface_DEMO car = new _03_Interface_DEMO("Tesla");

        car.start();
        car.charge();
        car.fuelType();
        car.service();

        // Accessing constant
        System.out.println("Max Speed: " + Vehicle.MAX_SPEED);

        // Calling static method (must use interface name)
        Vehicle.vehicleInfo();
    }
}