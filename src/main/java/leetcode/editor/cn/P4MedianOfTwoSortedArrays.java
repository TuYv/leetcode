//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3742 👎 0


package leetcode.editor.cn;

//寻找两个正序数组的中位数

public class P4MedianOfTwoSortedArrays{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int[] small,large;
		if (nums1.length > nums2.length) {
			small =  nums2;
			large = nums1;
		} else {
			small = nums1;
			large = nums2;
		}
		int min = small.length;
		int max = large.length;

		//首先排除min为0的情况
		if (min == 0) {
			return  max % 2 == 0 ? (double) (large[max/2 - 1] + large[max/2])/2 : large[max/2];
		}

		int iMin = 0, iMax = min, half = (min + max + 1)/2;
		while (iMin < iMax) {
			int i = (iMin + iMax)/2;
			int j = half - i;

			if (large[j - 1] > small[i]) {
				iMin = i + 1;
			} else {
				iMax = i;
			}
		}
		int i = iMin;
		int j = half - i;
		//考虑 小数组最小的值都比j大
		int num1LeftMax = (i == 0 ? Integer.MIN_VALUE : small[i - 1]);
		//考虑 小数组最大的值都比j小
		int num1RightMin = (i == min ? Integer.MAX_VALUE : small[i]);
		int num2LeftMax = (j == 0 ? Integer.MIN_VALUE : large[j -1]);
		int num2RightMin = (j == max ? Integer.MAX_VALUE : large[j]);

		return (max + min) % 2 == 0 ? (double) (Math.max(num1LeftMax, num2LeftMax) + Math.min(num1RightMin, num2RightMin)) / 2 : Math.max(num1LeftMax, num2LeftMax);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}