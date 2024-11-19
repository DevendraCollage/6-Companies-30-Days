/*
 * LC820
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LC820 {
    public static int minimumLengthEncoding(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        List<String> wordList = new ArrayList<>(wordSet);

        Set<String> dupList = new HashSet<>();

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
                if (i != j) {
                    if (wordList.get(i).endsWith(wordList.get(j))) {
                        dupList.add(wordList.get(j));
                    }
                }
            }
        }

        int count = 0;
        for (String word : wordList) {
            if (!dupList.contains(word)) {
                count += word.length() + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Size : ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println();

        String[] arr = new String[n];

        System.out.println("Enter The Array Words : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextLine();
        }
        System.out.println();

        int ans = minimumLengthEncoding(arr);

        System.out.println(ans);

        sc.close();
    }
}
