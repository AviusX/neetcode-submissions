class MinStack() {
    private var minValuesIndices = ArrayDeque<Int>()
    private val stackList = mutableListOf<Int>()
    private var right = -1

    fun push(el: Int) {
        right++
        if (right > stackList.lastIndex) {
            stackList.add(el)
        } else {
            stackList[right] = el // overwrite if an element already existed
        }
        if (minValuesIndices.isEmpty() || el < stackList[minValuesIndices.last()]) {
            minValuesIndices.addLast(right)
        }
    }

    fun pop() {
        if (minValuesIndices.last() == right) minValuesIndices.removeLast()
        right--
    }

    fun top() = stackList[right]

    fun getMin() = stackList[minValuesIndices.last()]
}
