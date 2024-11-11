/*
 * GFG2512
 */

import java.util.*;

public class FindMissingAndSmallNumber {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // Length of the array
        int n = arr.length;

        // hash array
        int[] hash = new int[n + 1];

        // Update the hash array
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        // Find the repeating and missing number
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }

            if (repeating != -1 && missing != -1) {
                break;
            }

        }

        // Add repeating and missing element to the arrayList
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(repeating);
        ans.add(missing);

        return ans;
    }
}