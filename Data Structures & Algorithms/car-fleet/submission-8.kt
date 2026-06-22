class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val sortedIndices = position.indices.sortedByDescending { position[it] }
        
        var fleets = 0
        var lastFleetArrivalTime = 0.0

        for (index in sortedIndices) {
            val currCarTime = (target - position[index]).toDouble() / speed[index]

            if (currCarTime > lastFleetArrivalTime) {
                fleets++
                lastFleetArrivalTime = currCarTime
            }
        }

        return fleets
    }
}
