//
//  TheNumberOfWeakCharactersInTheGame.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/25.
//

struct TheNumberOfWeakCharactersInTheGame {
    func numberOfWeakCharacters(_ properties: [[Int]]) -> Int {
        var answer = 0
        let properties = properties
            .sorted { $0[0] != $1[0] ? $0[0] > $1[0] : $0[1] < $1[1] }
        
        var max = 0
        for i in 0 ..< properties.count {
            if properties[i][1] < max {
                answer += 1
            }
            max = Swift.max(properties[i][1], max)
        }
        
        return answer
    }
}
