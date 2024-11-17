/*
 * LC2572
 */

import java.util.Scanner;

public class LC2572 {
    public static int squareFreeSubsets(int[] nums) {
        // Prime numbers up to 30
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

        // Count the array to keep track of numbers
        int[] count = new int[31];
        for (int num : nums) {
            ++count[num];
        }

        final int mod = (int) 1e9 + 7;

        int primeCount = primes.length;

        long[] dp = new long[1 << primeCount];

        dp[0] = 1;

        for (int i = 0; i < count[1]; i++) {
            dp[0] = (dp[0] * 2) % mod;
        }

        for (int i = 2; i < 31; i++) {
            if (count[i] == 0 || i % 4 == 0 || i % 9 == 0 || i % 25 == 0) {
                continue;
            }

            int mask = 0;
            for (int j = 0; j < primeCount; j++) {
                if (i % primes[j] == 0) {
                    mask |= 1 << j;
                }
            }

            for (int state = (1 << primeCount) - 1; state >= 0; state--) {
                if ((state & mask) == mask) {
                    dp[state] = (dp[state] + dp[state ^ mask] * count[i]) % mod;
                }
            }
        }

        long ans = 0;
        for (long subsets : dp) {
            ans = (ans + subsets) % mod;
        }

        ans = (ans - 1 + mod) % mod;

        return (int) ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] arr = new int[n];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        int answer = squareFreeSubsets(arr);

        System.out.println(answer);

        sc.close();
    }
}
