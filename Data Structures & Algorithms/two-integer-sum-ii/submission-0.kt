class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var leftPointer = 0
        var rightPointer = numbers.size - 1
        var solution = intArrayOf()

        while (leftPointer < rightPointer) {
            val sum = numbers[leftPointer] + numbers[rightPointer]

            if (sum == target) {
                solution = intArrayOf(leftPointer + 1, rightPointer + 1)
                break
            } else if (sum > target) {
                rightPointer -= 1
                continue
            } else {
                leftPointer += 1
                continue
            }
        }

        return solution
    }
}
