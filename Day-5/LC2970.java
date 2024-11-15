/*
 * LC2970
 */

import java.util.*;

public class LC2970 {
    public static int incremovableSubarrayCount(int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isIncreasingSubArray(nums, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    // Helper function to check the given element is increasing or not
    public static boolean isIncreasingSubArray(int[] arr, int start, int end) {
        int len = arr.length;
        int prev = 0;
        for (int i = 0; i < len; i++) {
            if (i <= end && i >= start) {
                continue;
            }
            if (arr[i] <= prev) {
                return false;
            }
            prev = arr[i];
        }
        return true;
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

        int asnwer = incremovableSubarrayCount(arr);

        System.out.println(asnwer);

        sc.close();
    }
}