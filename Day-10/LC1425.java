/*
 * LC1425
 */

import java.util.PriorityQueue;
import java.util.Scanner;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class LC1425 {
    public static int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;

        return solve(nums, n, k);
    }

    public static int solve(int[] arr, int n, int k) {
        // Implemented MaxHeap
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.first - a.first);
        maxHeap.add(new Pair(arr[0], 0));
        int ans = arr[0];

        for (int i = 1; i < n; i++) {
            while (i - maxHeap.peek().second > k) {
                maxHeap.poll();
            }

            // Negative numbers will replace with 0
            int sum = Math.max(0, maxHeap.peek().first) + arr[i];
            // Update the maxHeap
            ans = Math.max(ans, sum);
            // Push the max element to the MaxHeap
            maxHeap.add(new Pair(sum, i));
        }

        return ans;
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

        System.out.print("Enter The K Size Number : ");
        int k = sc.nextInt();
        System.out.println();

        int ans = constrainedSubsetSum(arr, k);

        System.out.println(ans);

        sc.close();
    }
}