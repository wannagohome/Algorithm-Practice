package practice.leetcode.greedy;


public class LongestPalindrome {
    /**
     * https://leetcode.com/problems/longest-palindrome/
     * LeetCode 409. Longest Palindrome
     */
    public static int solution(String s) {
        int[] ascii = new int[128];
        for (char c : s.toCharArray()) {
            ascii[c]++;
        }

        int result = 0;
        for (int i : ascii) {
            result += i - (i % 2);
            if (result % 2 == 0 && i % 2 == 1) {
                result += 1;
            }
        }
        return result;
    }
}
