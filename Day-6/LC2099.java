/*
 * LC2099
 */

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LC2099 {
    public static int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] { nums[i], i });
            if (pq.size() > k) {
                pq.poll();
            }
        }

        Set<Integer> index = new HashSet<>();

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            index.add(top[1]);
        }

        int[] ans = new int[k];
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index.contains(i)) {
                ans[p] = nums[i];
                p++;
            }
        }

        return ans;
    }
}
