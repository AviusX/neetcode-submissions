class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val numSet = hashSetOf<Int>()
        for (num in nums) {
            if (num in numSet) return true
            else numSet.add(num)
        }
        return false
    }
}
