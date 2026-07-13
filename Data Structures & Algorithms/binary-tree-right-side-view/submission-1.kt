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

        val deque = ArrayDeque<TreeNode>() // Pair(TreeNode, Level of node)
        val result = mutableListOf<Int>()
        deque.addLast(root)

        while (deque.isNotEmpty()) {
            val size = deque.size

            repeat(size) { i ->
                val currNode = deque.removeFirst()
                if (i == size - 1) {
                    result.add(currNode.`val`)
                }
                currNode.left?.let(deque::addLast)
                currNode.right?.let(deque::addLast)
            }
        }

        return result
    }
}
