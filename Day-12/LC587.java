/*
 * LC587
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LC587 {
    private static class Point {
        int x; // Updated from x1 to x
        int y; // Updated from y1 to y

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] outerTrees(int[][] trees) {
        List<Point> points = new ArrayList<>();
        for (int[] point : trees) {
            points.add(new Point(point[0], point[1]));
        }

        // For storing the result
        List<Point> res = new ArrayList<>();
        // Base case
        if (points.size() <= 1) {
            return trees;
        }
        int n = points.size();

        // Sort the points by y-coordinate, breaking ties by x-coordinate
        points.sort((a, b) -> a.y == b.y ? a.x - b.x : a.y - b.y);

        HashSet<List<Integer>> dup = new HashSet<>();

        Stack<Point> hull = new Stack<>();
        hull.push(points.get(0));
        hull.push(points.get(1));

        // Lower hull
        for (int i = 2; i < n; i++) {
            Point top = hull.pop();
            while (!hull.isEmpty() && ccw(hull.peek(), top, points.get(i)) < 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points.get(i));
        }

        // Upper hull
        for (int i = n - 2; i >= 0; i--) {
            Point top = hull.pop();
            while (!hull.isEmpty() && ccw(hull.peek(), top, points.get(i)) < 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points.get(i));
        }

        // Remove duplicates and prepare the result
        for (Point x : hull) {
            List<Integer> tmp = Arrays.asList(x.x, x.y);
            if (dup.contains(tmp)) {
                continue;
            }
            dup.add(tmp);
            res.add(x);
        }

        int[][] ans = new int[res.size()][2];
        int i = 0;
        for (Point p : res) {
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i++;
        }

        return ans;
    }

    public static int ccw(Point a, Point b, Point c) {
        int crossProduct = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);

        if (crossProduct < 0) {
            return -1; // Clockwise
        } else if (crossProduct > 0) {
            return +1; // Counterclockwise
        } else {
            return 0; // Collinear
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Matrix Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[][] trees = new int[n][n];

        System.out.println("Enter The Trees Elements : ");
        for (int i = 0; i < trees.length; i++) {
            for (int j = i; j < trees.length; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                trees[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int[][] answer = outerTrees(trees);

        System.out.println("This the Answer : ");
        for (int i = 0; i < answer.length; i++) {
            for (int j = i; j < answer.length; j++) {
                System.out.printf("[%d][%d] : %d\n", i, j, answer[i][j]);
            }
        }

        sc.close();
    }
}
