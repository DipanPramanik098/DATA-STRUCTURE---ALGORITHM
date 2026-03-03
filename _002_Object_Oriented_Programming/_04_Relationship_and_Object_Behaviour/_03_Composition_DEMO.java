package _04_Relationship_and_Object_Behaviour;

import java.util.*;

/*
 * COMPOSITION DEMO
 *
 * Composition is a strong form of Aggregation.
 *
 * It represents a strong "HAS-A" relationship.
 *
 * Key Properties:
 * 1. Whole–Part relationship.
 * 2. Part CANNOT exist independently.
 * 3. Whole creates the parts.
 * 4. Whole controls lifecycle of parts.
 * 5. Represented by Filled Diamond (◆) in UML.
 *
 * If Whole is destroyed → Parts are destroyed automatically.
 */

public class _03_Composition_DEMO {

    public static void main(String[] args) {

        System.out.println("===== HOUSE - ROOM (Composition) =====");

        House house = new House("Blue House", 3);
        house.showRooms();

        System.out.println("\n===== CAR - ENGINE (Composition) =====");

        Car car = new Car("Tesla");
        car.startCar();

        System.out.println("\n===== COMPUTER - CPU (Composition) =====");

        Computer computer = new Computer("Dell");
        computer.startComputer();
    }
}

/* ============================================================
   1️⃣ House ◆── Room
   Rooms cannot exist without House.
   House creates Rooms internally.
   ============================================================ */

class House {
    private String houseName;
    private List<Room> rooms = new ArrayList<>();

    // House creates its Rooms (strong ownership)
    public House(String houseName, int numberOfRooms) {
        this.houseName = houseName;

        for (int i = 1; i <= numberOfRooms; i++) {
            rooms.add(new Room("Room " + i));
        }
    }

    void showRooms() {
        System.out.println("House: " + houseName);
        for (Room r : rooms) {
            System.out.println(r.getRoomName());
        }
    }
}

class Room {
    private String roomName;

    // Constructor is package-private to restrict outside creation
    Room(String roomName) {
        this.roomName = roomName;
    }

    String getRoomName() {
        return roomName;
    }
}

/* ============================================================
   2️⃣ Car ◆── Engine
   Engine cannot exist independently of Car.
   Car creates Engine.
   ============================================================ */

class Car {
    private String brand;
    private Engine engine;   // Strong ownership

    public Car(String brand) {
        this.brand = brand;
        this.engine = new Engine("V8 Engine");
    }

    void startCar() {
        System.out.println("Car Brand: " + brand);
        engine.startEngine();
    }
}

class Engine {
    private String engineType;

    Engine(String engineType) {
        this.engineType = engineType;
    }

    void startEngine() {
        System.out.println(engineType + " started.");
    }
}

/* ============================================================
   3️⃣ Computer ◆── CPU
   CPU lifecycle depends on Computer.
   ============================================================ */

class Computer {
    private String brand;
    private CPU cpu;

    public Computer(String brand) {
        this.brand = brand;
        this.cpu = new CPU("Intel i7");
    }

    void startComputer() {
        System.out.println("Computer Brand: " + brand);
        cpu.process();
    }
}

class CPU {
    private String model;

    CPU(String model) {
        this.model = model;
    }

    void process() {
        System.out.println("CPU " + model + " is processing...");
    }
}