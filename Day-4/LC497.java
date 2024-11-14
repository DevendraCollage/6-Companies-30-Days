/*
 * LC497
 */

import java.util.Random;
import java.util.TreeMap;

public class LC497 {
    private Random ran;
    private TreeMap<Integer, Integer> map;
    private int[][] rects;
    private int area;

    public LC497(int[][] rects) {
        ran = new Random();
        map = new TreeMap<>();
        this.rects = rects;
        area = 0;

        // Build the map
        for (int i = 0; i < rects.length; i++) {
            int curArea = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            area += curArea;
            map.put(area, i);
        }
    }

    public int[] pick() {
        // Get a random point
        int randInt = ran.nextInt(area);

        // Find the rectangle index
        int key = map.ceilingKey(randInt + 1);
        int rectIndex = map.get(key);
        int[] rect = rects[rectIndex];

        // Calculate the width and height
        int width = rect[2] - rect[0] + 1;
        int height = rect[3] - rect[1] + 1;

        // Calculate local offset
        int offsetInRect = randInt - (key - width * height);

        // Calculate x and y coordinates within the rectangle
        int x = rect[0] + (offsetInRect % width);
        int y = rect[1] + (offsetInRect / width);

        return new int[] { x, y };
    }
}
