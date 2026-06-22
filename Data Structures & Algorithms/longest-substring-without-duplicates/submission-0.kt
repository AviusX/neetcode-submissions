class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty() || s.length == 1) {
            return s.length
        }

        val seenChars = mutableSetOf<Char>()
        var left = 0
        var maxLength = 1
        seenChars.add(s[left])

        for (right in 1..s.lastIndex) {
            while (s[right] in seenChars) {
                seenChars.remove(s[left])
                left++
            }
            seenChars.add(s[right])
            maxLength = Math.max(maxLength, right - left + 1)
        }

        return maxLength
    }
}
