/*
 * LC218
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LC218 {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        // We are going to store answer
        List<List<Integer>> res = new ArrayList<>();
        // Store the heights of the building
        List<int[]> heights = new ArrayList<>();

        transformBuild(buildings, heights);
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int preMax = 0;

        for (int[] height : heights) {
            if (height[1] < 0) {
                pq.offer(-height[1]);
            } else {
                pq.remove(height[1]);
            }

            int currMax = pq.peek();

            if (currMax != preMax) {
                List<Integer> subRes = new ArrayList<>();
                subRes.add(height[0]);
                subRes.add(currMax);
                res.add(subRes);
                preMax = currMax;
            }
        }

        return res;
    }

    // helper function
    private static void transformBuild(int[][] buildings, List<int[]> heights) {
        for (int[] building : buildings) {
            heights.add(new int[] { building[0], -building[2] });
            heights.add(new int[] { building[1], building[2] });
        }

    }
}