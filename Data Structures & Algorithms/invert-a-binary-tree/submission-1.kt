/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        if (root.left != null || root.right != null) {
            invertTree(root.left)
            invertTree(root.right)
            val leftNode = root.left
            root.left = root.right
            root.right = leftNode
        }

        return root
    }
}
