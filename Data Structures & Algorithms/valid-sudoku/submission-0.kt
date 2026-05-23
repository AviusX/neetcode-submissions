typealias SubBoxMap = HashMap<Int, HashSet<Int>>

typealias RowColumnMap = HashMap<Int, HashSet<Int>>

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val subBoxMap: SubBoxMap = hashMapOf()
        val rowMap: RowColumnMap = hashMapOf()
        val columnMap: RowColumnMap = hashMapOf()

        for ((rowIndex, row) in board.withIndex()) {
            for ((columnIndex, numString) in row.withIndex()) {
                if (numString == '.') continue
                val num = numString.digitToInt()
                if (!checkAndUpdateMaps(subBoxMap, rowMap, columnMap, rowIndex, columnIndex, num)) {
                    return false
                }
            }
        }

        return true
    }

    private fun getSubBox(row: Int, column: Int): Int {
        return if (row <= 2) {
            if (column <= 2) 0 else if (column > 2 && column <= 5) 1 else 2
        } else if (row > 2 && row <= 5) {
            if (column <= 2) 3 else if (column > 2 && column <= 5) 4 else 5
        } else {
            if (column <= 2) 6 else if (column > 2 && column <= 5) 7 else 8
        }
    }

    private fun checkAndUpdateMaps(
            subBoxMap: SubBoxMap,
            rowMap: RowColumnMap,
            columnMap: RowColumnMap,
            row: Int,
            column: Int,
            num: Int
    ): Boolean {
        val subBoxKey = getSubBox(row, column)
        val subBoxSet = subBoxMap.getOrPut(subBoxKey) { hashSetOf() }
        val rowSet = rowMap.getOrPut(row) { hashSetOf() }
        val columnSet = columnMap.getOrPut(column) { hashSetOf() }

        if (subBoxSet.contains(num)) {
            return false
        } else {
            subBoxSet.add(num)
        }

        if (rowSet.contains(num)) {
            return false
        } else {
            rowSet.add(num)
        }

        if (columnSet.contains(num)) {
            return false
        } else {
            columnSet.add(num)
        }

        return true
    }
}