typealias SudokuMap = MutableMap<Int, MutableSet<Int>>

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val subBoxMap: SudokuMap = mutableMapOf()
        val rowMap: SudokuMap = mutableMapOf()
        val columnMap: SudokuMap = mutableMapOf()

        for ((rowIndex, row) in board.withIndex()) {
            for ((columnIndex, cell) in row.withIndex()) {
                if (cell == '.') continue
                val num = cell.digitToInt()
                if (!checkAndUpdateMaps(subBoxMap, rowMap, columnMap, rowIndex, columnIndex, num)) {
                    return false
                }
            }
        }

        return true
    }

    private fun getSubBox(row: Int, column: Int) = (row / 3) * 3 + column / 3

    private fun checkAndUpdateMaps(
            subBoxMap: SudokuMap,
            rowMap: SudokuMap,
            columnMap: SudokuMap,
            row: Int,
            column: Int,
            num: Int
    ): Boolean {
        val subBoxKey = getSubBox(row, column)
        val subBoxSet = subBoxMap.getOrPut(subBoxKey) { mutableSetOf() }
        val rowSet = rowMap.getOrPut(row) { mutableSetOf() }
        val columnSet = columnMap.getOrPut(column) { mutableSetOf() }

        if (!subBoxSet.add(num)) return false
        if (!rowSet.add(num)) return false
        if (!columnSet.add(num)) return false

        return true
    }
}
