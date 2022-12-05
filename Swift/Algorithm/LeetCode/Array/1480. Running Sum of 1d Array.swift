//
//  1480. Running Sum of 1d Array.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/12/05.
//

import Foundation


struct RunningSumOf1dArray {
    func runningSum(_ nums: [Int]) -> [Int] {
        if nums.count == 1 { return nums }
        var result = nums
        var sum = result[0]
        
        for i in 1 ..< nums.count {
            sum += nums[i]
            result[i] = sum
        }
        return result
    }
}
