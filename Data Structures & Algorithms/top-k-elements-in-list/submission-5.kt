class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
    	val frequencyMap = mutableMapOf<Int, Int>()

     	for (num in nums) {
      		if (frequencyMap.containsKey(num)) {
        		frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        	} else {
                frequencyMap.put(num, 1)
            }
      	}

        // sort most frequent numbers using bucket sort
        val buckets = MutableList(nums.size) { mutableListOf<Int>() }
        for (num in frequencyMap.keys) {
            val frequency = frequencyMap.getValue(num)
            val frequencyIndex = frequency - 1
            buckets[frequencyIndex].add(num)
        }

        // filter out empty buckets and flatten
        var answer = buckets.filter { it.isNotEmpty() }.flatten()
        return answer.takeLast(k).toIntArray()
    }
}
