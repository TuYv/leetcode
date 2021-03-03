//给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。 
//
// 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。 
//
// 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
//输出：-1
//解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
// 
//
// 示例 3： 
//
// 输入：nums1 = [6,6], nums2 = [1]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
//- 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
//- 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 105 
// 1 <= nums1[i], nums2[i] <= 6 
// 
// Related Topics 贪心算法 
// 👍 19 👎 0


package leetcode.editor.cn;

//通过最少操作次数使数组的和相等

import java.util.Arrays;

public class P1775EqualSumArraysWithMinimumNumberOfOperations{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1775EqualSumArraysWithMinimumNumberOfOperations().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int minOperations(int[] nums1, int[] nums2) {

		//首先判断可不可能
		int length1 = nums1.length;
		int length2 = nums2.length;
		if(length1 * 6 < length2 || length2 * 6 < length1) {
			return -1;
		}
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < length1; i++) {
			count1 += nums1[i];
		}
		for (int i = 0; i < length2; i++) {
			count2 += nums2[i];
		}
		if(count1 > count2) {
			int[] nums3 = nums2;
			nums2 = nums1;
			nums1 = nums3;
			int count3 = count2;
			count2 = count1;
			count1 = count3;
			int length3 = length2;
			length2 = length1;
			length1 = length3;
		}
		int nums3[] = new int[length1 + length2];
		int target = count2 - count1;
		if(target == 0) {
			return 0;
		}
		for (int i = 0; i < length1; i++) {
			nums3[i] = 6 - nums1[i];
		}
		for (int i = 0; i < length2; i++) {
			nums3[length1 + i] = nums2[i] - 1;
		}
		Arrays.sort(nums3);

		int i = length1 + length2 - 1;
		int time = 0;
		while(target > nums3[i]) {
			time++;
			target -= nums3[i];
			i--;
		}
		return ++time;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}