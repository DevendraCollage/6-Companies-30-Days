/*
 * LC718
 */

import java.util.Scanner;

public class LC718 {
    public static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // Memoization matrix
        int[][] dp = new int[n + 1][m + 1];
        // That will store the answer
        int max = 0;

        // Iterate over each position in the matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 01; j <= m; j++) {
                // If numbers are equal
                if (nums1[i - 1] == nums2[j - 1]) {
                    // Get the number from diagonally opposite
                    // and add 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array-1 Length : ");
        int n1 = sc.nextInt();
        System.out.println();

        int[] arr1 = new int[n1];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("[%d] : ", i);
            arr1[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter Array-2 Length : ");
        int n2 = sc.nextInt();
        System.out.println();

        int[] arr2 = new int[n2];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("[%d] : ", i);
            arr2[i] = sc.nextInt();
        }
        System.out.println();

        int ans = findLength(arr1, arr2);

        System.out.println(ans);

        sc.close();
    }
}
