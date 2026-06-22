import kotlin.collections.ArrayDeque

class MinStack() {
    private var minValuesIndices = ArrayDeque<Int>()
    private val primaryStack = ArrayDeque<Int>()

    fun push(el: Int) {
        primaryStack.addLast(el)
        if (minValuesIndices.isEmpty() || el < primaryStack[minValuesIndices.last()]) {
            minValuesIndices.addLast(primaryStack.lastIndex)
        }
    }

    fun pop() {
        if (minValuesIndices.last() == primaryStack.lastIndex) minValuesIndices.removeLast()
        primaryStack.removeLast()
    }

    fun top() = primaryStack.last()

    fun getMin() = primaryStack[minValuesIndices.last()]
}
