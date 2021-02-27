//给你一个数组 nums 和一个整数 target 。 
//
// 请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,1,1,1], target = 2
//输出：2
//解释：总共有 2 个不重叠子数组（加粗数字表示） [1,1,1,1,1] ，它们的和为目标值 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [-1,3,5,1,4,2,-9], target = 6
//输出：2
//解释：总共有 3 个子数组和为 6 。
//([5,1], [4,2], [3,5,1,4,2,-9]) 但只有前 2 个是不重叠的。 
//
// 示例 3： 
//
// 输入：nums = [-2,6,6,3,5,4,1,2,8], target = 10
//输出：3
// 
//
// 示例 4： 
//
// 输入：nums = [0,0,0], target = 0
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 0 <= target <= 10^6 
// 
// Related Topics 动态规划 
// 👍 47 👎 0


package leetcode.editor.cn;

//和为目标值的最大数目不重叠非空子数组数目

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P1546MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1546MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int maxNonOverlapping(int[] nums, int target) {

		/**
		 * 别人的算法 大概理解一下 是只要有一对出来所用的值都不要了
		 */
/*            int sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            map.put(0, 1);
            for (int num : nums) {
                sum += num;
                if (map.containsKey(sum - target)) {
                    count++;
                    sum = 0;
                    map = new HashMap<>();
                }
                map.put(sum, 1);
            }
            return count;*/
		int sum = 0;
		int count = 0;
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> list = new ArrayList<>();
		set.add(0);
		list.add(0);
		for(int num : nums) {
			sum += num;
			if (set.contains(sum - target)) {
				count++;
				sum = 0;
				set = new HashSet<>();
				//list = new ArrayList<>();
			}
			set.add(sum);
		}
		return count;
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}