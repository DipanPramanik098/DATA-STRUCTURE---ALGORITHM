package _01_Introduction_To_OOPs;

public class _04_BankAccount {
    // ==============================
    // Attributes (State of Object)
    // ==============================

    private String name;       // Account holder name
    private double balance;    // Account balance (private for security)


    // ==============================
    // Constructor
    // ==============================

    /*
     * Constructor initializes object state
     * Called automatically when object is created
     */
    public _04_BankAccount(String name, double balance) {
        this.name = name;

        // Validation: balance cannot be negative at creation
        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Set to 0.");
        }
    }


    // ==============================
    // Getter Methods (Read Access)
    // ==============================

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }


    // ==============================
    // Setter Method (Controlled Write Access)
    // ==============================

    public void setName(String name) {
        this.name = name;
    }


    // ==============================
    // Business Methods
    // ==============================

    // Deposit Method
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }

        balance += amount;
        System.out.println("Deposit successful. Updated Balance: " + balance);
    }


    // Withdrawal Method
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }

        balance -= amount;
        System.out.println("Withdrawal successful. Updated Balance: " + balance);
        return true;
    }
}
