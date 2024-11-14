/*
 * LC1248
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LC1248 {
    public static int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int cur = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i : nums) {
            cur += i % 2;
            res += map.getOrDefault(cur - k, 0);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] arr = new int[n];

        System.out.println("Enter The Array Elements  : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The K Element Here : ");
        int k = sc.nextInt();
        System.out.println();

        int answer = numberOfSubarrays(arr, k);

        System.out.println(answer);

        sc.close();
    }
}
