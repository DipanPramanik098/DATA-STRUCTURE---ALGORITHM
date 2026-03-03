package _06_OOP_Design_AND_Lifecycle_Management;

// ISP Example

// Small, specific interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

// Human can work and eat
class Human implements Workable, Eatable {

    public void work() {
        System.out.println("Human working.");
    }

    public void eat() {
        System.out.println("Human eating.");
    }
}

// Robot only works
class Robot implements Workable {

    public void work() {
        System.out.println("Robot working.");
    }
}

public class _04_ISP {
    public static void main(String[] args) {

        Human human = new Human();
        Robot robot = new Robot();

        human.work();
        human.eat();

        robot.work();
    }
}