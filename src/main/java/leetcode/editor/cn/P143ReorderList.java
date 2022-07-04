////给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
////
//// 
////L0 → L1 → … → Ln - 1 → Ln
//// 
////
//// 请将其重新排列后变为： 
////
//// 
////L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
////
//// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
////
//// 
////
//// 示例 1： 
////
//// 
////
//// 
////输入：head = [1,2,3,4]
////输出：[1,4,2,3] 
////
//// 示例 2： 
////
//// 
////
//// 
////输入：head = [1,2,3,4,5]
////输出：[1,5,2,4,3] 
////
//// 
////
//// 提示： 
////
//// 
//// 链表的长度范围为 [1, 5 * 10⁴] 
//// 1 <= node.val <= 1000 
//// 
//// Related Topics 栈 递归 链表 双指针 👍 951 👎 0
//

package leetcode.editor.cn;

import java.util.Objects;
import java.util.Stack;
import leetcode.editor.cn.utils.ListNode;

//java:重排链表
class P143ReorderList{
    public static void main(String[] args){
        Solution solution = new P143ReorderList().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        solution.reorderList(head);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode last = head;
        //记录链表长度，计算重排序数量 不需要了 stack有size
        //int listCount = 0;
        Stack<ListNode> stack = new Stack<>();

        while (Objects.nonNull(last)) {
            stack.push(last);
            last = last.next;
        }
        int listCount = stack.size()/2;
        Boolean isEven  = stack.size() % 2 == 0;
        while (listCount-- > 0) {
            last = stack.pop();
            last.next = head.next;
            head.next = last;
            head = last.next;
        }
        if (isEven) { last.next=null;}
        else {head.next=null;}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
