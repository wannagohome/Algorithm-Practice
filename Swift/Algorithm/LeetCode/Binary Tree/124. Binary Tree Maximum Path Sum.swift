//
//  124. Binary Tree Maximum Path Sum.swift
//  Algorithm
//
//  Created by Jinho Jang on 2022/12/11.
//

import Foundation

public class TreeNode {
    public var val: Int
    public var left: TreeNode?
    public var right: TreeNode?
    public init() { self.val = 0; self.left = nil; self.right = nil; }
    public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
    public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
        self.val = val
        self.left = left
        self.right = right
    }
}

class BinaryTreeMaximumPathSum {
    private var max: Int = Int.min
    
    func maxPathSum(_ root: TreeNode?) -> Int {
        // max path include node it self ->
        // max ( max path include left, max path include right ) + self value
        
        maxPathSumInclude(root!)
        return max
    }
    
    @discardableResult
    private func maxPathSumInclude(_ node: TreeNode?) -> Int {
        guard let node = node else { return Int.min }
        
        let rightSum = maxPathSumInclude(node.right)
        let leftSum = maxPathSumInclude(node.left)
        max = [max, rightSum + node.val, leftSum + node.val, node.val, leftSum + rightSum + node.val].max()!
        
        if node.left == nil && node.right == nil {
            max = Swift.max(max, node.val)
            
            return node.val
        }
        
        if node.left == nil, let right = node.right {
            let rightSum = maxPathSumInclude(right)
            let sum = Swift.max(rightSum + node.val, node.val)
            
            max = Swift.max(max, sum, node.val)
            
            return sum
        }
        
        if let left = node.left, node.right == nil {
            let leftSum = maxPathSumInclude(left)
            let sum = Swift.max(leftSum + node.val, node.val)
            
            max = Swift.max(max, sum, node.val)
            
            return sum
        }
        
        if let left = node.left, let right = node.right {
            let leftSum = maxPathSumInclude(left)
            let rightSum = maxPathSumInclude(right)
            let sum = Swift.max(leftSum + node.val, rightSum + node.val, node.val)
            
            max = Swift.max(max, sum, leftSum + rightSum + node.val, node.val)
            
            return sum
        }
        
        return 0
    }
}
