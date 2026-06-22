class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val evaluationStack = ArrayDeque<Int>(2)

        for (token in tokens) {
            when (token) {
                "+" -> {
                    val (firstOperand, secondOperand) = getOperands(evaluationStack)
                    evaluationStack.addLast(firstOperand + secondOperand)
                }

                "-" -> {
                    val (firstOperand, secondOperand) = getOperands(evaluationStack)
                    evaluationStack.addLast(firstOperand - secondOperand)
                }

                "*" -> {
                    val (firstOperand, secondOperand) = getOperands(evaluationStack)
                    evaluationStack.addLast(firstOperand * secondOperand)
                }

                "/" -> {
                    val (firstOperand, secondOperand) = getOperands(evaluationStack)
                    evaluationStack.addLast(firstOperand / secondOperand)
                }

                else -> {
                    evaluationStack.addLast(token.toInt())
                }
            }
        }

        return evaluationStack.removeLast()
    }

    private fun getOperands(evaluationStack: ArrayDeque<Int>): Pair<Int, Int> {
        val lastOperand = evaluationStack.removeLast()
        val firstOperand = evaluationStack.removeLast()

        return firstOperand to lastOperand
    }
}
