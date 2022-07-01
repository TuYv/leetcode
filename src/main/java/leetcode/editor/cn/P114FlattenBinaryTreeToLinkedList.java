//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1219 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.utils.TreeNode;

import java.util.Objects;

//java:二叉树展开为链表
class P114FlattenBinaryTreeToLinkedList{
    public static void main(String[] args){
        Solution solution = new P114FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(6);

        solution.flatten(treeNode);
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
    public void flatten(TreeNode root) {
        //左节点插入根节点与右节点之间
/*        if(Objects.isNull(root)) {return;}
        flatten(root.left);
        flatten(root.right);
        if (Objects.isNull(root.left)) {return;}
        TreeNode temp = root.left;
        while(Objects.nonNull(temp.right)) { temp = temp.right;}
        temp.right = root.right;
        root.right = root.left;
        root.left = null;*/
        while(Objects.nonNull(root)) {
            while (Objects.nonNull(root.left)) {
                TreeNode temp = root.left;
                while(Objects.nonNull(temp.right)) { temp = temp.right;}
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}