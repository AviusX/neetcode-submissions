class Solution {
    fun maxProfit(prices: IntArray): Int {
        val futureProfitableDays = getProfitableDays(prices)
        var profit: Int = 0

        for ((index, todaysPrice) in prices.withIndex()) {
            val todaysProfit = futureProfitableDays[index] - todaysPrice
            if (todaysProfit > profit) {
                profit = todaysProfit
            }
        }

        return profit
    }

    private fun getProfitableDays(prices: IntArray): MutableList<Int> {
        val futureProfitableDays = MutableList(prices.size) { 0 }
        var max = 0

        for (index in prices.indices.reversed()) {
            futureProfitableDays[index] = max
            max = prices[index].coerceAtLeast(max)
        }

        return futureProfitableDays
    }
}