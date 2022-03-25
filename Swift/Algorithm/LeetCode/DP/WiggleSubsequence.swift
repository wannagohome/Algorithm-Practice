//
//  WiggleSubsequence.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/25.
//

struct WiggleSubsequence {
    func wiggleMaxLength(_ nums: [Int]) -> Int {
        var dp: [Int] = Array(repeating: 1, count: nums.count)
        var isPlus = false
        var countStarted = false
        
        for i in 1 ..< nums.count {
            if !countStarted && nums[i] != nums[i - 1] {
                countStarted = true
                isPlus = nums[i] > nums[i - 1]
                dp[i] = dp[i - 1] + 1
                continue
            }
            
            if nums[i] == nums[i - 1] {
                dp[i] = dp[i - 1] + 1
                continue
            }
            
            if (nums[i] > nums[i - 1]) != isPlus {
                isPlus = !isPlus
                dp[i] = dp[i - 1] + 1
            } else {
                dp[i] = dp[i - 1]
            }
        }
        
        return dp.last!
    }
}
