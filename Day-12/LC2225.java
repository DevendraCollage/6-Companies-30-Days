/*
 * LC2225
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

public class LC2225 {
    public static List<List<Integer>> findWinners(int[][] matches) {
        // Store the players who have not loss any match
        List<Integer> zeroLoses = new ArrayList<>();

        // Store the player who have loss one match
        List<Integer> oneLoses = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] team : matches) {
            map.put(team[0], map.getOrDefault(team[0], 0) + 0);
            map.put(team[1], map.getOrDefault(team[1], 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) == 0) {
                zeroLoses.add(i);
            } else if (map.get(i) == 1) {
                oneLoses.add(i);
            }
        }

        Collections.sort(zeroLoses);
        Collections.sort(oneLoses);

        return Arrays.asList(zeroLoses, oneLoses);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The 2-D Matrix Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[][] matrix = new int[n][n];

        System.out.println("Enter The Matrix Elements : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        List<List<Integer>> ans = findWinners(matrix);

        System.out.println("This is the Answer : ");
        for (List<Integer> list : ans) {
            System.out.println(list);
        }

        sc.close();
    }
}