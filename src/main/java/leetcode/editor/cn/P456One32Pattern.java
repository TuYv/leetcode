//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。 
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 2 * 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 栈 数组 二分查找 有序集合 单调栈 👍 679 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//java:132 模式
class P456One32Pattern{
    public static void main(String[] args){
        Solution solution = new P456One32Pattern().new Solution();
        //solution.find132pattern(new int[]{3,5,0,3,4});
        solution.find132pattern(new int[]{1,2,3,4});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean find132pattern(int[] nums) {
        //单调栈
        //如果栈首元素小于当前位置 mid = 栈首 当前入栈
        //如果大于，当前直接入栈
        //所以栈中一定是个单调递减的栈
        //所以当遇到一个比栈中大的元素，则循环取出栈中比该元素小的最大值
        //也就是从后往前 越来越小 但是都比mid大，因为如果小于mid 就返回了
        Stack<Integer> stack = new Stack<>();
        int mid = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (mid > nums[i]) { return true; }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                mid = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
        //笨比
        /*int length = nums.length;
        if (length < 3) { return false;}

        int i = 0;
        int min = nums[i];
        while (nums[i] <= nums[++i]) {
            if (i == length - 1) { return false; }
        }
        while (i < length) {
            int temp = nums[i];
            if (temp > min) {
                return true;
            }
            min = temp;
            while (nums[i] <= nums[++i]) {
                if (i == length - 1) {
                    return temp > min;
                }
            }
            if (nums[i] > min) {
                return true;
            }
            min = nums[i];
        }

        return false;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
