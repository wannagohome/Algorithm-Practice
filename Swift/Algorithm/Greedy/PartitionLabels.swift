//
//  PartitionLabels.swift
//  Algorithm
//
//  Created by CW on 2022/03/23.
//

import Foundation

struct PartitionLabels {
    func partitionLabels(_ s: String) -> [Int] {
        let maxIndices = maxIndices(s)
        var answer: [Int] = []
        var max = -1, prev = -1
        
        s.enumerated().forEach { i, c in
            if max == -1 {
                max = maxIndices[c]!
            }
            
            if i > max {
                answer.append(max - prev)
                prev = max
                max = Swift.max(maxIndices[c]!, max)
                return
            }
            
            if i == max {
                answer.append(max - prev)
                prev = max
                max = -1
                return
            }
            max = Swift.max(maxIndices[c]!, max)
        }
        
        return answer
    }
    
    private func maxIndices(_ s: String) -> [Character: Int] {
        var dic: [Character: Int] = [:]
        s.enumerated().forEach { i, c in
            dic[c] = i
        }
        return dic
    }
}
