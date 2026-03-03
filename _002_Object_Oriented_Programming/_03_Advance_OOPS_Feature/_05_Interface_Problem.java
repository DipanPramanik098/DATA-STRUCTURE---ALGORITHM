package _03_Advance_OOPS_Feature;

/*
Practice (Interfaces) – Medium

You are required to design an interface PaymentGateway that defines
a common method for processing payments.

Interface:
PaymentGateway
    - Abstract Method:
        processPayment(double amount)

Implementing Classes:

1) CreditCardPayment
    - processPayment(double amount)
      Prints:
      "Processing credit card payment of amount"

2) UPIPayment
    - processPayment(double amount)
      Prints:
      "Processing UPI payment of amount"

Use Polymorphism to process different payment methods
through the same interface reference.

Example:
Input:
paymentMethod = ["credit", "upi"]
paymentValue  = [284.5, 27476.2]

Output:
Processing credit card payment of 284.50
Processing UPI payment of 27476.20
*/


// 🔹 Interface
interface PaymentGateway {

    // Abstract method (public abstract by default)
    void processPayment(double amount);
}


// 🔹 Credit Card Implementation
class CreditCardPayment implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.printf("Processing credit card payment of %.2f%n", amount);
    }
}


// 🔹 UPI Implementation
class UPIPayment implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.printf("Processing UPI payment of %.2f%n", amount);
    }
}


// 🔹 Main Class
public class _05_Interface_Problem {

    public static void main(String[] args) {

        // Simulated Input
        String[] paymentMethod = {"credit", "upi"};
        double[] paymentValue = {284.5, 27476.2};

        // Iterating using Polymorphism
        for (int i = 0; i < paymentMethod.length; i++) {

            PaymentGateway payment;   // Interface reference

            if (paymentMethod[i].equalsIgnoreCase("credit")) {
                payment = new CreditCardPayment();
            } 
            else if (paymentMethod[i].equalsIgnoreCase("upi")) {
                payment = new UPIPayment();
            } 
            else {
                continue; // Skip invalid method
            }

            // Runtime Polymorphism
            payment.processPayment(paymentValue[i]);
        }
    }
}