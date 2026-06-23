class Solution {
    fun findDuplicate(nums: IntArray): Int {
        val seen = mutableSetOf<Int>()

        for (num in nums) {
            if (num in seen) return num
            seen.add(num)
        }

        return 0
    }
}
