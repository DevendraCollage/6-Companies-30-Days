/*
 * LC368
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC368 {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        final int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        if (n == 0) {
            return ans;
        }

        int[] sizeEndAt = new int[n];
        int[] prevIndex = new int[n];
        int maxSize = 0;
        int index = -1;

        Arrays.fill(sizeEndAt, 1);
        Arrays.fill(prevIndex, -1);
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && sizeEndAt[i] < sizeEndAt[j] + 1) {
                    sizeEndAt[i] = sizeEndAt[j] + 1;
                    prevIndex[i] = j;
                }
            }
            if (maxSize < sizeEndAt[i]) {
                maxSize = sizeEndAt[i];
                index = i;
            }
        }

        while (index != -1) {
            ans.add(nums[index]);
            index = prevIndex[index];
        }

        return ans;
    }
}
