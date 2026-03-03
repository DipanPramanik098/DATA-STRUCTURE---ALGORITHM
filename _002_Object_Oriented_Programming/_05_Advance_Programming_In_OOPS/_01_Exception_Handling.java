public class _01_Exception_Handling {

    // =========================
    // 1. Custom Checked Exception
    // =========================
    static class CustomCheckedException extends Exception {
        public CustomCheckedException(String message) {
            super(message);
        }
    }

    // =========================
    // 2. Custom Unchecked Exception
    // =========================
    static class CustomUncheckedException extends RuntimeException {
        public CustomUncheckedException(String message) {
            super(message);
        }
    }

    // =========================
    // 3. Method with throws (Checked Exception)
    // =========================
    static void checkedMethod() throws CustomCheckedException {
        throw new CustomCheckedException("This is a checked exception.");
    }

    // =========================
    // 4. Method throwing unchecked exception
    // =========================
    static void uncheckedMethod() {
        throw new CustomUncheckedException("This is an unchecked exception.");
    }

    // =========================
    // 5. Exception Propagation
    // =========================
    static void method1() {
        int x = 10 / 0;  // ArithmeticException
    }

    static void method2() {
        method1();  // propagates to caller
    }

    // =========================
    // MAIN METHOD
    // =========================
    public static void main(String[] args) {

        System.out.println("===== 1. Basic try-catch =====");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Handled ArithmeticException: " + e);
        }

        System.out.println("\n===== 2. Multiple catch =====");
        try {
            int[] arr = new int[3];
            arr[5] = 100;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error");
        } catch (Exception e) {
            System.out.println("General exception");
        }

        System.out.println("\n===== 3. finally block =====");
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled");
        } finally {
            System.out.println("Finally block executed");
        }

        System.out.println("\n===== 4. throw keyword =====");
        try {
            int age = 16;
            if (age < 18) {
                throw new ArithmeticException("Not eligible to vote");
            }
        } catch (ArithmeticException e) {
            System.out.println("Thrown manually: " + e.getMessage());
        }

        System.out.println("\n===== 5. throws keyword =====");
        try {
            checkedMethod();
        } catch (CustomCheckedException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        System.out.println("\n===== 6. Unchecked Exception =====");
        try {
            uncheckedMethod();
        } catch (CustomUncheckedException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }

        System.out.println("\n===== 7. Exception Propagation =====");
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Exception propagated and caught in main");
        }

        System.out.println("\n===== 8. Nested try-catch =====");
        try {
            try {
                int num = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Inner catch block");
            }
        } catch (Exception e) {
            System.out.println("Outer catch block");
        }

        System.out.println("\n===== 9. try-with-resources =====");
        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
            System.out.println("Scanner resource opened and will auto-close.");
        } catch (Exception e) {
            System.out.println("Resource exception");
        }

        System.out.println("\nProgram continues normally...");
    }
}