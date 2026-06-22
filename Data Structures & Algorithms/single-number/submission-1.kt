class Solution {
    fun singleNumber(nums: IntArray): Int {
        return nums.reduce {acc, curr -> acc.xor(curr)}
    }
}
