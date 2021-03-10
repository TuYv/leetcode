//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 818 👎 0


package leetcode.editor.cn;

//二叉树的最大深度

import leetcode.editor.cn.utils.TreeNode;

import java.util.Objects;

public class P104MaximumDepthOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
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
	int max = 0;
    public int maxDepth(TreeNode root) {
    	deep(root,1);
    	return max;
    }
    private void deep(TreeNode root, int level) {
		if(Objects.isNull(root)) {
			return;
		}
		if(level > max) {
			max = level;
		}
		deep(root.left,level + 1);
		deep(root.right,level + 1);

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}