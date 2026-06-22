class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var low = 0
        var high = matrix.lastIndex
        
        while (low <= high) {
            val mid = (low + high) / 2
            if (target < matrix[mid][0]) high = mid - 1
            else if (target > matrix[mid][matrix[mid].lastIndex]) low = mid + 1
            else {
                val targetIndex = searchArray(matrix[mid], target)
                return targetIndex >= 0
            }
        }
        
        return false
    }

    private fun searchArray(arr: IntArray, target: Int): Int {
        var low = 0
        var high = arr.lastIndex

        while (low <= high) {
            val mid = (low + high) / 2
            if (target > arr[mid]) low = mid + 1
            else if (target < arr[mid]) high = mid - 1
            else return mid
        }

        return -1
    }
}
