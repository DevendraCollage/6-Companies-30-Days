/*
 * LC139
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LC139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int[][] dp = new int[s.length()][s.length()];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return solve(0, 0, s, new HashSet<>(wordDict), dp);
    }

    private static boolean solve(int start, int end, String s, Set<String> wd, int[][] dp) {
        if (dp[start][end] != -1) {
            return dp[start][end] == 1 ? true : false;
        }
        if (end == s.length() - 1) {
            if (wd.contains(s.substring(start, end + 1))) {
                return true;
            } else {
                return false;
            }
        }

        if (wd.contains(s.substring(start, end + 1))) {
            if (solve(end + 1, end + 1, s, wd, dp)) {
                dp[start][end] = 1;
                return true;
            }
        }

        dp[start][end] = solve(start, end + 1, s, wd, dp) ? 1 : 0;
        return dp[start][end] == 1 ? true : false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String str = sc.nextLine();
        System.out.println();

        System.out.print("Enter The Size of String List : ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println();

        List<String> myList = new ArrayList<>();

        System.out.println("Enter The List of String Here : ");
        for (int i = 0; i < n; i++) {
            System.out.printf("[%d] : ", i);
            String st = sc.nextLine();
            myList.add(st);
        }
        System.out.println();

        boolean ans = wordBreak(str, myList);

        System.out.println(ans);

        sc.close();
    }
}