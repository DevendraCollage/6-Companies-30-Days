/*
 * LC462
 */

import java.util.*;

public class LC462 {
    public static int minMoves2(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        int len = nums.length;
        int median = nums[len / 2];

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += Math.abs(nums[i] - median);
        }

        return count;
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

        int answer = minMoves2(arr);

        System.out.println(answer);

        sc.close();
    }
}
