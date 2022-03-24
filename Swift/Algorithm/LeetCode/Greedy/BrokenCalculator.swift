//
//  BrokenCalculator.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/23.
//

import Foundation

struct BrokenCalculator {
    func brokenCalc(_ startValue: Int, _ target: Int) -> Int {
        if startValue >= target { return startValue - target }
        if target % 2 == 0 { return 1 + brokenCalc(startValue, target / 2) }
        return 1 + brokenCalc(startValue, target + 1)
    }
}
