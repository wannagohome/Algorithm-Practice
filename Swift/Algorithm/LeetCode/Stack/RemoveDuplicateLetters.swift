//
//  RemoveDuplicateLetters.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/24.
//

struct RemoveDuplicateLetters {
    func removeDuplicateLetters(_ s: String) -> String {
        let s = Array(s)
        var answer = [Character]()
        for (i, c) in s.enumerated() {
            if answer.contains(c) {
                continue
            }
            
            while !answer.isEmpty
                    && s.lastIndex(of: answer.last!)! > i
                    && answer.last! > c {
   
                answer.removeLast()
            }
            answer.append(c)
        }
        
        return String(answer)
    }
}
