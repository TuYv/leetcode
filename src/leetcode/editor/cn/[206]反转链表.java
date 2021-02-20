////反转一个单链表。
////
//// 示例:
////
//// 输入: 1->2->3->4->5->NULL
////输出: 5->4->3->2->1->NULL
////
//// 进阶:
////你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
//// Related Topics 链表
//// 👍 1360 👎 0
//
//
////leetcode submit region begin(Prohibit modification and deletion)
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }
// */
//
//public class ListNode {
//    int val;
//     ListNode next;
//    ListNode(int x) { val = x; }
//  }
//
//class Solution {
//
//    public static void main(String[] args) {
//        reverseList();
//    }
//
//    public ListNode reverseList(ListNode head) {
//        if(head.next == null) {
//            return head;
//        }
//        ListNode newHead = new ListNode();
//        ListNode reHead = newHead;
//        reverse(head.next, newHead);
//
//        return reHead;
//    }
//
//    public ListNode reverse(ListNode head, ListNode newHead) {
//        if (head.next != null) {
//            newHead = reverse(head.next, newHead);
//        }
//        newHead.val = head.val;
//        newHead.next = new ListNode();
//
//        return newHead;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
