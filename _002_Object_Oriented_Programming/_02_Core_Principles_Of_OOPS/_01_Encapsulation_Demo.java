package _02_Core_Principles_Of_OOPS;

/*
=========================================================

Concepts Covered:
1. Private data members (Data Hiding)
2. Public getter methods
3. Controlled modification using methods
4. Validation logic inside methods
5. Preventing invalid object state

Encapsulation ensures:
- Internal data cannot be accessed directly
- All modifications happen through controlled methods
=========================================================
*/

class BankAccount {

    // ==============================
    // Private Attributes (Hidden Data)
    // ==============================

    private String accountHolder;
    private double balance;

    // ==============================
    // Constructor
    // ==============================

    public BankAccount(String accountHolder, double initialBalance) {

        this.accountHolder = accountHolder;

        // Validation to maintain valid state
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Set to 0.");
        }
    }

    // ==============================
    // Getter Method (Read Access)
    // ==============================

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    // ==============================
    // Controlled Modification Methods
    // ==============================

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }

        balance += amount;
        System.out.println("Deposit Successful. Updated Balance: " + balance);
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawal Successful. Updated Balance: " + balance);
    }
}

public class _01_Encapsulation_Demo {

    public static void main(String[] args) {

        // Creating object
        BankAccount account = new BankAccount("Dipan", 5000);

        // Accessing data via getter (Allowed)
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Initial Balance: " + account.getBalance());

        System.out.println();

        // Valid deposit
        account.deposit(2000);

        // Invalid deposit
        account.deposit(-500);

        System.out.println();

        // Valid withdrawal
        account.withdraw(3000);

        // Invalid withdrawal
        account.withdraw(10000);

        System.out.println();

        // Final Balance
        System.out.println("Final Balance: " + account.getBalance());

        /*
        IMPORTANT:
        The following line would cause compilation error
        because balance is private:

        account.balance = 100000;  // ❌ Not Allowed

        This proves encapsulation.
        */
    }
}
