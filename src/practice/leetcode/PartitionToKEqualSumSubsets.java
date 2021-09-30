package practice.leetcode;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class PartitionToKEqualSumSubsets {
    /**
     * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
     * LeetCode 698. Partition to K Equal Sum Subsets
     *
     * Solution :
     * 모든 수의 합 / k이 한 subset의 합이 되어야 한다는 것은 눈치챘지만,
     * 어떻게 recursion을 돌려야 할 지 떠올리지 못하였다.
     *
     * 각 index 마다 필요한 sum의 값에 도달 하는 case가 있는지
     * 재귀적(dfs) 방법을 통해 찾는다.
     * 목표하는 sum에 도달하면 만들어야 하는 subset의 값(k)을 하나씩 줄이고
     * visited를 체크해 가며
     *
     *
     * Time Complexity :
     * result : 2ms
     *
     */

    int[] nums;
    int ave;
    boolean[] visited;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;

        this.nums = nums;
        visited = new boolean[nums.length];
        ave = sum / k;

        return canPartition(k, 0, 0);
    }

    public boolean canPartition(int k, int currentSum, int index) {
        if (k == 1) return true;
        if (currentSum == ave) return canPartition(k - 1, 0, 0);

        for (int i = index; i < nums.length; i++) {
            if (!visited[i] && (currentSum + nums[i]) <= ave) {
                visited[i] = true;
                if (canPartition(k, currentSum + nums[i], i+1))
                    return true;
                visited[i] = false;
            }
        }

        return false;
    }
}
