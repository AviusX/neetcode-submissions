class Solution {
    fun findMin(nums: IntArray): Int {
        val isRotated = nums.last() < nums.first()
        if (!isRotated) return nums.first()

        var left = 0
        var right = nums.lastIndex
        var result = Int.MAX_VALUE

        while (left <= right) {
            val mid = left + (right - left) / 2
            
            result = result.coerceAtMost(nums[mid])

            if (nums[mid] > nums.last()) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return result
    }
}
