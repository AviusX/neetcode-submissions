class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (nums.size < 2 || k == 0) return false

        val windowElements = mutableSetOf<Int>()
        var i = 0
        
        windowElements.add(nums[i])
        
        for (j in 1..nums.lastIndex) {
            if (j - i > k) {
                windowElements.remove(nums[i])
                i++
                
                if (i == j) continue
            }
            
            if (windowElements.contains(nums[j])) return true
            else windowElements.add(nums[j])
        }
        
        return false
    }
}
