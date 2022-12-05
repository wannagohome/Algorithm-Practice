//
//  MiddleOfTheLinkedList.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/12/05.
//

/*
 Two pointer 잊지 말자
 */

import Foundation

public class ListNode {
    public var val: Int
    public var next: ListNode?
    public init() { self.val = 0; self.next = nil; }
    public init(_ val: Int) { self.val = val; self.next = nil; }
    public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
}

class Solution {
    func middleNode(_ head: ListNode?) -> ListNode? {
        guard let head = head else { return nil }
        let count = countOf(node: head)
        if count == 1 { return head }
        var node: ListNode? = head
        
        for _ in 1 ... (count / 2) {
            node = node?.next
        }
        return node
    }
    
    private func countOf(node: ListNode) -> Int {
        var count = 1
        var node = node
        while node.next != nil {
            count += 1
            node = node.next!
        }
        return count
    }
    
    func better(_ head: ListNode?) -> ListNode? {
        guard let head = head, head.next == nil else { return head }
        var slow: ListNode? = head
        var fast: ListNode? = head
        
        while true {
            slow = slow?.next
            fast = fast?.next?.next
            if fast == nil || fast?.next == nil {
                return slow
            }
        }
    }
}
