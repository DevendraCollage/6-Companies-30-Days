/*
 * LC2707
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class LC2707 {
    static int[] dp = new int[50];

    public static int recur(String s, HashSet<String> dictionary, int index) {
        // Base Case for Empty String
        if (index == s.length()) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        StringBuilder sb = new StringBuilder();
        int minExtraChar = Integer.MAX_VALUE;
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            int extraChar = 0;
            if (!dictionary.contains(sb.toString())) {
                extraChar = sb.length();
            }
            int currExtra = recur(s, dictionary, i + 1);
            minExtraChar = Math.min(minExtraChar, extraChar + currExtra);
        }

        return dp[index] = minExtraChar;
    }

    public static int minExtraChar(String s, String[] dictionary) {
        Arrays.fill(dp, -1);
        HashSet<String> dict = new HashSet<>(Arrays.asList(dictionary));
        return recur(s, dict, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String str = sc.nextLine();
        System.out.println();

        System.out.print("Enter The String Array Length : ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println();

        String[] arr = new String[n];

        System.out.println("Enter The Words : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextLine();
        }
        System.out.println();

        int answer = minExtraChar(str, arr);

        System.out.println(answer);

        sc.close();
    }
}
