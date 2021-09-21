package practice.leetcode;

public class DistinctSubsequences {
    /**
     * https://leetcode.com/problems/distinct-subsequences/
     * LeetCdoe 115. Distinct Subsequences
     *
     * My Solution :
     * 주어진 두 문자열 s, t를 가지고 t가 s의 subsequence 가 되는 case 수를 찾는 문제
     * subsequence 혹은 matching 이 나오면 언제나 dp를 먼저 떠올려야 함을 잊지 말자
     *
     * Time Complexity : O(n*m)
     * result : 9-29ms
     *
     */

    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
    }
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    if (i == 1) dp[i][j] = dp[i][j - 1] + 1;
                    else if (i > j) dp[i][j] = 0;
                    else if (i == j) dp[i][j] = Math.min(1, dp[i][j - 1] + dp[i - 1][j - 1]);
                    else dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else  dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[t.length()][s.length()];
    }
}
