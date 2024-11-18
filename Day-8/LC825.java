/*
 * LC825
 */

import java.util.*;

public class LC825 {
    // Helper function to check the given two friend are friend or not
    private static boolean canBeFriend(int ageA, int ageB) {
        if (ageB <= (0.5 * ageA + 7)) {
            return false;
        }
        if (ageB > ageA) {
            return false;
        }
        if (ageB > 100 && ageA < 100) {
            return false;
        }
        return true;
    }

    public static int numFriendRequests(int[] ages) {
        Map<Integer, Integer> ageCount = new HashMap<>();

        for (int age : ages) {
            ageCount.put(age, ageCount.getOrDefault(age, 0) + 1);
        }

        int requests = 0;
        for (int ageA : ageCount.keySet()) {
            for (int ageB : ageCount.keySet()) {

                if (!canBeFriend(ageA, ageB)) {
                    continue;
                }

                int countA = ageCount.get(ageA);
                int countB = ageCount.get(ageB);
                if (ageA == ageB) {
                    requests += ((countA - 1) * countA);
                } else {
                    requests += (countA * countB);
                }
            }
        }

        return requests;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] arr = new int[n];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        int ans = numFriendRequests(arr);

        System.out.println(ans);

        sc.close();
    }
}