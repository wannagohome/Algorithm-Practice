//
//  FindTheDuplicateNumber.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/29.
//

struct FindTheDuplicateNumber {
    func findDuplicate(_ nums: [Int]) -> Int {
        var left = 1
        var right = nums.count - 1
        var mid = 0
        var min = nums.count - 1
        
        while left <= right {
            mid = (left + right) / 2
            
            if mid < nums.filter({ $0 <= mid }).count {
                min = Swift.min(min, mid)
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        
        return min
    }
}
