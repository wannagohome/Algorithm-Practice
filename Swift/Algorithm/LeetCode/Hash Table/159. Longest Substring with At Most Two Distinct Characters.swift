//
//  159. Longest Substring with At Most Two Distinct Characters.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/12/05.
//

import Foundation

struct N159 {
    func lengthOfLongestSubstringTwoDistinct(_ s: String) -> Int {
        let chars = Array(s)
        var left = 0
        var right = 0
        var dic: [Character: Int] = [:]
        var answer = 0
        
        let length = s.count
        if length < 3 { return length }
        while right < length {
            
            dic[chars[right]] = right + 1
            right += 1

            if dic.count > 2 {
                let index = dic.values.min()!
                left = index
                dic[chars[index - 1]] = nil
            }
            
            answer = max(answer, right - left)
        }
        return answer
    }
}
