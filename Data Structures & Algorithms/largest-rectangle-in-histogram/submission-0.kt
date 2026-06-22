class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val heightsStack = ArrayDeque<Pair<Int, Int>>(heights.size) // Pair<index, height>

        for ((currIndex, currHeight) in heights.withIndex()) {
            var start = currIndex
            while (heightsStack.isNotEmpty() && heightsStack.last().second >= currHeight) {
                val (poppedStartIndex, poppedHeight) = heightsStack.removeLast()
                maxArea = maxArea.coerceAtLeast(poppedHeight * (currIndex - poppedStartIndex))
                start = poppedStartIndex
            }

            heightsStack.addLast(Pair(start, currHeight))
        }

        for ((startIndex, height) in heightsStack) {
            maxArea = maxArea.coerceAtLeast(height * (heights.size - startIndex))
        }

        return maxArea
    }
}
