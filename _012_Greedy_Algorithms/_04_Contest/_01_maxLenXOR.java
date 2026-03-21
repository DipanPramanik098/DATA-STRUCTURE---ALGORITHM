package _012_Greedy_Algorithms._04_Contest;

public class _01_maxLenXOR {

    // Function to find maximum length substring with maximum XOR
    public int maxLenXOR(String s) {

        int n = s.length();
        int onesCount = 0;

        int firstOne = -1;
        int lastOne = -1;

        // Count 1s and find first/last occurrence of '1'
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                onesCount++;

                if (firstOne == -1) {
                    firstOne = i;
                }
                lastOne = i;
            }
        }

        // If no '1' exists, maximum XOR is 0,
        // and whole string gives that maximum XOR
        if (onesCount == 0) {
            return n;
        }

        // If total 1s are odd, whole string has XOR = 1
        if ((onesCount & 1) == 1) {
            return n;
        }

        // Total 1s are even:
        // remove smallest prefix till first '1'
        int option1 = n - firstOne - 1;

        // remove smallest suffix from last '1'
        int option2 = lastOne;

        return Math.max(option1, option2);
    }

    public static void main(String[] args) {

        _01_maxLenXOR obj = new _01_maxLenXOR();

        String s1 = "11111";
        String s2 = "111111";
        String s3 = "0000";
        String s4 = "001100";

        System.out.println("Answer 1: " + obj.maxLenXOR(s1)); // 5
        System.out.println("Answer 2: " + obj.maxLenXOR(s2)); // 5
        System.out.println("Answer 3: " + obj.maxLenXOR(s3)); // 4
        System.out.println("Answer 4: " + obj.maxLenXOR(s4)); // 3
    }
}