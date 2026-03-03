package _03_Advance_OOPS_Feature;

/*
=========================================================
Practice (Inner Classes) – Medium
=========================================================

You are tasked with designing a Robot class to demonstrate
the functionality of different types of inner classes.

Requirements:

Class Robot:
    - Attribute: name (String)
    - Method: performAction()
        Prints: "<name> is performing an action."

Non-static Inner Class: Arm
    - Method: pickItem()
        Prints: "<name> arm picking an item."

Static Nested Class: Processor
    - Method: process()
        Prints: "Processor analyzing the data."

Local Inner Class:
    - Inside method manageSensors()
    - Local class Sensor
        - Method: sense()
          Prints: "<name> sensor detecting obstacles."

Anonymous Inner Class:
    - Interface Task
        - Method: execute()
    - Method executeTask()
        Uses anonymous inner class to override execute()
        Prints: "<name> executing a custom task"

Example Input:
name = "Robot-1"

Expected Output:

Robot-1 is performing an action.
Robot-1 arm picking an item.
Processor analyzing the data.
Robot-1 sensor detecting obstacles.
Robot-1 executing a custom task.
=========================================================
*/


public class _09_InnerClass_Problem {

    // =====================================================
    // Robot Class
    // =====================================================
    static class Robot {

        String name;

        // Constructor
        Robot(String name) {
            this.name = name;
        }

        // Method 1: performAction()
        void performAction() {
            System.out.println(name + " is performing an action.");
        }

        // =================================================
        // 1️⃣ Non-static Inner Class
        // =================================================
        /*
        - Requires outer object (Robot instance)
        - Can access outer class members directly
        */

        class Arm {

            void pickItem() {
                System.out.println(name + " arm picking an item.");
            }
        }


        // =================================================
        // 2️⃣ Static Nested Class
        // =================================================
        /*
        - Does NOT require Robot object
        - Cannot access non-static members directly
        */

        static class Processor {

            void process() {
                System.out.println("Processor analyzing the data.");
            }
        }


        // =================================================
        // 3️⃣ Local Inner Class
        // =================================================
        /*
        - Defined inside a method
        - Accessible only within that method
        */

        void manageSensors() {

            // Local Inner Class
            class Sensor {

                void sense() {
                    System.out.println(name + " sensor detecting obstacles.");
                }
            }

            // Creating object of local inner class
            Sensor sensor = new Sensor();
            sensor.sense();
        }


        // =================================================
        // 4️⃣ Anonymous Inner Class
        // =================================================

        // Interface
        interface Task {
            void execute();
        }

        void executeTask() {

            // Anonymous Inner Class Implementation
            Task task = new Task() {

                @Override
                public void execute() {
                    System.out.println(name + " executing a custom task.");
                }
            };

            task.execute();
        }
    }


    // =====================================================
    // Main Method
    // =====================================================
    public static void main(String[] args) {

        // Creating Robot object
        Robot robot = new Robot("Robot-1");

        // 1️⃣ performAction()
        robot.performAction();

        // 2️⃣ Non-static Inner Class
        Robot.Arm arm = robot.new Arm();
        arm.pickItem();

        // 3️⃣ Static Nested Class
        Robot.Processor processor = new Robot.Processor();
        processor.process();

        // 4️⃣ Local Inner Class
        robot.manageSensors();

        // 5️⃣ Anonymous Inner Class
        robot.executeTask();
    }
}