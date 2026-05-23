import kotlin.math.min

class Solution {
    fun maxArea(heights: IntArray): Int {
        var i = 0
        var j = heights.lastIndex
        var maxArea = 0

        while (i < j) {
            val area = ((j + 1) - (i + 1)) * min(heights[i], heights[j])
            if (area > maxArea) maxArea = area

            if (heights[i] < heights[j]) {
                i++
            } else {
                j--
            }
        }

        return maxArea
    }
}
