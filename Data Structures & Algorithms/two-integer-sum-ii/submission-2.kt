class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var leftPointer = 0
        var rightPointer = numbers.size - 1

        while (leftPointer < rightPointer) {
            val sum = numbers[leftPointer] + numbers[rightPointer]

            when {
                sum == target -> return intArrayOf(leftPointer + 1, rightPointer + 1)
                sum > target -> rightPointer--
                sum < target -> leftPointer++
            }
        }

        return intArrayOf()
    }
}
