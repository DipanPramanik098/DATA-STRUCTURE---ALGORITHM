package _01_Language_Basics;

public class _04_Switch_Case {

    enum Level { LOW, MEDIUM, HIGH }

    public static void main(String[] args) {

        System.out.println("===== TRADITIONAL SWITCH =====");

        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday");
                break;

            case 3:
                System.out.println("Wednesday");
                break;

            default:
                System.out.println("Invalid Day");
        }

        System.out.println("\n===== FALL THROUGH =====");

        int num = 2;

        switch (num) {
            case 1:
                System.out.println("One");
            case 2:
                System.out.println("Two");
            case 3:
                System.out.println("Three");
        }

        System.out.println("\n===== MULTIPLE CASES =====");

        char grade = 'B';

        switch (grade) {
            case 'A':
            case 'B':
            case 'C':
                System.out.println("Pass");
                break;
            default:
                System.out.println("Fail");
        }

        System.out.println("\n===== STRING SWITCH =====");

        String role = "Admin";

        switch (role) {
            case "Admin":
                System.out.println("Full Access");
                break;
            case "User":
                System.out.println("Limited Access");
                break;
            default:
                System.out.println("Guest");
        }

        System.out.println("\n===== ENUM SWITCH =====");

        Level level = Level.HIGH;

        switch (level) {
            case LOW:
                System.out.println("Low Level");
                break;
            case MEDIUM:
                System.out.println("Medium Level");
                break;
            case HIGH:
                System.out.println("High Level");
        }

        System.out.println("\n===== MODERN SWITCH EXPRESSION =====");

        int value = 2;

        String result = switch (value) {
            case 1 -> "One";
            case 2 -> "Two";
            default -> "Other";
        };

        System.out.println(result);
    }
}