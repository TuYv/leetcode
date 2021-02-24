//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 864 👎 0


package leetcode.editor.cn;

//在排序数组中查找元素的第一个和最后一个位置

public class P34FindFirstAndLastPositionOfElementInSortedArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
	 	 solution.searchRange(new int[]{1},1);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
    	int length = nums.length;
    	if (length == 0 || nums[0] > target || nums[length - 1] < target) {
    		return new int[] {-1,-1};
		}
    	if(length == 1 && nums[0] == target) {
    	    return new int[] {0, 0};
    	}
    	int l = 0;
    	int r = length - 1;
    	while(l <= r) {
    		int min = (l + r)>>1;

    		if(nums[min] == target) {
    			int a = min;
				int b = min;
    			while(a >= 0 && nums[a] == target) {
    				a--;
				}
				while(b < length && nums[b] == target) {
					b++;
				}

				return new int[] {a + 1, b - 1};
			} else if(nums[min] > target) {
			    r = min - 1;
			} else {
    			l = min + 1;
			}
		}
		return new int[] {-1,-1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}