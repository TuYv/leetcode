//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 691 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//java:最接近的三数之和
class P16ThreeSumClosest{
    public static void main(String[] args){
        Solution solution = new P16ThreeSumClosest().new Solution();
        solution.threeSumClosest(new int[] {0,1,2}, 3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //给数组排序
        Arrays.sort(nums);

        int k,j,res = 0;
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
//            //如果有重复值 直接跳过
//            while(i > 0 && nums[i] == nums[i - 1]) {
////                if (i == nums.length) {
////                    break;
////                }
//                i++;
//            }
            //开始夹逼
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (Math.abs(temp - target) < closest) {
                    closest = Math.abs(temp - target);
                    res = temp;
                }
                if (temp == target) {
                    return res;
                } else if (temp < target) {
                    j++;
                } else {
                    k--;
                }
            }

        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
