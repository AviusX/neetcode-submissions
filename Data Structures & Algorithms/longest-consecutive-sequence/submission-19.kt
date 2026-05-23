typealias SequenceMap = MutableMap<Int, MutableList<Int>>

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numsSet = nums.toMutableSet()
        val sequenceStarters =
                nums.filter {
                    if (it - 1 !in numsSet) {
                        true
                    } else false
                }
        var longestSequence = 0

        for (num in sequenceStarters) {
            var nextRequiredNum = num + 1
            var currentSequenceLength = 1

            while (numsSet.contains(nextRequiredNum)) {
                currentSequenceLength += 1
                nextRequiredNum += 1
            }

            if (currentSequenceLength > longestSequence) {
                longestSequence = currentSequenceLength
            }
        }

        return longestSequence
    }
}
