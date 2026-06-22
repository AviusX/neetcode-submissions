import java.util.ArrayDeque

class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val deque = ArrayDeque<Int>()
        var left = 0

        for (right in nums.indices) {
            while (deque.isEmpty().not() && nums[deque.last] < nums[right]) {
                deque.removeLast()
            }
            deque.add(right)

            if (left > deque.first) {
                deque.removeFirst()
            }

            if (right + 1 >= k) {
                result.add(nums[deque.first])
                left++
            }
        }
        
        return result.toIntArray()
    }

}
