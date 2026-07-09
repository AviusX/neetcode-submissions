/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return checkHeightAndBalance(root).second
    }

    private fun checkHeightAndBalance(root: TreeNode?): Pair<Int, Boolean> {
        if (root == null) return Pair(0, true)

        val (leftSubtreeHeight, leftSubtreeBalanced) = checkHeightAndBalance(root.left)
        val (rightSubtreeHeight, rightSubtreeBalanced) = checkHeightAndBalance(root.right)
        val subtreeHeightDifference = abs(leftSubtreeHeight - rightSubtreeHeight)

        return Pair(
            1 + maxOf(leftSubtreeHeight, rightSubtreeHeight),
            leftSubtreeBalanced && rightSubtreeBalanced && subtreeHeightDifference <= 1
        )
    }
}
