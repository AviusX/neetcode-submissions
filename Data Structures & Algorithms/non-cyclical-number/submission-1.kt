class Solution {
    fun isHappy(n: Int): Boolean {
        val seenResults = mutableSetOf<Int>()
        var currentNum = n

        while (true) {
            val digits = extractDigits(currentNum)
            val sum = digits.sumOf { it * it }
            if (sum == 1) {
                return true
            } else if (sum in seenResults) {
                return false
            }

            seenResults.add(sum)
            currentNum = sum
        }
    }

    private fun extractDigits(num: Int): List<Int> {
        val digits = mutableListOf<Int>()
        var remainingNum = num
        while (remainingNum > 0) {
            digits.add(remainingNum % 10)
            remainingNum /= 10
        }
        return digits
    }
}
