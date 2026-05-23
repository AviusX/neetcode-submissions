class Solution {
    val letterIndexMap: MutableMap<Char, Int>

    constructor() {
        this.letterIndexMap = mutableMapOf()
        for ((index, char) in ('a'..'z').withIndex()) {
            letterIndexMap.put(char, index)
        }
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groupMap = mutableMapOf<MutableList<Int>, MutableList<String>>()

        for (str in strs) {
            val strKey = generateKey(str)
            if (groupMap.containsKey(strKey)) {
                groupMap.getValue(strKey).add(str)
            } else {
                groupMap.put(strKey, mutableListOf(str))
            }
        }

        return groupMap.values.toList()
    }

    fun generateKey(str: String): MutableList<Int> {
        val keyArray = MutableList(26) { 0 }
        for (char in str) {
            val characterIndex = letterIndexMap.getValue(char)
            keyArray[characterIndex] = keyArray[characterIndex] + 1
        }
        return keyArray
    }
}
