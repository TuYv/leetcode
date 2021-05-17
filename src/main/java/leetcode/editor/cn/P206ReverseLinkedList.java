//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1529 👎 0


package leetcode.editor.cn;

//反转链表

import leetcode.editor.cn.utils.ListNode;

public class P206ReverseLinkedList {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P206ReverseLinkedList().new Solution();
    }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;

            while (curr != null) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            return prev;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}