/*
 * LC524
 */

import java.util.*;

public class LC524 {
    public static String findLongestWord(String s, List<String> dictionary) {
        // Sort the String using lambda function
        Collections.sort(dictionary, (a, b) -> b.length() != a.length() ? b.length() - a.length() : a.compareTo(b));

        for (String word : dictionary) {
            if (isSubSequence(word, s)) {
                return word;
            }
        }

        return "";
    }

    // Helper function to compare the characters with the List of String
    private static boolean isSubSequence(String word, String s) {
        int j = 0;
        for (int i = 0; i < s.length() && j < word.length(); i++) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }

        }
        return j >= word.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String s = sc.nextLine();
        System.out.println();

        System.out.print("Enter Size You Want add String : ");
        int size = sc.nextInt();
        System.out.println();

        List<String> dictionary = new ArrayList<>();

        System.out.println("Enter The String Words Here : ");
        for (int i = 0; i < size; i++) {
            System.out.printf("[%d] : ", i);
            String word = sc.nextLine();
            dictionary.add(word);
        }
        System.out.println();

        String ans = findLongestWord(s, dictionary);

        System.out.println(ans);

        sc.close();
    }
}
