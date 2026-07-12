/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) return null

        val leftSubtreeResult = lowestCommonAncestor(root.left, p, q)
        val rightSubtreeResult = lowestCommonAncestor(root.right, p, q)
        val isCurrentNodeMatch = root.`val` == p.`val` || root.`val` == q.`val`

        return when {
            isCurrentNodeMatch -> root
            leftSubtreeResult != null && rightSubtreeResult != null -> root
            leftSubtreeResult != null -> leftSubtreeResult
            rightSubtreeResult != null -> rightSubtreeResult

            else -> null
        }
    }
}
