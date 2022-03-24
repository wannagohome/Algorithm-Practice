//
//  MinimumDominoRotationsForEqualRow.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/24.
//

struct MinimumDominoRotationsForEqualRow {
    func minDominoRotations(_ tops: [Int], _ bottoms: [Int]) -> Int {
        var topCount: [Int] = Array(repeating: 0, count: 7)
        var bottomCount: [Int] = Array(repeating: 0, count: 7)
        var sameCount: [Int] = Array(repeating: 0, count: 7)
        
        for i in 0 ..< tops.count {
            topCount[tops[i]] += 1
            bottomCount[bottoms[i]] += 1
            if tops[i] == bottoms[i] {
                sameCount[tops[i]] += 1
            }
        }
        
        for i in 1 ... 6 {
            if topCount[i] + bottomCount[i] - sameCount[i] == tops.count {
                return min(topCount[i], bottomCount[i]) - sameCount[i]
            }
        }
        
        return -1
    }
}
