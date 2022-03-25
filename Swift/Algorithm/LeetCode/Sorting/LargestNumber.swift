//
//  LargestNumber.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/25.
//

import Foundation

struct LargestNumber {
    func largestNumber(_ nums: [Int]) -> String {
        let sorted = nums
            .map { i -> String in String(i) }
            .sorted { ($0 + $1) > ($1 + $0) }
            .joined()
        
        if sorted.first == "0" { return "0" }
        
        return sorted
    }
}
