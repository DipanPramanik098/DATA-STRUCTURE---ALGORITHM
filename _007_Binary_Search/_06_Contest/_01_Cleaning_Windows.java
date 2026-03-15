package _007_Binary_Search._06_Contest;

public class _01_Cleaning_Windows {

    // Find maximum windows in any floor
    private int findMax(int[] windows) {
        int max = windows[0];

        for (int w : windows) {
            if (w > max) {
                max = w;
            }
        }

        return max;
    }

    // Find total hours needed if speed is k windows per hour
    private long totalHours(int[] windows, int k) {
        long hours = 0;

        for (int w : windows) {
            // ceil(w / k)
            hours += (w + k - 1) / k;
        }

        return hours;
    }

    public int cleaningWindows(int[] windows, int h) {
        int n = windows.length;

        // If hours are less than number of floors, impossible
        if (h < n) {
            return -1;
        }

        int low = 1;
        int high = findMax(windows);
        int ans = -1;

        // Binary search on speed
        while (low <= high) {
            int mid = low + (high - low) / 2;

            long neededHours = totalHours(windows, mid);

            if (neededHours <= h) {
                ans = mid;      // possible answer
                high = mid - 1; // try smaller speed
            } else {
                low = mid + 1;  // need bigger speed
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        _01_Cleaning_Windows obj = new _01_Cleaning_Windows();

        int[] windows1 = {5, 7, 1, 8};
        int h1 = 8;
        System.out.println(obj.cleaningWindows(windows1, h1)); // 4

        int[] windows2 = {5, 7, 8, 9, 10};
        int h2 = 4;
        System.out.println(obj.cleaningWindows(windows2, h2)); // -1
    }
}