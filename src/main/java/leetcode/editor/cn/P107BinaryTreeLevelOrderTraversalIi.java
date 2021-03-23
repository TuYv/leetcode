//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
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
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 422 👎 0


package leetcode.editor.cn;

//二叉树的层序遍历 II

import leetcode.editor.cn.utils.TreeNode;

import java.util.*;

public class P107BinaryTreeLevelOrderTraversalIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
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
	Map<Integer,List<Integer>> map = new HashMap<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
		order(root,0);
		List<List<Integer>> list = new ArrayList<>(map.values());
		Collections.reverse(list);
		return list;
    }

	public void order(TreeNode root,int level) {
		if(Objects.isNull(root)) {
			return;
		}
		if (Objects.isNull(map.get(level))) {
			map.put(level,new ArrayList<>());
		}
		map.get(level).add(root.val);
		order(root.left,level + 1);
		order(root.right,level + 1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}