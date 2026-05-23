class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var fullProduct = 1
        var hasZero = false
        var hasMultipleZeroes = false
        for (num in nums) {
            if (num == 0) {
                if (!hasZero) {
                    hasZero = true
                } else {
                    hasMultipleZeroes = true
                }
                continue
            }
            fullProduct *= num
        }
        
        return nums.map { 
            if (it == 0) {
                if (hasMultipleZeroes) 0 else fullProduct
            } else {
                if (hasZero) 0 else fullProduct / it
            }
        }.toIntArray()
    }
}
