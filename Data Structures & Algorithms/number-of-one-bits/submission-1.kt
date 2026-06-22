class Solution {
    fun hammingWeight(n: Int): Int {
        var result = 0
        var number = n
        while (number != 0) {
            number = number and number - 1
            result += 1
        }
        return result
    }
}
