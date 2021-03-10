//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1280 👎 0


package leetcode.editor.cn;

//对称二叉树

import leetcode.editor.cn.utils.TreeNode;

import java.util.Objects;

public class P101SymmetricTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P101SymmetricTree().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	public boolean isSymmetric(TreeNode root) {
		return symmetric(root.left, root.right);
	}

	private boolean symmetric(TreeNode left, TreeNode right) {
		//todo
		if (Objects.isNull(left)) {
			return Objects.isNull(right);
		}
		if (Objects.isNull(right)) {
			return false;
		}
		if (symmetric(left.left, right.right)) {
			if (left.val != right.val) {
				return false;
			} else {
				return symmetric(left.right, right.left);
			}
		} else {
			return false;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}