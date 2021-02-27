//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 5693 👎 0


package leetcode.editor.cn;

//两数相加

import java.util.Objects;

public class P2AddTwoNumbers{

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2AddTwoNumbers().new Solution();
	 }
//力扣代码
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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode listNode = new ListNode(0);
		ListNode x = listNode;
		ListNode p = l1;
		ListNode q = l2;
		int carry = 0;

		if (l1 == null) return l2;
		if (l2 == null) return l1;
		while(Objects.nonNull(p) || Objects.nonNull(q)) {
			listNode.next = new ListNode(carry);
			listNode = listNode.next;
			int a = Objects.nonNull(p) ? p.val : 0;
			int b = Objects.nonNull(q) ? q.val : 0;
			int num = a + b + carry;
			if (num < 10) {
				listNode.val = num;
				carry = 0;
			} else {
				listNode.val = num - 10;
				carry = 1;
			}
			if (p != null){
				p = p.next;
			}
			if (q != null){
				q = q.next;
			}
		}
		if (carry > 0) {
			listNode.next = new ListNode(carry);
		}

		return x.next;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}