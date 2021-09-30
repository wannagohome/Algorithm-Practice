package practice.leetcode.dp;

public class CountNumberOfTeams {
    /**
     * https://leetcode.com/problems/count-number-of-teams/
     * LeetCode 1395. Count Number of Teams
     *
     * My Solution :
     * 각 인덱스별로 증가하는 경우, 작아지는 경우를 제귀적으로 모두 구함 (브루트 포스?)
     * result : 시간 초과
     *
     * Better Solution :
     * 단순하게 특정 인덱스를 기준으로 해당 인덱스의 수보다 왼쪽에 있고 작은 수와 오른쪽에 있고 큰 수의 곱,
     * 오른쪽에 있고 작은 수와 왼쪽에 있고 작은수의 곱의 합 으로 구함
     * Time complexity : O(n^2)
     * result : 30ms
     *
     * Greater Solution :
     * 10ms 이하로 빠르게 푼 solution들을 봤을
     * Binary Indexed Tree 라는 것을 사용한 것 같다.
     * 여기에 대해 공부한 뒤 다시 시도해 봐야 할 것 같다.
     */

    int[] rating;

    public static void main(String[] args) {
        CountNumberOfTeams instance = new CountNumberOfTeams();
        instance.numTeams(new int[]{2, 5, 3, 4, 1});
    }

    public int numTeams(int[] rating) {
        this.rating = rating;
        int ans = 0;
        for (int i = 0; i < rating.length; i++) {
            ans += getNumber(i, 0, true);
            ans += getNumber(i, 0, false);
        }

        return ans;
    }

    public int getNumber(int index, int currentLength, boolean isIncreasing) {
        if (currentLength == 2) return 1;
        int res = 0;

        for (int i = index + 1; i < rating.length; i++) {
            if ((isIncreasing && rating[index] < rating[i])
                    || (!isIncreasing && rating[index] > rating[i])) {
                res += getNumber(i, currentLength + 1, isIncreasing);
            }
        }

        return res;
    }

    public int better(int[] rating) {
        int res = 0;
        for (int i = 1; i < rating.length - 1; ++i) {
            int less[] = new int[2], greater[] = new int[2];
            for (int j = 0; j < rating.length; ++j) {
                if (rating[i] < rating[j])
                    ++less[j > i ? 1 : 0];
                if (rating[i] > rating[j])
                    ++greater[j > i ? 1 : 0];
            }
            res += less[0] * greater[1] + greater[0] * less[1];
        }
        return res;
    }
}
