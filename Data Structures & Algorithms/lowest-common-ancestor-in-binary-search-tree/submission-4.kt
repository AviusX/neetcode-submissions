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

        var curr: TreeNode = root

        while (true) {
            if (p.`val` < curr.`val` && q.`val` < curr.`val`) {
                curr = curr.left!!
                continue
            }

            if (p.`val` > curr.`val` && q.`val` > curr.`val`) {
                curr = curr.right!!
                continue
            }

            break
        }

        return curr
    }
}
