//
//  161. One Edit Distance.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/12/05.
//

// TODO: not solved yet

import Foundation


func isOneEditDistance(_ s: String, _ t: String) -> Bool {
    var sIndex = 0
    var tIndex = 0
    var sChars = Array(s)
    var tChars = Array(t)
    let sLength = s.count
    let tLength = t.count
    
    if s.isEmpty { return tLength == 1 }
    if t.isEmpty { return sLength == 1 }
    
    if sLength + 1 == tLength {
        while tIndex < tLength {
            if sChars[sIndex] == tChars[tIndex] {
                sIndex += 1
                tIndex += 1
            } else {
                sIndex += 1
            }
            return sIndex == tIndex
        }
    } else if sLength == tLength + 1  {
        while sIndex < sLength {
            if sChars[sIndex] == tChars[tIndex] {
                sIndex += 1
                tIndex += 1
            } else {
                tIndex += 1
            }
            return sIndex == tIndex
        }
    }
    
    if sLength == tLength {
        var count = 0
        while sIndex < sLength {
            if sChars[sIndex] != tChars[tIndex] {
                count += 1
            }
            sIndex += 1
            tIndex += 1
        }
        return count == 1
    }
    return false
}
