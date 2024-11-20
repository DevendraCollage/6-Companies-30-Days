/*
 * LC2741
 */

import java.util.Arrays;
import java.util.Scanner;

public class LC2741 {
    static int[][] dp;
    static int mod = 1000000007;

    public static int specialPerm(int[] nums) {
        int n = nums.length;
        // DP array they do not calculate element every time
        dp = new int[n + 1][1 << 14 + 1];
        // Fill dp with -1 initial value
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, -1, 0, 0);
    }

    public static int solve(int[] nums, int prevIndex, int currIndex, int mask) {
        // Base Case
        if (currIndex == nums.length) {
            return 1;
        }

        if (dp[prevIndex + 1][mask] != -1) {
            return dp[prevIndex + 1][mask];
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) > 0) {
                continue;
            }

            if (prevIndex == -1 || nums[prevIndex] % nums[i] == 0 || nums[i] % nums[prevIndex] == 0) {
                ans = (ans + solve(nums, i, currIndex + 1, mask | (1 << i))) % mod;
            }
        }

        return dp[prevIndex + 1][mask] = ans;
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

        int ans = specialPerm(arr);

        System.out.println(ans);

        sc.close();
    }
}
