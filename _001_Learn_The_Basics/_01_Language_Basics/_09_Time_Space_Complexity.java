package _01_Language_Basics;

public class _09_Time_Space_Complexity {
    // O(n)
    public static void linearTime(int n) {
        for(int i = 0; i < n; i++) {
            System.out.println(i);
        }
    }

    // O(n²)
    public static void quadraticTime(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // O(log n)
    public static void logarithmicTime(int n) {
        while(n > 1) {
            n = n / 2;
            System.out.println(n);
        }
    }

    // O(n) space (recursion)
    public static int recursiveExample(int n) {
        if(n == 1) return 1;
        return recursiveExample(n - 1);
    }

    public static void main(String[] args) {

        System.out.println("Linear Time:");
        linearTime(5);

        System.out.println("\nQuadratic Time:");
        quadraticTime(3);

        System.out.println("\nLogarithmic Time:");
        logarithmicTime(16);

        System.out.println("\nRecursion Space:");
        recursiveExample(5);
    }
}
