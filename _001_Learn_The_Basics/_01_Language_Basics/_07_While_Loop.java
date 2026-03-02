package _01_Language_Basics;

public class _07_While_Loop {

    public static void main(String[] args) {

        System.out.println("===== BASIC WHILE LOOP =====");

        int i = 1;

        while (i <= 5) {
            System.out.println("i = " + i);
            i++;
        }

        System.out.println("\n===== DECREMENT WHILE LOOP =====");

        int j = 5;

        while (j >= 1) {
            System.out.println("j = " + j);
            j--;
        }

        System.out.println("\n===== WHILE WITH BREAK =====");

        int k = 1;

        while (true) {

            if (k == 4)
                break;

            System.out.println("k = " + k);
            k++;
        }

        System.out.println("\n===== WHILE WITH CONTINUE =====");

        int x = 0;

        while (x < 5) {
            x++;

            if (x == 3)
                continue;

            System.out.println("x = " + x);
        }

        System.out.println("\n===== NESTED WHILE LOOP =====");

        int a = 1;

        while (a <= 3) {

            int b = 1;

            while (b <= 3) {
                System.out.print("* ");
                b++;
            }

            System.out.println();
            a++;
        }

        System.out.println("\n===== PROGRAM END =====");
    }
}