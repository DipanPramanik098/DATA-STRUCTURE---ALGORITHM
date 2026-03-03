package _06_OOP_Design_AND_Lifecycle_Management;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Demonstrates proper resource handling

public class _11_Best_Practices_Object_Lifecycle {

    public static void main(String[] args) {

        // Try-with-resources ensures resource cleanup
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {

            System.out.println(br.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Resource automatically closed
    }
}