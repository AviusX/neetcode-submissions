/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if ((root == null && subRoot == null) || subRoot == null) return true

        val matchingNodes = mutableListOf<TreeNode>()
        searchNode(root, subRoot.`val`, matchingNodes)
 
        return matchingNodes.any { isSameTree(it, subRoot) }
    }

    private fun searchNode(root: TreeNode?, searchValue: Int, matches: MutableList<TreeNode>) {
        if (root == null) return
        if (root.`val` == searchValue) {
            matches.add(root)
        }

        searchNode(root.left, searchValue, matches)
        searchNode(root.right, searchValue, matches)
    }

    private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true

        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right) && p?.`val` == q?.`val`
    }
}
