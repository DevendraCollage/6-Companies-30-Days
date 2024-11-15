/*
 * LC324
 */

import java.util.Arrays;
import java.util.Scanner;

public class LC324 {
    public static void wiggleSort(int[] nums) {
        // Step:1 Sort array
        Arrays.sort(nums);

        // Step:2 Make an extra array to store the answer and manage equality in it
        int n = nums.length;
        int[] result = new int[n];

        // Use two pointer
        int left = (n - 1) / 2;
        int right = n - 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result[i] = nums[left--];
            } else {
                result[i] = nums[right--];
            }
        }

        // Step:3 fill input array from res
        for (int k = 0; k < n; k++) {
            nums[k] = result[k];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] arr = new int[n];

        System.out.println("Enter The Array Elements :");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        wiggleSort(arr);

        System.out.println("Answer After Sorting Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : %d\n", i, arr[i]);
        }

        sc.close();
    }
}
