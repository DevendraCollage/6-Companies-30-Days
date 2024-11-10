/*
 * LC216
 */

import java.util.*;

public class LC216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    private static void solve(int i, int k, int n, List<Integer> curr, List<List<Integer>> ans) {
        if (n == 0 && k == 0) {
            ans.add(curr);
            return;
        }

        if (i > 9) {
            return;
        }

        if (n < 0 || k < 0) {
            return;
        }

        List<Integer> temp = new ArrayList<>(curr);
        temp.add(i);
        solve(i + 1, k - 1, n - i, temp, ans);

        solve(i + 1, k, n, curr, ans);
    }
}
