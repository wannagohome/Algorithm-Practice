//
//  328. Odd Even Linked List.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/12/06.
//

// TODO: not solved yet

import Foundation

func oddEvenList(_ head: ListNode?) -> ListNode? {
    var lastNode: ListNode? = nil
    var lastOddNode: ListNode? = nil
    var firstEvenNode: ListNode? = nil
    var node = head
    
    while node != nil {
        if node!.val % 2 == 1 {
            lastNode?.next = node?.next
            lastOddNode?.next = node
            
            lastOddNode = node
            
            lastNode = node
            node = node?.next
        } else {
            if firstEvenNode == nil { firstEvenNode = node }
            
            lastNode = node
            node = node?.next
        }
    }
    
    return node
}
