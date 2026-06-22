class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val numDeque = ArrayDeque<Int>()
        var pendingCarry = false
        var pointer = digits.lastIndex
        
        while (pointer >= 0) {
            val currDigit = digits[pointer]
            if (currDigit == 9) {
                numDeque.addFirst(0)
                pendingCarry = true
                pointer--
            } else {
                numDeque.addFirst(currDigit + 1)
                pendingCarry = false
                pointer--
                break
            }
        }
        
        if (pendingCarry) {
            numDeque.addFirst(1)
        }
        
        while (pointer >= 0) {
            numDeque.addFirst(digits[pointer])
            pointer--
        }
        
        return numDeque.toIntArray()
    }
}
