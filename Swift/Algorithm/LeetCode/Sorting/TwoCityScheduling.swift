//
//  TwoCityScheduling.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/25.
//

struct TwoCityScheduling {
    func twoCitySchedCost(_ costs: [[Int]]) -> Int {
        let aSum = costs.reduce(0) { i, array in
            i + array[0]
        }
        
        return aSum + costs.map { $0[1] - $0[0] }
            .sorted()
            .dropLast(costs.count / 2)
            .reduce(0, +)
    }
}
