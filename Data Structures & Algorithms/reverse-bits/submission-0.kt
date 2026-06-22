class Solution {
    fun reverseBits(n: Int): Int {
        var result = 0

        for (i in 0..31) {
            val bit = n.shr(i) and 1
            result = result or bit.shl(31 - i)
        }
        
        return result
    }
}
