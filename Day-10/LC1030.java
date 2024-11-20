/*
 * LC1030
 */

import java.util.Arrays;
import java.util.Scanner;

public class LC1030 {
    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        // We can store answer in this
        int[][] ans = new int[rows * cols][2];
        // Fill the answer array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int bno = i * cols + j;
                ans[bno][0] = i;
                ans[bno][1] = j;
            }
        }

        // Sort the answer array
        Arrays.sort(ans, (a, b) -> {
            int d1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int d2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);

            return d1 - d2;
        });

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Row : ");
        int row = sc.nextInt();
        System.out.println();

        System.out.print("Enter The Column: ");
        int col = sc.nextInt();
        System.out.println();

        System.out.print("Enter The RCenter : ");
        int rCenter = sc.nextInt();
        System.out.println();

        System.out.print("Enter The CCenter : ");
        int cCenter = sc.nextInt();
        System.out.println();

        int[][] ans = allCellsDistOrder(row, col, rCenter, cCenter);

        System.out.println("This The Given Answer : ");
        for (int i = 0; i < ans.length; i++) {
            for (int j = i; j < ans.length; j++) {
                System.out.printf("[%d][%d] : %d\n", i, j, ans[i][j]);
            }
        }

        sc.close();
    }
}
