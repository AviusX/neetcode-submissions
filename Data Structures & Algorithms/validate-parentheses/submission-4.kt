import java.util.Stack

class Solution {
        fun isValid(s: String): Boolean {
        val parenthesesMap = mapOf(
            '}' to '{',
            ')' to '(',
            ']' to '['
        )
        val openParentheses = setOf('[', '(', '{')
        val openParenthesesStack = ArrayDeque<Char>()

        s.forEach { parentheses ->
            when (parentheses) {
                '(', '[', '{' -> openParenthesesStack.addLast(parentheses)

                else -> {
                    if (openParenthesesStack.isEmpty()) return false
                    if (openParenthesesStack.last() != parenthesesMap[parentheses]) return false
                    openParenthesesStack.removeLast()
                }
            }
        }

        return openParenthesesStack.isEmpty()
    }
}
