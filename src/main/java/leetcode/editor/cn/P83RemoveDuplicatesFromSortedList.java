//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 485 👎 0


package leetcode.editor.cn;

//删除排序链表中的重复元素

import leetcode.editor.cn.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class P83RemoveDuplicatesFromSortedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
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
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode x = new ListNode();
    	x.next = head;
		Set<Integer> set = new HashSet<>();
		while(x.next != null) {
		 if(set.contains(x.next.val)) {
			 x.next = x.next.next;
		 } else {
		     set.add(x.next.val);
			 x = x.next;
		 }
		}
		return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}