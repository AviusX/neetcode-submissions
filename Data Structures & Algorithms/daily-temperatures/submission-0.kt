class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val temperatureAndIndexStack = ArrayDeque<Pair<Int, Int>>()
        val result = IntArray(temperatures.size) { 0 }

        for ((index, temperature) in temperatures.withIndex()) {
            while (
                temperatureAndIndexStack.isNotEmpty() &&
                temperatureAndIndexStack.last().first < temperature
            ) {
                val (_, poppedIndex) = temperatureAndIndexStack.removeLast()
                result[poppedIndex] = index - poppedIndex
            }

            temperatureAndIndexStack.add(temperature to index)
        }

        return result
    }
}
