/*
Problem Description

The Longest Common Subsequence (LCS) problem is a classic dynamic programming task.
Given two strings, the goal is to find the length of the longest sequence of characters that appear in both strings in the same order, but not necessarily contiguously.

For example:
	•	text1 = "abcde", text2 = "ace" → LCS = "ace", length = 3
	•	text1 = "abc", text2 = "abc" → LCS = "abc", length = 3
	•	text1 = "abc", text2 = "def" → LCS = "", length = 0

Your Task

You are given a Java implementation that attempts to solve the LCS problem using dynamic programming.
However, there is a bug in the code that leads to incorrect results for certain inputs.

For the input:
    text1 = "abccde";
    text2 = "acet";
The correct LCS is "ace" with a length of 3. However, the given program outputs 4.

In the dynamic programming solution, the value at `dp[i][j]` represents the length of the longest common subsequence between the prefixes `text1[0..i-1]` and `text2[0..j-1]`.
This means we compare the first `i` characters of `text1` and the first `j` characters of `text2`.

Your Task
    •	Find and fix the bug in the provided code.
    •	Make as few modifications as possible to achieve correct behavior.
    •	Keep the overall structure and logic of the original code.

 */

public class FTask4 {

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }

        int M = text1.length();
        int N = text2.length();

        int[][] dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1] + 1, dp[i][j - 1]), dp[i-1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[M][N];
    }

    public static void main(String[] args) {
        String text1 = "abccde";
        String text2 = "acet";
        int result = longestCommonSubsequence(text1, text2);
        System.out.println("The longest common subsequence length is: " + result);
    }
}