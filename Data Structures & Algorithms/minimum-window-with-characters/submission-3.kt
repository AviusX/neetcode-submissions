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
        var shortestLeft: Int? = null
        var shortestRight: Int? = null
        var formedCharSet = mutableSetOf<Char>()

        for ((right, currentChar) in s.withIndex()) {
            if (currentChar in requiredCharSet) {
                currentSubstringMap[currentChar] = currentSubstringMap.getOrDefault(currentChar, 0) + 1
                if (currentSubstringMap[currentChar]!! >= requiredMap[currentChar]!!) {
                    formedCharSet.add(currentChar)
                }
            }

            while (isCurrentSubstringValid(formedCharSet, requiredCharSet)) {
                if (
                    (shortestLeft == null || shortestRight == null) ||
                    right - left + 1 < shortestRight - shortestLeft + 1
                ) {
                    shortestLeft = left
                    shortestRight = right
                }

                if (s[left] in requiredCharSet) {
                    currentSubstringMap[s[left]] = currentSubstringMap.getValue(s[left]) - 1
                    if (currentSubstringMap[s[left]]!! < requiredMap[s[left]]!!) {
                        formedCharSet.remove(s[left])
                    }
                }
                left++
            }
        }

        if (shortestLeft != null && shortestRight != null) {
            return s.slice(shortestLeft..shortestRight)
        } else {
            return ""
        }
    }

    private fun isCurrentSubstringValid(
        formedCharSet: MutableSet<Char>,
        requiredCharSet: MutableSet<Char>
    ): Boolean {
        return formedCharSet.size == requiredCharSet.size
    }
}
