class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefixArray = computePrefixArray(nums)
        val postfixArray = computePostfixArray(nums)

        val result = IntArray(nums.size)
        for (i in nums.indices) {
            result[i] = prefixArray[i] * postfixArray[i]
        }

        return result
    }

    fun computePrefixArray(nums: IntArray): IntArray {
        val prefixArray = IntArray(nums.size)

        for (i in nums.indices) {
            if (i == 0) {
                prefixArray[i] = 1
            } else if (i == 1) {
                prefixArray[i] = nums[0]
            } else {
                prefixArray[i] = prefixArray[i - 1] * nums[i - 1]
            }
        }

        return prefixArray
    }

    fun computePostfixArray(nums: IntArray): IntArray {
        val postfixArray = IntArray(nums.size)

        for (i in nums.indices.reversed()) {
            if (i == nums.size - 1) {
                postfixArray[i] = 1
            } else if (i == nums.size - 2) {
                postfixArray[i] = nums.last()
            } else {
                postfixArray[i] = postfixArray[i + 1] * nums[i + 1]
            }
        }
        // val reversedNums = nums.reversedArray()
        // return computePrefixArray(reversedNums).reversedArray()
        return postfixArray
    }
}
