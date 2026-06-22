class Solution {
    fun countBits(n: Int): IntArray {
        val result = mutableListOf<Int>()
        
        for (num in 0..n) {
            result.add(countOnes(num))
        }
        
        return result.toIntArray()
    }

    private fun countOnes(num: Int): Int {
        var result = 0
        var number = num

        while (number != 0) {
            number = number and number - 1
            result++
        }
        
        return result
    }
}
