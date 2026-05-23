class Solution {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        val alphanumericRegex = Regex("[A-Za-z0-9]")

        while (i <= j && i < s.length && j >= 0) {
            while (i < s.length && i < j && !alphanumericRegex.matches(s[i].toString())) {
                i += 1
            }

            while (j >= 0 && j > i && !alphanumericRegex.matches(s[j].toString())) {
                j -= 1
            }

            if (s[i].lowercaseChar() != s[j].lowercaseChar()) {
                return false
            }

            i = i + 1
            j = j - 1
        }

        return true
    }
}
