/*
 * LC2662
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LC2662 {
    public static record Pt(int x, int y) {
    }

    public static int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        // Target Point
        Pt targetPt = new Pt(target[0], target[1]);

        // Start Point
        Pt startPt = new Pt(start[0], start[1]);

        // Priority Queue for Modified Dijkstra
        PriorityQueue<Object[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> (int) o[1]));
        Map<Pt, Integer> costs = new HashMap<>();

        costs.put(startPt, 0);
        pq.add(new Object[] { startPt, 0 });

        int shortestPath = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Object[] o = pq.poll();
            Pt point = (Pt) o[0];
            int costToThisPoint = (int) o[1];

            // Skip if we've already found a better path
            if (costToThisPoint > costs.getOrDefault(point, Integer.MAX_VALUE)) {
                continue;
            }

            // Check direct path to target
            shortestPath = Math.min(shortestPath, costToThisPoint + distance(point, targetPt));

            // Process special roads
            for (int[] road : specialRoads) {
                Pt startOfRoad = new Pt(road[0], road[1]);
                Pt endOfRoad = new Pt(road[2], road[3]);
                int roadCost = road[4];

                // Calculate cost to reach the end of the special road
                int costToStartOfRoad = costToThisPoint + distance(point, startOfRoad);
                int costToEndOfRoad = costToStartOfRoad + roadCost;

                // Update cost if this is a better path
                if (costToEndOfRoad < costs.getOrDefault(endOfRoad, Integer.MAX_VALUE)) {
                    costs.put(endOfRoad, costToEndOfRoad);
                    pq.add(new Object[] { endOfRoad, costToEndOfRoad });
                }
            }
        }

        return shortestPath;
    }

    // Helper function to calculate Manhattan distance
    public static int distance(Pt from, Pt to) {
        return Math.abs(to.x() - from.x()) + Math.abs(to.y() - from.y());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Start Array Size : ");
        int n1 = sc.nextInt();
        System.out.println();

        int[] start = new int[n1];

        System.out.println("Enter Start Array Elements : ");
        for (int i = 0; i < start.length; i++) {
            System.out.printf("[%d] : ", i);
            start[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter Target Array Size : ");
        int n2 = sc.nextInt();
        System.out.println();

        int[] target = new int[n2];

        System.out.println("Enter Target Array Elements : ");
        for (int i = 0; i < target.length; i++) {
            System.out.printf("[%d] : ", i);
            target[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter Special Roads Array Size : ");
        int n3 = sc.nextInt();
        System.out.println();

        int[][] specialRoads = new int[n3][n3];

        System.out.println("Enter The Special roads Array Elements : ");
        for (int i = 0; i < specialRoads.length; i++) {
            for (int j = i; j < specialRoads.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                specialRoads[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int answer = minimumCost(start, target, specialRoads);

        System.out.println(answer);

        sc.close();
    }
}
