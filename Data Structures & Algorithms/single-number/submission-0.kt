class Solution {
    fun singleNumber(nums: IntArray): Int {
        val result = nums.reduce {acc, curr -> acc.xor(curr)}
        return result
    }
}
