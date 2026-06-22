class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val requiredMap = createRequiredHashmap(s1)
        val requiredWindowSize = s1.length
        val currentWindowMap = hashMapOf<Char, Int>()
        var i = 0

        for (j in s2.indices) {
            currentWindowMap[s2[j]] = currentWindowMap.getOrDefault(s2[j], 0) + 1

            if (currentWindowMap == requiredMap) {
                return true
            }

            val currentWindowSize = j - i + 1

            if (currentWindowSize == requiredWindowSize) {
                currentWindowMap[s2[i]] = currentWindowMap.getValue(s2[i]) - 1
                if (currentWindowMap[s2[i]] == 0) {
                    currentWindowMap.remove(s2[i])
                }
                i++
            }
        }

        return false
    }

    private fun createRequiredHashmap(s1: String): HashMap<Char, Int> {
        val requiredMap = hashMapOf<Char, Int>()

        for (char in s1) {
            requiredMap[char] = requiredMap.getOrDefault(char, 0) + 1
        }

        return requiredMap
    }
}
