class Solution {
        fun trap(heights: IntArray): Int {
        if (heights.isEmpty()) return 0

        var i = 0
        var j = heights.lastIndex
        var leftMax = heights[i]
        var rightMax = heights[j]
        var sum = 0

        while (i < j) {
            if (leftMax <= rightMax) {
                i += 1
                leftMax = Math.max(heights[i], leftMax)
                sum += leftMax - heights[i]
            } else {
                j -= 1
                rightMax = Math.max(rightMax, heights[j])
                sum += rightMax - heights[j]
            }
        }

        return sum
    }
}
