/*
 * LC2343
 */

import java.util.Arrays;

public class LC2343 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        // Store the length of nums and queries
        int numOfStrings = nums.length;
        int numOfQueries = queries.length;

        // Create an array to store the answer
        int[] ans = new int[numOfQueries];

        // Create an 2D array to store the trimmer string of both
        String[][] trimmedIndices = new String[numOfStrings][2];

        // Iterate over each query
        for (int i = 0; i < numOfQueries; ++i) {
            int k = queries[i][0];
            int trimLength = queries[i][1];

            for (int j = 0; j < numOfStrings; ++j) {
                trimmedIndices[j] = new String[] {
                        nums[j].substring(nums[j].length() - trimLength), String.valueOf(j)
                };
            }

            // Sort the array of String and Indices
            Arrays.sort(trimmedIndices, (a, b) -> {
                int comparison = a[0].compareTo(b[0]);
                return comparison == 0 ? Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1])) : comparison;
            });

            ans[i] = Integer.parseInt(trimmedIndices[k - 1][1]);
        }

        return ans;
    }
}
