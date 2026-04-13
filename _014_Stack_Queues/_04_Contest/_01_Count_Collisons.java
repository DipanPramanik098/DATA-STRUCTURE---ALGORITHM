package _014_Stack_Queues._04_Contest;

public class _01_Count_Collisons {

    public static int countCollisions(String directions) {
        int n = directions.length();

        int left = 0;
        int right = n - 1;

        // Skip all cars moving left from the beginning
        // क्योंकि ये कभी collide नहीं करेंगे
        while (left < n && directions.charAt(left) == 'L') {
            left++;
        }

        // Skip all cars moving right from the end
        // क्योंकि ये भी कभी collide नहीं करेंगे
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }

        int collisions = 0;

        // Middle part me jitne bhi moving cars hain (L or R),
        // sab eventually collide karenge
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                collisions++;
            }
        }

        return collisions;
    }

    public static void main(String[] args) {
        String directions1 = "RLLRS";
        String directions2 = "SSRRLL";

        System.out.println(countCollisions(directions1)); // 4
        System.out.println(countCollisions(directions2)); // 4
    }
}