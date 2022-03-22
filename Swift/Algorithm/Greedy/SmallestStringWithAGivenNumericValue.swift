//
//  SmallestStringWithAGivenNumericValue.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/22.
//

struct SmallestStringWithAGivenNumericValue {
    func getSmallestString(_ n: Int, _ k: Int) -> String {
        var answer = [String](repeating: "a", count: n)
        var count = k - n
        var index = answer.count - 1
        
        while(count > 0) {
            answer[index] = String(UnicodeScalar(UInt8(97 + min(25, count))))
            count -= min(25, count)
            index -= 1
        }
        
        return answer.joined()
    }
}
