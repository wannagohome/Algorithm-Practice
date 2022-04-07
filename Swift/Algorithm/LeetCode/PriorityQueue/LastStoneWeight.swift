//
//  LastStoneWeight.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/04/07.
//

struct LastStoneWeight {
    func lastStoneWeight(_ stones: [Int]) -> Int {
        var stones = stones
        
        while stones.count > 1 {
            stones.sort()
            let a = stones.removeLast()
            let b = stones.removeLast()
            if a != b {
                stones.append(abs(a - b))
            }
        }
        
        return stones.first ?? 0
    }
}
