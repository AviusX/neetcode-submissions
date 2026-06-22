class Solution {
    fun maxProfit(prices: IntArray): Int {
        var i = prices.lastIndex - 1
        var j = prices.lastIndex
        var maxProfit = 0

        while (i != -1) {
            val profit = prices[j] - prices[i]
            if (profit > 0) {
                maxProfit = Math.max(profit, maxProfit)
            } else if (profit < 0) {
                j = i
            }
            i--
        }

        return maxProfit
    }
}
