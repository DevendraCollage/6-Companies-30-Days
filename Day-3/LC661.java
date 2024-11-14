/*
 * LC661
 */

import java.util.Scanner;

public class LC661 {
    // Image direction array
    static int[][] dir = {
            { -1, -1 }, { -1, 0 }, { -1, 1 },
            { 0, -1 }, { 0, 0 }, { 0, 1 },
            { 1, -1 }, { 1, 0 }, { 1, 1 }
    };

    static int m, n;

    public static int[][] imageSmoother(int[][] img) {
        m = img.length;
        n = img[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                img[i][j] |= (smoother(img, i, j) << 8);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                img[i][j] >>= 8;
            }
        }

        return img;
    }

    public static int smoother(int[][] img, int i, int j) {
        int sum = 0, count = 0;

        for (int[] d : dir) {
            int I = i + d[0];
            int J = j + d[1];

            if (I < 0 || J < 0 || I >= m || J >= n) {
                continue;
            }

            sum += img[I][J] & 255;
            count++;
        }

        return sum / count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Length : ");
        int n = sc.nextInt();
        System.out.println();

        int[][] arr = new int[n][n];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int[][] answer = imageSmoother(arr);

        System.out.println("Answer : ");
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("[%d][%d] : %d", i, j, answer[i]);
            }
        }
        System.out.println();

        sc.close();
    }
}
