//You are given a 0-indexed string s and a dictionary of words dictionary.
//You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary.
//here may be some extra characters in s which are not present in any of the substrings.

import java.util.Scanner;
import java.util.HashSet;
import java.util.List;

public class Day11 {
    public int minExtraChar(String s, String[] dictionary) {
        int len = s.length();

        HashSet<String> dic = new HashSet<>();
        for (String word : dictionary) {
            dic.add(word);
        }

        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1; // Increment for the extra character

            for (int j = i - 1; j >= 0; j--) {
                String substr = s.substring(j, i);
                if (dic.contains(substr)) {
                    dp[i] = Math.min(dp[i], dp[j]); // Use dp[j] if the substring is in the dictionary
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Day11 solution = new Day11();

        // Test case 1
        String s1 = "leetscode";
        String[] dictionary1 = {"leet", "code", "leetcode"};
        System.out.println(solution.minExtraChar(s1, dictionary1)); // Output: 1

        // Test case 2
        String s2 = "sayhelloworld";
        String[] dictionary2 = {"hello", "world"};
        System.out.println(solution.minExtraChar(s2, dictionary2)); // Output: 3
    }
}
