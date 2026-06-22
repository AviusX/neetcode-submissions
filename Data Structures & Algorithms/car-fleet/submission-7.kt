class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val sortedIndices = position.indices.sortedByDescending { position[it] }
        val resultStack = ArrayDeque<Float>(position.size)

        for (index in sortedIndices) {
            val currCarTime = (target - position[index]).toFloat() / speed[index]

            if (resultStack.isNotEmpty() && currCarTime <= resultStack.last()) {
                continue
            } else {
                resultStack.add(currCarTime)
            }
        }

        return resultStack.size
    }
}
