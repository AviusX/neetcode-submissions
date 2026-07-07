/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()

        if (root == null) return result
        bfs(root, result)
        return result
    }

    private fun bfs(root: TreeNode, result: MutableList<MutableList<Int>>) {
        val deque = ArrayDeque<TreeNode>()
        deque.addLast(root)

        while (deque.size > 0) {
            val levelValues = mutableListOf<Int>()

            for (i in deque.indices) {
                val curr = deque.removeFirst()

                levelValues.add(curr.`val`)

                if (curr.left != null) {
                    deque.addLast(curr.left!!)
                }
                if (curr.right != null) {
                    deque.addLast(curr.right!!)
                }
            }

            result.add(levelValues)
        }
    }
}
