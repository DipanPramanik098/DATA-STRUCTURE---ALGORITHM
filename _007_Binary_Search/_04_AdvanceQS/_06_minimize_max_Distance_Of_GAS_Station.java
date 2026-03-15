package _007_Binary_Search._04_AdvanceQS;

public class _06_minimize_max_Distance_Of_GAS_Station {

    // Helper function to calculate how many gas stations
    // are required so that every gap becomes <= dist
    private int numberOfGasStationsRequired(double dist, int[] arr) {
        int cnt = 0;

        for (int i = 1; i < arr.length; i++) {
            double gap = arr[i] - arr[i - 1];

            int numberInBetween = (int) (gap / dist);

            // If gap is exactly divisible by dist,
            // reduce one because endpoints already exist
            if (gap == dist * numberInBetween) {
                numberInBetween--;
            }

            cnt += numberInBetween;
        }

        return cnt;
    }

    // Function to minimize the maximum distance
    public double minimiseMaxDistance(int[] arr, int k) {
        double low = 0;
        double high = 0;

        // Find largest existing gap
        for (int i = 0; i < arr.length - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        double diff = 1e-6;

        // Binary search on decimal answer space
        while (high - low > diff) {
            double mid = (low + high) / 2.0;

            int cnt = numberOfGasStationsRequired(mid, arr);

            if (cnt > k) {
                // mid too small, need more stations than allowed
                low = mid;
            } else {
                // mid works, try smaller answer
                high = mid;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        _06_minimize_max_Distance_Of_GAS_Station obj =
                new _06_minimize_max_Distance_Of_GAS_Station();

        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        System.out.printf("%.5f\n", obj.minimiseMaxDistance(arr1, 10)); // 0.50000

        int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
        System.out.printf("%.5f\n", obj.minimiseMaxDistance(arr2, 1)); // 1.00000

        int[] arr3 = {3, 6, 12, 19, 33, 44, 67, 72, 89, 95};
        System.out.printf("%.5f\n", obj.minimiseMaxDistance(arr3, 2)); // 14.00000
    }
}