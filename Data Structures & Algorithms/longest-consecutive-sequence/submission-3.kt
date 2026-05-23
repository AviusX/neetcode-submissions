class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numsSet = nums.toMutableSet()
        var longestSequence = 0
        for (num in numsSet) {
            var sequenceLength = 1
            var lookupNum = num + 1
            while (numsSet.contains(lookupNum)) {
                sequenceLength += 1
                lookupNum += 1
            }
            if (sequenceLength > longestSequence) {
                longestSequence = sequenceLength
            }
        }
        return longestSequence
    }
}
