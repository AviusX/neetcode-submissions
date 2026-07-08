/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) return 1

        val leftSubtreeDepth = inorder(root.left, 2)
        val rightSubtreeDepth = inorder(root.right, 2)

        return leftSubtreeDepth.coerceAtLeast(rightSubtreeDepth)
    }

    private fun inorder(root: TreeNode?, currentDepth: Int): Int {
        if (root == null) return currentDepth - 1

        val leftSubtreeDepth = inorder(root.left, currentDepth + 1)
        val rightSubtreeDepth = inorder(root.right, currentDepth + 1)

        return leftSubtreeDepth.coerceAtLeast(rightSubtreeDepth)
    }
}
