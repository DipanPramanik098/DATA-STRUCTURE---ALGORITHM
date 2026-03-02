package _04_Basic_Maths;

public class _10_Count_Prime {

    // Function to count primes till n using Sieve of Eratosthenes
    public static int primeUptoN(int n) {

        // Edge case
        if (n < 2) {
            return 0;
        }

        // Step 1: Create boolean array
        boolean[] isPrime = new boolean[n + 1];

        // Step 2: Initialize all entries as true
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // Step 3: Apply Sieve
        for (int i = 2; i * i <= n; i++) {

            if (isPrime[i]) {

                // Mark multiples of i as false
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 4: Count primes
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int n = 10;

        int result = primeUptoN(n);

        System.out.println("Count of primes till " + n + " is: " + result);
    }
}
