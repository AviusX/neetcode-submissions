class Solution {
    fun minWindow(s: String, t: String): String {
        val requiredCharSet = mutableSetOf<Char>()
        val requiredMap = mutableMapOf<Char, Int>()
        t.forEach { char ->
            requiredCharSet.add(char)
            requiredMap[char] = requiredMap.getOrDefault(char, 0) + 1
        }

        val currentSubstringMap = mutableMapOf<Char, Int>()
        var left = 0
        var shortestSubstring = ""
        for ((right, currentChar) in s.withIndex()) {
            if (currentChar in requiredCharSet) {
                currentSubstringMap[currentChar] = currentSubstringMap.getOrDefault(currentChar, 0) + 1
            }

            while (isCurrentSubstringValid(currentSubstringMap, requiredMap)) {
                if (shortestSubstring.isEmpty() || right - left + 1 < shortestSubstring.length) {
                    shortestSubstring = s.slice(left..right)
                }

                if (s[left] in requiredCharSet) {
                    currentSubstringMap[s[left]] = currentSubstringMap.getValue(s[left]) - 1
                    if (currentSubstringMap[s[left]] == 0) {
                        currentSubstringMap.remove(s[left])
                    }
                }
                left++
            }
        }

        return shortestSubstring
    }

    private fun isCurrentSubstringValid(
        currentSubstringMap: MutableMap<Char, Int>,
        requiredMap: MutableMap<Char, Int>
    ): Boolean {
        for (key in requiredMap.keys) {
            if (currentSubstringMap.getOrDefault(key, 0) < requiredMap.getOrDefault(key, 0))
                return false
        }
        return true
    }
}
