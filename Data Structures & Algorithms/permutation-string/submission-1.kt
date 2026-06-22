class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val s1CharFrequencyArray = IntArray(26) { 0 }
        val s2CharFrequencyArray = IntArray(26) { 0 }

        for (i in s1.indices) {
            s1CharFrequencyArray[getCharacterIndex(s1[i])] += 1
            s2CharFrequencyArray[getCharacterIndex(s2[i])] += 1
        }

        var matches = 0
        for (i in 0..<26) {
            matches += if (s1CharFrequencyArray[i] == s2CharFrequencyArray[i]) 1 else 0
        }

        var left = 0
        for (right in s1.length..s2.lastIndex) {
            if (matches == 26) return true

            val rightCharacterIndex = getCharacterIndex(s2[right])
            s2CharFrequencyArray[rightCharacterIndex] += 1

            if (s2CharFrequencyArray[rightCharacterIndex] == s1CharFrequencyArray[rightCharacterIndex]) {
                matches += 1
            } else if (s2CharFrequencyArray[rightCharacterIndex] - 1 == s1CharFrequencyArray[rightCharacterIndex]) {
                matches -= 1
            }

            val leftCharacterIndex = getCharacterIndex(s2[left])
            s2CharFrequencyArray[leftCharacterIndex] -= 1

            if (s2CharFrequencyArray[leftCharacterIndex] == s1CharFrequencyArray[leftCharacterIndex]) {
                matches += 1
            } else if (s2CharFrequencyArray[leftCharacterIndex] + 1 == s1CharFrequencyArray[leftCharacterIndex]) {
                matches -= 1
            }

            left++
        }

        return matches == 26
    }

    private fun getCharacterIndex(character: Char) = character.code - 'a'.code
}
