class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val sMap = mutableMapOf<Char, Int>()
        val tMap = mutableMapOf<Char, Int>()

        for (letter in s) {
            sMap[letter] = sMap.getOrDefault(letter, 0) + 1
        }

        for (letter in t) {
            tMap[letter] = tMap.getOrDefault(letter, 0) + 1
        }

        return sMap.equals(tMap)
    }
}
