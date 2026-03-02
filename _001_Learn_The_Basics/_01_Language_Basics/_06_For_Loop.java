package _01_Language_Basics;

public class _06_For_Loop {

    public static void main(String[] args) {

        System.out.println("===== BASIC FOR LOOP =====");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("\n===== DECREMENT LOOP =====");

        for (int i = 5; i >= 1; i--) {
            System.out.println("i = " + i);
        }

        System.out.println("\n===== MULTIPLE VARIABLES =====");

        for (int i = 0, j = 5; i < 5; i++, j--) {
            System.out.println("i = " + i + ", j = " + j);
        }

        System.out.println("\n===== ENHANCED FOR LOOP =====");

        int[] arr = {10, 20, 30};

        for (int num : arr) {
            System.out.println(num);
        }

        System.out.println("\n===== NESTED LOOP =====");

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\n===== BREAK & CONTINUE =====");

        for (int i = 1; i <= 5; i++) {

            if (i == 3) {
                continue;
            }

            if (i == 5) {
                break;
            }

            System.out.println(i);
        }

        System.out.println("\n===== PROGRAM END =====");
    }
}