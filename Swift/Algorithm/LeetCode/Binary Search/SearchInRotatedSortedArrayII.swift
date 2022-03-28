//
//  SearchInRotatedSortedArrayII.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/28.
//

struct SearchInRotatedSortedArrayII {
    func search(_ nums: [Int], _ target: Int) -> Bool {
        var left = 0
        var right = nums.count - 1
        var mid = 0
        
        while left <= right {
            mid = (left + right) / 2
            if (nums[mid] == target) {
                return true
            }
            
            if nums[left] < nums[mid] {
                if target < nums[left] || target > nums[mid] {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            } else if nums[left] > nums[mid] {
                if target < nums[mid] || target > nums[right] {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else {
                left += 1
            }
            
        }
        return false
    }
}
