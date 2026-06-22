class Solution {
    fun addBinary(a: String, b: String): String {
        return (a.toLong(2) + b.toLong(2)).toString(2)
    }
}
