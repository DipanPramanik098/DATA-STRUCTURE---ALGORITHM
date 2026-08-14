package _19_Dynamic_Programming._01_Introduction;
import java.util.*;

public class _01_Fibonacci {
    public static int fib(int n, int [] dp){
        if(n<=1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = fib(n-1, dp) + fib(n-2, dp);
    }

    public static int tabulation(int n){
        int [] dp = new int [n+1];
        // base case
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // space optimization
    public static int space(int n){
        int prev2=0, prev1=1;
        for(int i=2; i<=n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public static void main(String[] args) {
        int n = 5;
        int dp [] = new int [n+1];
        // initilize to -1
        Arrays.fill(dp, -1);

        System.out.println(fib(n,dp));

        System.err.println("=====");

        System.out.println(tabulation(n));
    }
}
