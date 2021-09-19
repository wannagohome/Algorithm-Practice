package practice.leetcode.greedy;

public class ContainerWithMostWater {

    /**
     * https://leetcode.com/problems/container-with-most-water/submissions/
     * LeetCdoe 11. Container With Most Water
     *
     * My Solution : 모든 경우의 수 전체 조회 O(n^2)
     * result : 시간초과
     *
     * Better Solution : 양 끝에 핀(혹은 커서)를 두고
     * 확실히 넓이가 적은 경우들을 제외해 가며 연산 O(n)
     * result: 6ms
     */

    public static int mySolution(int[] height) {
        int ans = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                ans = Math.max(ans, area);
            }
        }

        return ans;
    }

    public static int solution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, area);

            if (height[left] < height[right])  left++;
            else right --;
        }

        return ans;
    }

}
