class Solution {
    // fun twoSum(nums: IntArray, target: Int): IntArray {
    //     val partnerIndexMap = mutableMapOf<Int, Int>()

    //     for ((index, num) in nums.withIndex()) {
    //         val partnerKey = target - num
    //         if (partnerIndexMap.containsKey(partnerKey)) {
    //             continue
    //         }

    //         partnerIndexMap.set(partnerKey, index)
    //     }

    //     var answer: IntArray = intArrayOf()

    //     for ((index, num) in nums.withIndex()) {
    //         if (partnerIndexMap.containsKey(num)) {
    //             val partnerIndex = partnerIndexMap.getValue(num)
    //             if (partnerIndex < index) {
    //                 answer = intArrayOf(partnerIndex, index)
    //             } else {
    //                 answer = intArrayOf(index, partnerIndex)
    //             }
    //         }
    //     }

    //     return answer
    // }
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val elementIndexMap = mutableMapOf<Int, Int>()
        
        for ((index, num) in nums.withIndex()) {
            val desiredPartner = target - num
            if (elementIndexMap.containsKey(desiredPartner)) {
                val desiredPartnerIndex = elementIndexMap.getValue(desiredPartner)
                return intArrayOf(desiredPartnerIndex, index)
            }
            
            if (!elementIndexMap.containsKey(num)) {
                elementIndexMap.put(num, index)
            }
        }

        return intArrayOf()
    }

}
