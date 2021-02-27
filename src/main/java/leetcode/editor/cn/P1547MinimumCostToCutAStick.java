//有一根长度为 n 个单位的木棍，棍上从 0 到 n 标记了若干位置。例如，长度为 6 的棍子可以标记如下： 
//
// 
//
// 给你一个整数数组 cuts ，其中 cuts[i] 表示你需要将棍子切开的位置。 
//
// 你可以按顺序完成切割，也可以根据需要更改切割的顺序。 
//
// 每次切割的成本都是当前要切割的棍子的长度，切棍子的总成本是历次切割成本的总和。对棍子进行切割将会把一根木棍分成两根较小的木棍（这两根木棍的长度和就是切割前
//木棍的长度）。请参阅第一个示例以获得更直观的解释。 
//
// 返回切棍子的 最小总成本 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 7, cuts = [1,3,4,5]
//输出：16
//解释：按 [1, 3, 4, 5] 的顺序切割的情况如下所示：
//
//第一次切割长度为 7 的棍子，成本为 7 。第二次切割长度为 6 的棍子（即第一次切割得到的第二根棍子），第三次切割为长度 4 的棍子，最后切割长度为 3 
//的棍子。总成本为 7 + 6 + 4 + 3 = 20 。
//而将切割顺序重新排列为 [3, 5, 1, 4] 后，总成本 = 16（如示例图中 7 + 4 + 3 + 2 = 16）。
// 
//
// 示例 2： 
//
// 
//输入：n = 9, cuts = [5,6,1,4,2]
//输出：22
//解释：如果按给定的顺序切割，则总成本为 25 。总成本 <= 25 的切割顺序很多，例如，[4, 6, 5, 2, 1] 的总成本 = 22，是所有可能方案
//中成本最小的。 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10^6 
// 1 <= cuts.length <= min(n - 1, 100) 
// 1 <= cuts[i] <= n - 1 
// cuts 数组中的所有整数都 互不相同 
// 
// Related Topics 动态规划 
// 👍 43 👎 0


package leetcode.editor.cn;

//切棍子的最小成本

import java.util.Arrays;

public class P1547MinimumCostToCutAStick{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1547MinimumCostToCutAStick().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public  int num = 0;
	int[][] memo; // 记忆数组
	public int minCost(int n, int[] cuts) {
		/**
		 * 失败的尝试
		 */
		//getCost(n, getmin(n/2, cuts,cuts.length), cuts, cuts.length);


		Arrays.sort(cuts); // 排序数组
		// 初始化记忆数组
		memo=new int[cuts.length+2][cuts.length+2];
		// 新建一个数组，将棍子的首位和末位加入到cuts数组
		int[] c=new int[cuts.length+2];
		c[0]=0;
		c[c.length-1]=n;
		for(int i=1;i<=cuts.length;i++){
			c[i]=cuts[i-1];
		}
		// 递归求解
		return help(0,c.length-1,c);
	}
	// leftIndex：区间左边界在cuts中对应的下标
// rightIndex：区间左边界在cuts中对应的下标
// cuts：所有的切割点
// 返回值：切割区间内所有点的最小成本
	int help(int leftIndex, int rightIndex, int[] cuts){
		// 如果记忆数组中存在当前解，直接返回
		if(memo[leftIndex][rightIndex]>0) {
			return memo[leftIndex][rightIndex];
		}
		int l=cuts[leftIndex]; // 区间左边界位置
		int r=cuts[rightIndex]; // 区间右边界位置
		if(r-l<=1) {
			return 0; // 如果区间长度小于等于1（无法分割），返回0。
		}
		int min=Integer.MAX_VALUE; // 成本最小值
		// 循环区间内每个切割点
		// 注意区间内首尾两个点不需要切割（切了等于没切）
		for(int i=leftIndex+1;i<rightIndex;i++){
			// 以当前点切割后分成的两个部分，分别交给子方法求最优解，
			// 其和为首先进行当前切割后的最小成本
			int cost=help(leftIndex,i,cuts)+help(i,rightIndex,cuts);
			// 用该成本更新最小成本
			min=Math.min(min, cost);
		}
		// 区间内没有切割点，返回0。
		if(min==Integer.MAX_VALUE) {
			min=0;
		}
		// 最小成本加上当前切割的成本（当前区间长度）
		else{
			min+=(r-l);
		}
		// 将最优解存入记忆数组
		memo[leftIndex][rightIndex]=min;
		return min;
	}

	public int getmin(int t, int[] cuts, int size) {
		int x = 0;
		int result = cuts[x];
		for(int i = 1; i < size; i++) {
			if (Math.abs(cuts[i] - t) < Math.abs(cuts[x] - t)) {
				x = i;
				result = cuts[i];
			} else if (Math.abs(cuts[i] - t) == Math.abs(cuts[x] - t)) {
				if(Math.abs(size/2 - i) < Math.abs(size/2 - x)) {
					x = i;
					result = cuts[i];
				}
			}
		}
		return result;
	}
	public void getCost(int n, int t, int[] cuts,int size) {
		if (size == 0) {
			return;
		}
		num += n;
		int preN = 0;
		int aftN = 0;
		int[] pre = new int[t];
		int[] after = new int[n - t];
		for(int i = 0; i < size; i++) {
			if(cuts[i] > t) {
				after[aftN] = cuts[i] - t;
				aftN++;
			}else if (cuts[i] < t) {
				pre[preN] = cuts[i];
				preN++;
			}
		}
		getCost(n - t, getmin((n-t)/2, after, aftN), after, aftN);
		getCost(t, getmin(t/2, pre, preN), pre, preN);
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}