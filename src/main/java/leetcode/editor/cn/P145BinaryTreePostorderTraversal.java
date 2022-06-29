//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 876 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

//java:二叉树的后序遍历
class P145BinaryTreePostorderTraversal{
    public static void main(String[] args){
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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
    public List<Integer> postorderTraversal(TreeNode root) {
        //递归 略
        //迭代
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //增加一个临时变量存储处理过的右节点，防止死循环 卡了我好久 tmd
        TreeNode temp = null;

        while (Objects.nonNull(root) || !stack.isEmpty()) {
            while (Objects.nonNull(root)) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (Objects.isNull(root.right) || root.right == temp) {
                result.add(root.val);
                temp = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }

        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}