//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 800 👎 0


package leetcode.editor.cn;

//二叉树的层序遍历

import leetcode.editor.cn.utils.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class P102BinaryTreeLevelOrderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
    	order(root,0);
    	return new ArrayList<>(map.values());

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