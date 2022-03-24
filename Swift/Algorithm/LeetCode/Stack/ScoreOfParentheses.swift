//
//  ScoreOfParentheses.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/24.
//

import Foundation

struct ScoreOfParentheses {
    func scoreOfParentheses(_ s: String) -> Int {
        var stack = [Int]()
        for c in s {
            if c == "(" {
                stack.append(-1)
                continue
            }
            
            if stack.last == -1 {
                stack.removeLast()
                stack.append(1)
            } else {
                var num = 0
                while stack.last ?? -1 > 0 {
                    num += stack.removeLast()
                }
                stack.removeLast()
                stack.append(num * 2)
            }
        }
        
        return stack.reduce(0, +)
    }
}
