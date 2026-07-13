/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return listOf()

        val deque = ArrayDeque<Pair<TreeNode, Int>>() // Pair(TreeNode, Level of node)
        val result = mutableListOf<Int>()
        var level = 1
        deque.addLast(Pair(root, level))

        while (deque.isNotEmpty()) {
            level++

            for (i in deque.indices) {
                val (currNode, currLevel) = deque.removeFirst()
                val nextLevel = if (deque.isNotEmpty()) deque.first().second else null

                if (nextLevel == null || nextLevel > currLevel) {
                    result.add(currNode.`val`)
                }

                if (currNode.left != null) {
                    deque.addLast(Pair(currNode.left!!, level))
                }

                if (currNode.right != null) {
                    deque.addLast(Pair(currNode.right!!, level))
                }
            }
        }

        return result
    }
}
