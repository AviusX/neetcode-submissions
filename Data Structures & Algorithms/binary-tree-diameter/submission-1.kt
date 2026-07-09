/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
typealias NodeDepthMap = MutableMap<TreeNode, Pair<Int?, Int?>>

class Solution {
    private var diameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        depth(root)
        return diameter
    }
    
    private fun depth(root: TreeNode?): Int {
        if (root == null) return 0
        
        val left = depth(root.left)
        val right = depth(root.right)
        
        diameter = maxOf(diameter, left + right)
        
        return 1 + maxOf(left, right)
    }
}
