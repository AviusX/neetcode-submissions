import java.util.Stack

class Solution {
    fun isValid(s: String): Boolean {
        val parenthesesMap = mapOf(
            '}' to '{',
            ')' to '(',
            ']' to '['
        )
        val openParentheses = setOf('[', '(', '{')
        val openParenthesesStack = Stack<Char>()

        s.forEach { parentheses ->
            if (parentheses in openParentheses) {
                openParenthesesStack.push(parentheses)
            } else {
                if (openParenthesesStack.isEmpty()) return false
                if (openParenthesesStack.peek() != parenthesesMap[parentheses]) return false
                openParenthesesStack.pop()
            }
        }

        return openParenthesesStack.isEmpty()
    }
}
