/*
 * LC2261
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LC2261 {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    public static int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            StringBuilder sb = new StringBuilder();
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % p == 0) {
                    count++;
                }

                if (count > k) {
                    break;
                }

                sb.append(nums[j] + "_");

                set.add(sb.toString());
            }
        }

        return set.size();
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

        System.out.print("Enter The K Element : ");
        int k = sc.nextInt();
        System.out.println();

        System.out.print("Enter The Element P : ");
        int p = sc.nextInt();
        System.out.println();

        int answer = countDistinct(arr, k, p);

        System.out.println(answer);

        sc.close();
    }
}
