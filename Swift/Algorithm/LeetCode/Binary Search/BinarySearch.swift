//
//  BinarySearch.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/26.
//

struct BinarySearch {
    func search(_ nums: [Int], _ target: Int) -> Int {
        var left = 0
        var right = nums.count - 1
        
        if nums.count == 1 {
            return nums[0] == target ? 0 : -1
        }
        
        while left <= right {
            let mid = (right + left) / 2
            if nums[mid] < target {
                left = mid + 1
            } else if nums[mid] > target {
                right = mid - 1
            } else {
                return mid
            }
        }
        
        return -1
    }
}
