/*
 * LC396    
 */

import java.util.Arrays;
import java.util.Scanner;

public class LC396 {
    public static int maxRotateFunction(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int f = 0;

        for (int i = 0; i < nums.length; i++) {
            f += i * nums[i];
        }

        int res = f;

        for (int i = nums.length - 1; i >= 1; i--) {
            res = Math.max(res, sum + f - (nums.length * nums[i]));
            f = sum + f - (nums.length * nums[i]);
        }

        return res;
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

        int answer = maxRotateFunction(arr);

        System.out.println(answer);

        sc.close();
    }
}
