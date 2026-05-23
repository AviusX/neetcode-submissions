class Solution {

    fun encode(strs: List<String>): String {
    	val delimiters = strs.map {
            "%" + it.length + "%"
        }
        return delimiters.zip(strs).flatMap { listOf(it.first, it.second) }.joinToString("")
    }

    fun decode(str: String): List<String> {
        val regex = Regex("%\\d+%")
        val matches = regex.findAll(str)
        val constructedArray = mutableListOf<String>()
        
        
        for (match in matches) {
            val delimValue = match.value.split("%")[1].toInt()
            println("delimValue: $delimValue")
            println(match.range.endInclusive)
            
            if (delimValue == 0) {
                constructedArray.add("")
            } else {
                val startIndex = match.range.endInclusive + 1
                val endIndex = startIndex + delimValue
                constructedArray.add(str.substring(startIndex, endIndex))
            }
        }
        
        return constructedArray
    }
}
