typealias PairSet = MutableSet<List<Int>>

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        var i = 0
        val solutions = mutableSetOf<List<Int>>()

        while (i < nums.lastIndex - 1) { // leaving space for j and k
            val allSolutionPairsForI =
                    twoSumWithInjection(nums.slice(i + 1..nums.lastIndex), nums[i] * -1, nums[i])
            solutions.addAll(allSolutionPairsForI)
            val evaluatedNum = nums[i]
            while (nums[i] == evaluatedNum && i < nums.lastIndex - 1) {
                i++
            }
        }

        return solutions.toList()
    }

    private fun twoSumWithInjection(nums: List<Int>, target: Int, injectI: Int): List<List<Int>> {
        var i = 0
        var j = nums.lastIndex
        val solutions = mutableListOf<List<Int>>()

        while (i < j) {
            when {
                nums[i] + nums[j] == target -> {
                    solutions.add(listOf(injectI, nums[i], nums[j]))
                    i++
                    j--
                }
                nums[i] + nums[j] > target -> {
                    val evaluatedNum = nums[j]
                    while (nums[j] == evaluatedNum && j > i) {
                        j--
                    }
                }
                nums[i] + nums[j] < target -> {
                    val evaluatedNum = nums[i]
                    while (nums[i] == evaluatedNum && i < j) {
                        i++
                    }
                }
            }
        }

        return solutions
    }
}
