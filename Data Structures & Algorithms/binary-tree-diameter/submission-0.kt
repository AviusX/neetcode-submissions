/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
typealias NodeDepthMap = MutableMap<TreeNode, Pair<Int?, Int?>>

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0

        val nodeDepthMap = mutableMapOf<TreeNode, Pair<Int?, Int?>>() // map of a tree node to left and right subtree depths.
        populateNodeDepthMap(root, nodeDepthMap)
        return nodeDepthMap.values.maxOf { it.first!! + it.second!! }
    }

    private fun populateNodeDepthMap(root: TreeNode?, nodeDepthMap: NodeDepthMap): Int {
        if (root == null) return 0

        val leftSubtreeDepth = if (nodeDepthMap[root]?.first != null) nodeDepthMap[root]!!.first else {
            populateNodeDepthMap(root.left, nodeDepthMap).also {
                if (!nodeDepthMap.containsKey(root)) nodeDepthMap[root] = Pair(it, null)
                else {
                    val rightDepth = nodeDepthMap[root]!!.second
                    nodeDepthMap[root] = it to rightDepth
                }
            }
        }!!
        
        val rightSubtreeDepth = if (nodeDepthMap[root]?.second != null) nodeDepthMap[root]!!.second else {
            populateNodeDepthMap(root.right, nodeDepthMap).also {
                if (!nodeDepthMap.containsKey(root)) nodeDepthMap[root] = Pair(null, it)
                else {
                    val leftDepth = nodeDepthMap[root]!!.first
                    nodeDepthMap[root] = leftDepth to it
                }
            }
        }!!
        
        return 1 + leftSubtreeDepth.coerceAtLeast(rightSubtreeDepth)
    }
}
