//
//  SearchA2DMatrixII.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/30.
//

struct SearchA2DMatrixII {
    func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {
        for nums in (matrix.filter {
            $0.first ?? Int.min <= target && target <= $0.last ?? Int.min
        }) {
            var left = 0
            var right = nums.count - 1
            var mid = (left + right) / 2
            
            while left <= right {
                mid = (left + right) / 2
                if nums[mid] < target {
                    left = mid + 1
                } else if nums[mid] > target {
                    right = mid - 1
                } else {
                    return true
                }
            }
        }
        
        return false
    }
}
