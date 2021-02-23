//升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
// 
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1190 👎 0


package leetcode.editor.cn;

//搜索旋转排序数组

public class P33SearchInRotatedSortedArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P33SearchInRotatedSortedArray().new Solution();
	 	 solution.search(new int[] {4,5,6,7,0,1,2}, 0);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int search(int[] nums, int target) {
		//旋转之后可以肯定 数组分成了两个升序数组 a和b 且 a最小的值大于b最大的值
		int length = nums.length;
		if (length == 1) {
			if (target == nums[0]) {
				return 0;
			} else {
				return -1;
			}
		}

		int i = 0;
		if(target == nums[i]) {
			return i;
		} else if(target > nums[i]) {
			i++;
		    while(i < length && nums[i] > nums[i - 1]) {
		        if(target == nums[i]) {
		        	return i;
				}
		        i++;
		    }
		    return -1;
		} else {
		    i = length - 1;
		    if (target == nums[i]) {
		        return i;
		    }
		    i--;
		    while(i >= 0 && nums[i] < nums[i + 1]) {
		        if(target == nums[i]) {
		        	return i;
		        }
		        i--;
		    }
		    return -1;
		}

	}

}
//leetcode submit region end(Prohibit modification and deletion)

}