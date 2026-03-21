package _011_Bit_Manupulation._03_Contest;

public class _01_Count_Set_Cost {

    // Function to calculate cost of flipping all set bits
    public int setBitCost(int n, int k) {

        int count = 0;

        // Optimized way: count set bits using n & (n-1)
        while (n > 0) {
            n = n & (n - 1); // removes last set bit
            count++;
        }

        // Total cost = number of set bits * cost per flip
        return count * k;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        _01_Count_Set_Cost obj = new _01_Count_Set_Cost();

        int n1 = 9, k1 = 10;
        int n2 = 8, k2 = 5;

        System.out.println("Cost for n=9, k=10: " + obj.setBitCost(n1, k1)); // 20
        System.out.println("Cost for n=8, k=5: " + obj.setBitCost(n2, k2));  // 5
    }
}