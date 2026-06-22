class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val isRotated = nums.first() > nums.last()

        if (isRotated) {
            val pivotIndex = searchPivot(nums)
            if (target >= nums[pivotIndex] && target <= nums.last()) return binarySearch(
                nums,
                pivotIndex,
                nums.lastIndex,
                target
            )
            else return binarySearch(nums, 0, pivotIndex - 1, target)
        }

        return binarySearch(nums, 0, nums.lastIndex, target)
    }

    private fun searchPivot(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2

            if (nums[mid] > nums.last()) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return left
    }

    private fun binarySearch(nums: IntArray, left: Int, right: Int, target: Int): Int {
        if (left > right) return -1
        val mid = left + (right - left) / 2

        if (nums[mid] == target) return mid

        return if (target < nums[mid]) {
            binarySearch(nums, left, mid - 1, target)
        } else {
            binarySearch(nums, mid + 1, right, target)
        }
    }
}
