//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 690 👎 0


package leetcode.editor.cn;

//最佳买卖股票时机含冷冻期

public class P309BestTimeToBuyAndSellStockWithCooldown{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P309BestTimeToBuyAndSellStockWithCooldown().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n < 2) {
			return 0;
		}
		// 0 买状态 1 卖状态  2 冷冻期
		int[][] dp = new int[n][3];

		//初始化
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		dp[0][2] = 0;

		for(int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
			dp[i][2] = dp[i - 1][0];
		}

		return Math.max(dp[n - 1][0], dp[n - 1][2]);
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}