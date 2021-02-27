//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10368 👎 0


package leetcode.editor.cn;

//两数之和

import java.util.HashMap;
import java.util.Map;

public class P1TwoSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1TwoSum().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
// **解法 1： 暴力法
		// int[] result = {0,0};
		// int t = 1;
		// for (int i = t; i < nums.length; i++) {
		//     if (nums[result[0]] + nums[i] == target) {
		//         result[1] = i;
		//         break;
		//     } else if (i == nums.length -1) {
		//         result[0] = t;
		//         i = t;
		//         t++;
		//     }
		// }
		// return result;

		// **解法2： 两遍哈希
		// Map<Integer,Integer> map = new HashMap<>();
		// for(int i = 0; i < nums.length; i++) {
		//     map.put(nums[i], i);
		// }
		// for(int i = 0; i < nums.length; i++) {
		//     int key = target - nums[i];
		//     if (map.containsKey(key) && map.get(key) != i) {
		//         return new int[] {i, map.get(key)};
		//     }
		// }

		// return null;

		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}
			map.put(nums[i], i);
		}
		return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}