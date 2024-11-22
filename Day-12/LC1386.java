/*
 * LC1386
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class LC1386 {
    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map to track reserved seats row-wise
        Map<Integer, Set<Integer>> reservedMap = new HashMap<>();
        for (int[] seat : reservedSeats) {
            reservedMap.computeIfAbsent(seat[0], k -> new HashSet<>()).add(seat[1]);
        }

        int count = 0;

        // Iterate through all rows with reserved seats
        for (int row : reservedMap.keySet()) {
            Set<Integer> reserved = reservedMap.get(row);

            // Check the availability of the 3 valid blocks: 2-5, 4-7, and 6-9
            boolean leftBlock = !reserved.contains(2) && !reserved.contains(3) && !reserved.contains(4)
                    && !reserved.contains(5);
            boolean middleBlock = !reserved.contains(4) && !reserved.contains(5) && !reserved.contains(6)
                    && !reserved.contains(7);
            boolean rightBlock = !reserved.contains(6) && !reserved.contains(7) && !reserved.contains(8)
                    && !reserved.contains(9);

            if (leftBlock && rightBlock) {
                count += 2; // Both left and right blocks are available
            } else if (leftBlock || middleBlock || rightBlock) {
                count += 1; // Any one block is available
            }
        }

        // Add two families for all completely empty rows
        count += 2 * (n - reservedMap.size());

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N Number Here : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.print("Enter The Reserved Seats Matrix Size Here : ");
        int size = sc.nextInt();
        System.out.println();

        int[][] reservedSeats = new int[size][size];

        System.out.println("Enter The Reserved Seats Elements Here : ");
        for (int i = 0; i < reservedSeats.length; i++) {
            for (int j = i; j < reservedSeats.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                reservedSeats[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans = maxNumberOfFamilies(n, reservedSeats);

        System.out.println(ans);

        sc.close();
    }
}
