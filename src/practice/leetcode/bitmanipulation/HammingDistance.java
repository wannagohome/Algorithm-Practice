package practice.leetcode.bitmanipulation;

public class HammingDistance {
    /**
     * https://leetcode.com/problems/hamming-distance/
     * LeetCode 461. Hamming Distance
     *
     * My Solution :
     * binary string 으로 만든뒤 각 자릿수 비교
     * result : 1ms
     *
     * Better:
     * 어이없을 정도로 간단한 연산...
     * bit manipulation 문제는 항상 이런 부분이 어렵다
     * bit 연산에 대한 기본적인 이해부터가 필요할 것 같다
     * result : 0ms
     *
     */

    public int hammingDistance(int x, int y) {
        String xStr = Integer.toBinaryString(x);
        String yStr = Integer.toBinaryString(y);
        while (xStr.length() != yStr.length()) {
            if (xStr.length() > yStr.length()) yStr = "0" + yStr;
            else xStr = "0" + xStr;
        }

        int ans = 0;
        for (int i = 0; i < xStr.length(); i++) {
            if (xStr.charAt(i) != yStr.charAt(i)) ans++;
        }

        return ans;
    }

    public int better(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
