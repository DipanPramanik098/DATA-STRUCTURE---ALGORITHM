package _007_Binary_Search._04_AdvanceQS;

public class _02_Book_Allocation {

    // Helper function to count how many students are needed
    // if each student can read at most 'pages' pages
    private int countStudents(int[] nums, int pages) {
        int students = 1;
        int pagesStudent = 0;

        for (int num : nums) {
            if (pagesStudent + num <= pages) {
                pagesStudent += num;
            } else {
                students++;
                pagesStudent = num;
            }
        }

        return students;
    }

    // Function to allocate books to m students such that
    // the maximum pages assigned to a student is minimized
    public int findPages(int[] nums, int m) {
        int n = nums.length;

        // Impossible case
        if (m > n) return -1;

        int low = Integer.MIN_VALUE;
        int high = 0;

        // Find max element and total sum
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        // Binary search on answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int students = countStudents(nums, mid);

            if (students > m) {
                // mid is too small
                low = mid + 1;
            } else {
                // mid is valid, try smaller answer
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        _02_Book_Allocation obj = new _02_Book_Allocation();

        int[] nums1 = {12, 34, 67, 90};
        System.out.println(obj.findPages(nums1, 2)); // 113

        int[] nums2 = {25, 46, 28, 49, 24};
        System.out.println(obj.findPages(nums2, 4)); // 71

        int[] nums3 = {15, 17, 20};
        System.out.println(obj.findPages(nums3, 2)); // 32
    }
}