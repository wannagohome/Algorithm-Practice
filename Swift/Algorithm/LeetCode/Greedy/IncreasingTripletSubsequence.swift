//
//  IncreasingTripletSubsequence.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/25.
//

struct IncreasingTripletSubsequence {
    func increasingTriplet(_ nums: [Int]) -> Bool {
        var min = Int.max
        var max = Int.max
        for n in nums {
            if n <= min { min = n }
            else if n <= max { max = n }
            else { return true }
        }
        return false
    }
}
