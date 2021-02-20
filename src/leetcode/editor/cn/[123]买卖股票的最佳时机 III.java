////给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
////
//// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
////
//// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
////
//// 示例 1:
////
//// 输入: [3,3,5,0,0,3,1,4]
////输出: 6
////解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
////     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
////
//// 示例 2:
////
//// 输入: [1,2,3,4,5]
////输出: 4
////解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
////     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
////     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
////
////
//// 示例 3:
////
//// 输入: [7,6,4,3,1]
////输出: 0
////解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
//// Related Topics 数组 动态规划
//// 👍 450 👎 0
//
//
////Java：买卖股票的最佳时机 III
//class P123BestTimeToBuyAndSellStockIii{
//    public static void main(String[] args) {
//        Solution solution = new P123BestTimeToBuyAndSellStockIii().new Solution();
//        //System.out.println(solution.threeConsecutiveOdds([1,1,1]));
//        // TO TEST
//    }
//    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//        public int maxProfit(int[] prices) {
//
//            //三个维度  一个是股票价格 一个是购买了几次  一个是购买的状态
//            int[][][] dp = new int[prices.length][3][2];
//            int k_max = 2;
//            int k1 = 0;
//            int k2 = 1;
//
//            dp[0][0][0] = 0;
//            dp[0][1][1] = -prices[0];
//            for(int i = 1; i < prices.length; i++) {
//                //这里有一个问题 我们不知道这里的买状态是不买还是卖了之前的
//                // 怎么记录交易次数的状态
//                dp[i][k1][0] = Math.max(dp[i - 1][k1][0], dp[i - 1][k2][1] + prices[i]);
//            }
//            //干脆把所有的情况都保存进来
//            for(int i = 1; i < prices.length; i++) {
//                for (int j = 0; j < k_max; j++) {
//                    //这里买状态是保持之前的状态 或者前一次买完之后卖了
//                    //但是要考虑j是0 的时候
//                    //交易0次买状态
///*                dp[i][0][0] = dp[i - 1][0][0];
//                //交易一次买状态 就是上一个 买一次 位置买了 + 这次卖了的值 和  上一次没买的值 的最大值咯
//                dp[i][1][0] = Math.max(dp[i - 1][1][0],dp[i - 1][1][1] + prices[i]);
//                //交易两次买状态就是上一个 买两次 买了 + 这次买了  和  上一次  卖两次的值 的 最大值
//                dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
//                //交易一次 卖状态就是 上次 买了的 和 上次没买 + 这次买了 的最大值
//                dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
//                //
//                dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);*/
//                    if (j == 0) {
//                        dp[i][0][0] = dp[i - 1][0][0];
//                    } else {
//                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
//                    }
//                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
//                }
//            }
//
//            return dp[prices.length -1][2][0];
//        }
//        public int maxDistance(int[] position, int m) {
//            for(int i = 0; i< m; i++) {
//
//            }
//        }
//        public int minDays(int n) {
//            min(n, 1);
//        }
//        public int min(int n, int day) {
//            if(n == 0) {
//                return day;
//            }
//           // if(day > min) {
//           //     return min;
//           // }
//            if(n % 2 == 0) {
//                return min(n/2, ++day);
//            }
//            if(n % 3 == 0 ) {
//                return min(n/3,++day);
//            }
//        }
//        }
//    }
////leetcode submit region end(Prohibit mod
