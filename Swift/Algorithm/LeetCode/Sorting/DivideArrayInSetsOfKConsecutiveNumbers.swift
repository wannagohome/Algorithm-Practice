//
//  DivideArrayInSetsOfKConsecutiveNumbers.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/29.
//

struct DivideArrayInSetsOfKConsecutiveNumbers {
    func isPossibleDivide(_ nums: [Int], _ k: Int) -> Bool {
        if nums.count % k != 0 {
            return false
        }
        var nums = nums.sorted()
        
        while !nums.isEmpty {
            var num = nums.first!
            nums.removeFirst()
            
            for _ in 0 ..< k - 1 {
                if let index = nums.firstIndex(of: num + 1) {
                    nums.remove(at: index)
                    num += 1
                } else {
                    return false
                }
            }
        }
        return true
    }
}
