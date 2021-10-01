package practice.leetcode.dp;

public class LongestCommonSubsequence {
    /**
     * https://leetcode.com/problems/longest-common-subsequence/
     * LeetCode 1143. Longest Common Subsequence
     *
     * Time Complexity : O(n*m)
     * My Solution : 단순한 dp
     * String.charAt() 으로 조회하던 것을 미리 array로 꺼내놓고 조회하니
     * 조금 빨라지는 효과를 봤다
     *
     * result : 7-18ms
     */

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        for (int i = 1; i <= text2.length(); i++)
            for (int j = 1; j <= text1.length(); j++)
                if (chars1[j - 1] == chars2[i - 1]) dp[j][i] = dp[j - 1][i - 1] + 1;
                else dp[j][i] = Math.max(dp[j - 1][i], dp[j][i - 1]);

        return dp[text1.length()][text2.length()];
    }
}
