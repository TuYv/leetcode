//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 473 👎 0


package leetcode.editor.cn;

//打家劫舍 II

public class P213HouseRobberIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P213HouseRobberIi().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int rob(int[] nums) {
		/**
		 * 属实蠢逼 判断什么状态 直接有第一个 没第一个都试一次最后取最大值就好了
		 */
/*//0.简化问题  就是给你一个数组，空一格取值，求极值，
        //1.初始化数据
        int n = nums.length;
        Boolean[] flag = new Boolean[n];
        //2.特殊情况判断
        if (n == 0){
            return 0;
        } else if (n == 1){
            return nums[0];
        } else if (n == 2){
            return Math.max(nums[0],nums[1]);
        }

        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int t;
        flag[0] = true;
        flag[1] = false;
        if(b == nums[0] && nums[0] != nums[1]) {
            flag[1] = true;
        }
        for(int i = 2; i < n; i++) {
            if (i == n - 1 && flag[i - 2]) {
                b = b;
            } else {
                t = b;
                b = Math.max(b, a + nums[i]);
                a = t;
                //很简单的道理  t = b预示着这次偏移后的值没有取，那是否包含1则保持，
                if (t == b) {
                    flag[i] = flag[i - 1];
                } else {
                    flag[i] = flag[i - 2];
                }

                //存在一种情况就是b最开始也是1的时候，a会
            }
        }

        return b;*/
		/**
		 * 复制别人的代码
		 */
  /*      if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));*/
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		int n = nums.length;
		int t = nums[1];
		int f = nums[0];
		for(int i = 2; i < n - 1; i++) {
			int x = t;
			t = nums[i] + f;
			f = Math.max(x, f);
		}
		int n1 = Math.max(t, f);
		t = nums[1];
		f = 0;
		for(int i = 2; i < n; i++) {
			int x = t;
			t = nums[i] + f;
			f = Math.max(x, f);
		}
		int n2 = Math.max(t, f);
		return Math.max(n1, n2);
	}
	private int myRob(int[] nums) {
		int pre = 0, cur = 0, tmp;
		for(int num : nums) {
			tmp = cur;
			cur = Math.max(pre + num, cur);
			pre = tmp;
		}
		return cur;
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}