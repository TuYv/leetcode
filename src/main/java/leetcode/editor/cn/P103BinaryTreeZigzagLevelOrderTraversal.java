//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 406 👎 0


package leetcode.editor.cn;

//二叉树的锯齿形层序遍历

import leetcode.editor.cn.utils.TreeNode;

import java.util.*;

public class P103BinaryTreeZigzagLevelOrderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<>();
		if (root == null) {
			return ans;
		}

		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.offer(root);
		boolean isOrderLeft = true;

		while (!nodeQueue.isEmpty()) {
			Deque<Integer> levelList = new LinkedList<>();
			int size = nodeQueue.size();
			for (int i = 0; i < size; ++i) {
				TreeNode curNode = nodeQueue.poll();
				if (isOrderLeft) {
					levelList.offerLast(curNode.val);
				} else {
					levelList.offerFirst(curNode.val);
				}
				if (curNode.left != null) {
					nodeQueue.offer(curNode.left);
				}
				if (curNode.right != null) {
					nodeQueue.offer(curNode.right);
				}
			}
			ans.add(new LinkedList<Integer>(levelList));
			isOrderLeft = !isOrderLeft;
		}

		return ans;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}