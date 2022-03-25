//
//  ValidateStackSequences.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/25.
//

struct ValidateStackSequences {
    func validateStackSequences(_ pushed: [Int], _ popped: [Int]) -> Bool {
        var pushed = pushed
        var popped = popped
        var stack: [Int] = []
        
        while !popped.isEmpty {
            if stack.last != popped.first {
                if !pushed.isEmpty {
                    stack.append(pushed.removeFirst())
                } else {
                    return false
                }
            } else {
                stack.removeLast()
                popped.removeFirst()
            }
        }
        return true
    }
}
