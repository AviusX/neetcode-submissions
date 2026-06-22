class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val evaluationStack = ArrayDeque<Int>(2)

        for (token in tokens) {
            if (token in setOf("+", "-", "*", "/")) {
                val b = evaluationStack.removeLast()
                val a = evaluationStack.removeLast()

                when (token) {
                    "+" -> evaluationStack.addLast(a + b)
                    "-" -> evaluationStack.addLast(a - b)
                    "*" -> evaluationStack.addLast(a * b)
                    "/" -> evaluationStack.addLast(a / b)
                }
            } else {
                evaluationStack.addLast(token.toInt())
            }
        }

        return evaluationStack.removeLast()
    }
}
