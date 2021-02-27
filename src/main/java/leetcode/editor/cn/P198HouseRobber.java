//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1293 👎 0


package leetcode.editor.cn;

//打家劫舍

public class P198HouseRobber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P198HouseRobber().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int rob(int[] nums) {
		//0.简化问题  就是给你一个数组，空一格取值，求极值，
		//1.初始化数据
		int n = nums.length;
		int result, maxValue;
		result = maxValue = 0;
		//2.特殊情况判断
		if (n == 0){
			return 0;
		} else if (n == 1){
			return nums[0];
		} else if (n == 2){
			return Math.max(nums[0],nums[1]);
		}

		/**
		 * 自己的穷举
		 */
		//result = Math.max(addNum(true,result,0,nums),addNum(false,result,0,nums));

		/**
		 * 看别人的思路
		 */
/*        int a = nums[0];
        int b = Math.max(nums[0],nums[1]);
        int t;
        for(int i = 2; i < n; i++) {
            t = b;
            b = Math.max(b, a + nums[i]);
            a = t;
        }
        return b;*/


		/**
		 * 尝试新的想法
		 */
/*        int[] tlist = new int[n];
        int[] flist = new int[n];

        tlist[0] = nums[0];
        flist[0] = 0;
        tlist[1] = nums[1];
        flist[1] = nums[0];

        for(int i = 2; i < n; i++) {
            tlist[i] = nums[i] + flist[i - 1];
            flist[i] = Math.max(tlist[i-1], flist[i-1]);
        }

        return Math.max(tlist[ n - 1], flist[n - 1]);*/

		/**
		 * 优化想法
		 */
		int t = nums[1];
		int f = nums[0];
		for(int i = 2; i < n; i++) {
			int x = t;
			t = nums[i] + f;
			f = Math.max(x, f);
		}
		return Math.max(t, f);
	}
	private int addNum(boolean flag, int result, int i, int[] nums){
		if (i >= nums.length) {
			return result;
		}
		if(flag) {
			//把这个值放到result中去，
			result += nums[i];
			//如果要这个位置的值，下一个不能取，所以+2
			i = i + 2;
		} else {
			i++;
		}
		result = Math.max(addNum(true,result,i,nums),addNum(false,result,i,nums));

		return result;
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}