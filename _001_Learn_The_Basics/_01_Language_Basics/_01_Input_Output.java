package _01_Language_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _01_Input_Output {
    public static void main(String[] args) throws IOException {
        // ================================
        // 1️⃣ OUTPUT METHODS
        // ================================

        System.out.println("=== OUTPUT DEMO ===");

        System.out.print("Using print() -> ");
        System.out.print("Hello ");
        System.out.println("World");

        System.out.println("Using println() -> Next line output");

        int a = 10;
        double b = 5.6789;

        System.out.printf("Using printf() -> a = %d, b = %.2f%n", a, b);

        // ================================
        // 2️⃣ INPUT USING SCANNER
        // ================================

        System.out.println("\n=== INPUT USING SCANNER ===");

        Scanner sc = new Scanner(System.in);

        // String input
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        // Integer input
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        // Double input
        System.out.print("Enter your CGPA: ");
        double cgpa = sc.nextDouble();

        sc.nextLine(); // consume leftover newline

        // Full line string input
        System.out.print("Enter your college name: ");
        String college = sc.nextLine();

        System.out.println("\n--- Scanner Output ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("CGPA: " + cgpa);
        System.out.println("College: " + college);

        // ================================
        // 3️⃣ INPUT USING BUFFEREDREADER
        // ================================

        System.out.println("\n=== INPUT USING BUFFEREDREADER ===");

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        // String input
        System.out.print("Enter city: ");
        String city = br.readLine();

        // Integer input (manual parsing required)
        System.out.print("Enter lucky number: ");
        int luckyNumber = Integer.parseInt(br.readLine());

        // Double input
        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(br.readLine());

        System.out.println("\n--- BufferedReader Output ---");
        System.out.println("City: " + city);
        System.out.println("Lucky Number: " + luckyNumber);
        System.out.println("Salary: " + salary);

        // ================================
        // 4️⃣ CLOSE RESOURCES
        // ================================

        sc.close();
        br.close();

        System.out.println("\n=== Program Finished Successfully ===");
    }
}
