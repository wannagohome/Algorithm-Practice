//
//  BoatsToSavePeople.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/03/24.
//

struct BoatsToSavePeople {
    func numRescueBoats(_ people: [Int], _ limit: Int) -> Int {
        var answer = 0
        var left = 0
        var right = people.count - 1
        let people = people.sorted()
        
        while left < right {
            if people[left] + people[right] > limit {
                right -= 1
            } else {
                right -= 1
                left += 1
            }
            answer += 1
        }
        
        if left == right {
            answer += 1
        }
        
        return  answer
    }
}
