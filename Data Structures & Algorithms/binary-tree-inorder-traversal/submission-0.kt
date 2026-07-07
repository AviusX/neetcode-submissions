/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val inorderValues = mutableListOf<Int>()
        updateInorderValues(root, inorderValues)
        return inorderValues
    }

    private fun updateInorderValues(node: TreeNode?, values: MutableList<Int>) {
        if (node == null) return
        
        updateInorderValues(node.left, values)
        values.add(node.`val`)
        updateInorderValues(node.right, values)
    }
}
