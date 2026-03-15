package _007_Binary_Search._06_Contest;

public class _03_Z_Score {

    // Check if given x can be a valid Z-Score
    private boolean canMakeZScore(int[] marks, int k, int x) {
        int count = 0;
        int required = x * k;

        for (int mark : marks) {
            if (mark >= required) {
                count++;
            }
        }

        return count >= x;
    }

    public int ZScore(int[] marks, int k) {
        int n = marks.length;

        int low = 0;
        int high = n;
        int ans = 0;

        // Binary search on possible Z-Score
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMakeZScore(marks, k, mid)) {
                ans = mid;      // mid is possible
                low = mid + 1;  // try for bigger score
            } else {
                high = mid - 1; // reduce score
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        _03_Z_Score obj = new _03_Z_Score();

        int[] marks1 = {62, 69, 79, 85, 45};
        int k1 = 20;
        System.out.println(obj.ZScore(marks1, k1)); // 3

        int[] marks2 = {93, 64, 91, 85};
        int k2 = 45;
        System.out.println(obj.ZScore(marks2, k2)); // 2
    }
}