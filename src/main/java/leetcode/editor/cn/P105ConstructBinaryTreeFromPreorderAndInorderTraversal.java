//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 931 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import leetcode.editor.cn.utils.TreeNode;

//java:从前序与中序遍历序列构造二叉树
class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args){
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        solution.buildTree(new int[]{1,2}, new int[]{1,2});
    }
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //已知preorder的第一个一定是根，然后inorder在根前面的一定是它的前序，后面的一定是它的后续
        //根据inorder的数量去preorder里面画树
        if(preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1) {
            return root;
        }
        int i = -1;
        while(i++ < preorder.length && inorder[i] != root.val);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,1 + i), Arrays.copyOfRange(inorder, 0,i));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1+i, preorder.length), Arrays.copyOfRange(inorder,i + 1, preorder.length));
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
