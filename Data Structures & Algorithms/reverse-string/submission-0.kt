class Solution {
    fun reverseString(s: CharArray) {
        var i = 0
        var j = s.lastIndex
        
        while (i <= j) {
            val elAtI = s[i]
            s[i] = s[j]
            s[j] = elAtI
            
            i++
            j--
        }
    }
}
