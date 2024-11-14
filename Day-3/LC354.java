/*
 * LC354
 */

import java.util.Arrays;
import java.util.Scanner;

public class LC354 {

    public static class Envelope implements Comparable<Envelope> {
        int w;
        int h;

        Envelope(int w, int h) {
            this.w = w;
            this.h = h;
        }

        public int compareTo(Envelope o) {
            if (this.w != o.w) {
                return Integer.compare(this.w, o.w);
            } else {
                return Integer.compare(o.h, this.h);
            }
        }
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Envelope[] envlps = new Envelope[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            envlps[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
        }

        // Sort envelopes by width ascending and by height descending when widths are
        // equal
        Arrays.sort(envlps, (a, b) -> a.w == b.w ? b.h - a.h : a.w - b.w);

        // Extract heights and apply LIS on it
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envlps.length; i++) {
            heights[i] = envlps[i].h;
        }

        return lengthOfLIS(heights);
    }

    private static int lengthOfLIS(int[] heights) {
        int[] dp = new int[heights.length];
        int length = 0;

        for (int height : heights) {
            int pos = Arrays.binarySearch(dp, 0, length, height);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            dp[pos] = height;
            if (pos == length) {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Size : ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println();

        int[][] envelopes = new int[n][2];
        System.out.println("Enter Array Elements (width height): ");
        for (int i = 0; i < n; i++) {
            envelopes[i][0] = sc.nextInt();
            envelopes[i][1] = sc.nextInt();
        }

        int omax = maxEnvelopes(envelopes);

        System.out.println(omax);

        sc.close();
    }
}
