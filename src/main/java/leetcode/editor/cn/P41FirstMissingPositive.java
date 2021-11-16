//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 300 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 973 👎 0


package leetcode.editor.cn;

//缺失的第一个正数

import java.util.Arrays;

public class P41FirstMissingPositive{ 
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P41FirstMissingPositive().new Solution();
		 System.out.println(solution.firstMissingPositive(new int[] {
	 	    0,1,2
	 	 }));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
    	/*//因为arrays.sort复杂度是nlogn 所有不符合要求
		Arrays.sort(nums);
		int result = 1;
		for (int i = 0; i < nums.length; i++) {
		    if (nums[i] == result) {
		    	 result++;
		    }
		}
		return result;*/
		for (int i = 0; i < nums.length; i++) {
		    if(nums[i] <= 0) {
		    	nums[i] = nums.length + 1;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
		    if(num <= nums.length) {
		    	nums[num - 1] = -Math.abs(nums[num - 1]);
			}
		}
		for (int i = 0; i < nums.length; i++) {
		    if(nums[i] > 0) {
		    	return i+1;
			}
		}
		return nums.length + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}