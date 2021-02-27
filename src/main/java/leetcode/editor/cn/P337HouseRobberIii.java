//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 
// 👍 733 👎 0


package leetcode.editor.cn;

//打家劫舍 III

import java.util.Objects;

public class P337HouseRobberIii{
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P337HouseRobberIii().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		public int rob(TreeNode root) {

			//状态转移方程应该是k的值加 k的子子节点值 是否大于 k的子节点之和
			//f(k) = Max((k + f(k - 2)), f(k - 1))

			if(Objects.isNull(root)) {
				return 0;
			}

			  /*自己的算法*/
			//return Math.max(getVal(root), getVal(root.right) + getVal(root.left));
			  /*看了别人的之后写的*/
			return Math.max(dfs(root)[0], dfs(root)[1]);
		}
		private int getVal(TreeNode root){

			//如果是null返回
			if (Objects.isNull(root)) {
				return 0;
			}
			//如果左右叶子都没有
			if(Objects.isNull(root.left) && Objects.isNull(root.right)) {
				return root.val;
			}
			//如果没有左叶子就不考虑左边
			if (Objects.isNull(root.left)) {
				return Math.max(root.val + getVal(root.right.left) + getVal(root.right.right), getVal(root.right));
			}
			//同理如果没有右叶子
			if (Objects.isNull(root.right)) {
				return Math.max(root.val + getVal(root.left.left) + getVal(root.left.right), getVal(root.left));
			}
			//如果左右叶子都有
			return Math.max(root.val + getVal(root.left.left) + getVal(root.left.right) + getVal(root.right.left) + getVal(root.right.right), getVal(root.left) + getVal(root.right));
		}

		//约定[0]是没有这个节点 [1]是有这个节点
		private int[] dfs(TreeNode root) {
			if (Objects.isNull(root)) {
				return new int[] {0,0};
			}
			int[] left = dfs(root.left);
			int[] right = dfs(root.right);
			return new int[] {Math.max(left[1], left[0]) + Math.max(right[1], right[0]), root.val + left[0] + right[0]};
		}
	}


//leetcode submit region end(Prohibit modification and deletion)

}