class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val index = nums.binarySearch(target)
        return  if (index < 0) -1 else index
    }
}
