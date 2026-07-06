/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null

        if (key < root.`val`) {
            root.left = deleteNode(root.left, key)
        } else if (key > root.`val`) {
            root.right = deleteNode(root.right, key)
        } else {
            when {
                root.left == null -> {
                    return root.right
                }

                root.right == null -> {
                    return root.left
                }

                else -> {
                    val minInRightSubtree = findMinInSubtree(root.right!!)
                    root.`val` = minInRightSubtree
                    root.right = deleteNode(root.right, minInRightSubtree)
                }
            }
        }

        return root
    }

    private fun findMinInSubtree(root: TreeNode): Int {
        var curr = root

        while (curr.left != null) {
            curr = curr.left!!
        }

        return curr.`val`
    }
}
