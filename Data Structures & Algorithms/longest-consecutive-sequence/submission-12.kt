typealias SequenceMap = MutableMap<Int, MutableList<Int>>

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numsSet = nums.toMutableSet()
        val sequenceStarterMap = getSequenceStarterMap(nums, numsSet)

        for (sequenceStarter in sequenceStarterMap.keys) {
            numsSet.remove(sequenceStarter)
            var nextRequiredNumber = sequenceStarter + 1

            while (numsSet.contains(nextRequiredNumber)) {
                sequenceStarterMap.getValue(sequenceStarter).add(nextRequiredNumber)
                numsSet.remove(nextRequiredNumber)
                nextRequiredNumber += 1
            }
        }

        var longestSequence = 0

        for (value in sequenceStarterMap.values) {
            if (value.size > longestSequence) longestSequence = value.size
        }

        return longestSequence
    }

    private fun getSequenceStarterMap(nums: IntArray, numsSet: MutableSet<Int>): SequenceMap {
        val sequenceStarterMap: SequenceMap = mutableMapOf()

        for (num in nums) {
            if (!numsSet.contains(num - 1)) {
                sequenceStarterMap.put(num, mutableListOf(num))
            }
        }

        return sequenceStarterMap
    }

    private fun updateMapKey(map: SequenceMap, oldKey: Int, newKey: Int) {
        val oldValue = map.remove(oldKey)
        if (oldValue.isNullOrEmpty()) {
            throw Error("$oldKey does not map to any value")
        }
        map.put(newKey, oldValue)
    }
}
