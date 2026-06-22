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
        var formed = 0

        for ((right, currentChar) in s.withIndex()) {
            if (currentChar in requiredCharSet) {
                currentSubstringMap[currentChar] = currentSubstringMap.getOrDefault(currentChar, 0) + 1
                if (currentSubstringMap[currentChar]!! >= requiredMap[currentChar]!! &&
                    currentSubstringMap[currentChar]!! - 1 < requiredMap[currentChar]!!
                ) {
                    formed++
                }
            }

            while (isCurrentSubstringValid(formed, requiredCharSet.size)) {
                if (
                    (shortestLeft == null || shortestRight == null) ||
                    right - left + 1 < shortestRight - shortestLeft + 1
                ) {
                    shortestLeft = left
                    shortestRight = right
                }

                if (s[left] in requiredCharSet) {
                    currentSubstringMap[s[left]] = currentSubstringMap.getValue(s[left]) - 1
                    if (currentSubstringMap[s[left]]!! < requiredMap[s[left]]!! &&
                        currentSubstringMap[s[left]]!! + 1 >= requiredMap[s[left]]!!
                    ) {
                        formed--
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
        formed: Int,
        required: Int
    ) = formed == required
}
