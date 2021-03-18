//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 465 👎 0


package leetcode.editor.cn;

//从中序与后序遍历序列构造二叉树

import leetcode.editor.cn.utils.TreeNode;

import java.util.Arrays;

public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(postorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postorder.length - 1]);
		if(postorder.length == 1) {
			return root;
		}
		int i = -1;
		while(i++ < postorder.length && inorder[i] != root.val);
		root.left = buildTree( Arrays.copyOfRange(inorder, 0,i), Arrays.copyOfRange(postorder,0,i));
		root.right = buildTree(Arrays.copyOfRange(inorder,i + 1, postorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1) );
		return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}