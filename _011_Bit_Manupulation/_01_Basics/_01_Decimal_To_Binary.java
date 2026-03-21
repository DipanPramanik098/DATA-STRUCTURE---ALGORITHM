package _011_Bit_Manupulation._01_Basics;

public class _01_Decimal_To_Binary {

    public static String decimalToBinary(int n) {
        if (n == 0) return "0";

        StringBuilder res = new StringBuilder();

        while (n > 0) {
            res.append(n % 2);
            n /= 2;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        int num = 10;
        String binary = decimalToBinary(num);
        System.out.println("Binary of " + num + " is: " + binary);
    }
}