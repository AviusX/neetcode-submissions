class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length !== t.length) return false

        val sMap = mutableMapOf<Char, Int>()
        val tMap = mutableMapOf<Char, Int>()

        for (letter in s) {
            if (sMap.containsKey(letter)) {
                val letterCount = sMap.getValue(letter)
                sMap.put(letter, letterCount + 1)
            } else {
                sMap.put(letter, 1)
            }
        }

        for (letter in t) {
            if (tMap.containsKey(letter)) {
                val letterCount = tMap.getValue(letter)
                tMap.put(letter, letterCount + 1)
            } else {
                tMap.put(letter, 1)
            }
        }

        return sMap.equals(tMap)
    }
}
