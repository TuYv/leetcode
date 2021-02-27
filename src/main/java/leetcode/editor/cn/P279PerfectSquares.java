//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 104 
// 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 775 👎 0


package leetcode.editor.cn;

//完全平方数

public class P279PerfectSquares{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P279PerfectSquares().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int numSquares(int n) {

		return dfs(n,0,Integer.MAX_VALUE);
	}

	public int dfs(int n, int t, int min) {

		//如果这次尝试次数超过了之前的最小值，那也没有必要继续下去了
		if(t >= min) {
			return t;
		}

		//当n = 0的时候说明这次尝试已经到底了， 返回减了多少次
		if (n == 0) {
			return t;
		}
		int k = 1;
		//首先一定要从最大的平方数开始试
		while(k * k <= n) {
			k++;
		}
		//然后n减去这个平方数，在走下去
		//n = n - k * k;
		//这里要注意 k的所有值我们都得尝试一次，所有要修改一下
		for(int i = k - 1; i > 0; i--) {
			int m = n - i * i;
			//这个时候我们的次数就加1了
			t++;
			int x = dfs(m,t,min);
			//初始化一下t
			t--;
			if ( x < min) {
				min = x;
			}
		}
		//这个时候我们的次数就加1了
		//t++;
		//递归
		//return dfs(n,t,min);
		return min;
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}