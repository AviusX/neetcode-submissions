class Solution {
    fun maxProfit(prices: IntArray): Int {
        var i = prices.lastIndex - 1
        var j = prices.lastIndex
        var maxProfit = 0

        while (i != -1) {
            val profit = calculateProfit(prices, i, j)
            if (profit > 0) {
                maxProfit = Math.max(profit, maxProfit)
            } else if (profit < 0) {
                j = i
            }
            i--
        }

        return maxProfit
    }

    private fun calculateProfit(prices: IntArray, i: Int, j: Int): Int {
        return prices[j] - prices[i]
    }
}
