/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
        fun copyRandomList(head: Node?): Node? {
        if (head == null) return null
        val copiedNodes = mutableMapOf<Node, Node>()
        val copiedHead = copyNode(head, copiedNodes)

        updateRandoms(head, copiedHead, copiedNodes)

        return copiedHead
    }

    private fun copyNode(node: Node, copiedNodes: MutableMap<Node, Node>): Node {
        if (node.next == null) {
            val newNode = Node(node.`val`)
            copiedNodes[node] = newNode
            return newNode
        }
        val nextNode = copyNode(node.next!!, copiedNodes)

        val newNode = Node(node.`val`)
        newNode.next = nextNode

        copiedNodes[node] = newNode

        return newNode
    }

    private fun updateRandoms(originalHead: Node, copiedHead: Node, copiedNodes: MutableMap<Node, Node>) {
        var originalCurr: Node? = originalHead
        var newCurr: Node? = copiedHead

        while (newCurr != null) {
            newCurr.random = copiedNodes[originalCurr!!.random]
            originalCurr = originalCurr.next
            newCurr = newCurr.next
        }
    }
}