class Solution {
    fun missingNumber(nums: IntArray): Int {
        val numSet = nums.toSet()
        val maxNum = numSet.max()
 
        for (num in 0..maxNum) {
            if (num !in numSet) return num
        }
        
        return maxNum + 1
    }
}
