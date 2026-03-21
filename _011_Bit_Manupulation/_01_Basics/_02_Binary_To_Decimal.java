package _011_Bit_Manupulation._01_Basics;

public class _02_Binary_To_Decimal {

    public static int binaryToDecimal(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            res = res * 2 + (s.charAt(i) - '0');
        }

        return res;
    }

    public static void main(String[] args) {
        String binary = "1010";
        int decimal = binaryToDecimal(binary);
        System.out.println("Decimal of " + binary + " is: " + decimal);
    }
}