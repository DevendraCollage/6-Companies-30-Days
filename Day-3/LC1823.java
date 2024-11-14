/*
 * LC1823
 */

import java.util.*;

public class LC1823 {
    // This will follow the bottom up approach
    public static int findTheWinner(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the N Value Here : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.print("Enter the K Value Here : ");
        int k = sc.nextInt();
        System.out.println();

        int answer = findTheWinner(n, k);

        System.out.println(answer);

        sc.close();
    }
}