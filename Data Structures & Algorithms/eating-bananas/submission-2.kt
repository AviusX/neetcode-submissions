class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.max()
        var result = right

        while (left <= right) {
            var hours = 0.0
            val potentialK = left + (right - left) / 2

            for (pile in piles) {
                hours += ceil(pile.toDouble() / potentialK)
            }

            if (hours > h) {
                left = potentialK + 1
            } else {
                result = result.coerceAtMost(potentialK)
                right = potentialK - 1
            }
        }
        
        return result
    }
}
