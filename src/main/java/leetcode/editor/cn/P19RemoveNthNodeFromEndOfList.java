//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1146 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.P21MergeTwoSortedLists.ListNode;

//java:删除链表的倒数第N个节点
class P19RemoveNthNodeFromEndOfList{
    public static void main(String[] args){
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        ListNode head = new ListNode(1);
        //solution.removeNthFromEnd(head, 1);
        ListNode a = head;
        for (int i = 2; i < 6; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        solution.removeNthFromEnd(a, 2);
    }

    public static class ListNode extends P21MergeTwoSortedLists.ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode delNode = head;
        ListNode retNode = head;
        while (head.next != null) {
            if(n <= 0) delNode = delNode.next;
            head = head.next;
            n--;
        }
        if(n == 1) return retNode.next;
        delNode.next = delNode.next.next;
        return retNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
