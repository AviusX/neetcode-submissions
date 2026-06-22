class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        if (s.isEmpty()) return 0
        
        val countMap = mutableMapOf<Char, Int>()
        var left = 0
        var longestSubstring = 0
        var mostFrequentCharLength = 0
        
        for (right in s.indices) {
            val currentChar = s[right]
            countMap[currentChar] = countMap.getOrDefault(currentChar, 0) + 1
            mostFrequentCharLength = Math.max(mostFrequentCharLength, countMap.getValue(currentChar))
            
            if (right - left + 1 - mostFrequentCharLength > k) {
                countMap[s[left]] = countMap.getValue(s[left]) - 1
                left++
            }
            
            longestSubstring = Math.max(right - left + 1, longestSubstring)
        }
        
        return longestSubstring
    }
}
