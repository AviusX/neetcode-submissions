class Solution {
    fun isHappy(n: Int): Boolean {
        var slow = n
        var fast = next(next(n))

        while (slow != fast) {
            slow = next(slow)
            fast = next(next(fast))

            if (slow == 1) return true
        }

        return slow == 1
    }

    private fun next(num: Int): Int {
        var current = num
        var sum = 0
        while (current > 0) {
            val currentDigit = current % 10
            sum += currentDigit * currentDigit
            current /= 10
        }
        return sum
    }
}
