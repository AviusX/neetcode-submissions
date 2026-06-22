class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        val result = IntArray(nums.size * 2)
        for ((index, el) in nums.withIndex()) {
            result[index] = el
            result[index + nums.size] = el
        }
        
        return result
    }
}
