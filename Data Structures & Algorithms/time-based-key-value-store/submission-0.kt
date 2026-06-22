class TimeMap() {
    private val store: MutableMap<String, MutableList<Pair<String, Int>>> = mutableMapOf()

    fun set(key: String, value: String, timestamp: Int) {
        val values = store.getOrPut(key) { mutableListOf() }
        values.add(Pair(value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        return binarySearchValues(key, timestamp)
    }

    private fun binarySearchValues(key: String, timestamp: Int): String {
        val values = store.getOrDefault(key, null) ?: return ""
        var left = 0
        var right = values.lastIndex
        var resultIndex: Int? = null

        while (left <= right) {
            val mid = left + (right - left) / 2
            val currTimestamp = values[mid].second

            if (currTimestamp <= timestamp) {
                if (resultIndex == null || currTimestamp >= values[resultIndex].second) {
                    resultIndex = mid
                }
                
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return if (resultIndex == null) "" else values[resultIndex].first
    }
}
