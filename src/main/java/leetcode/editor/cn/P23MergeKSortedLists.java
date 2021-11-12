//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 
// 👍 1593 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.utils.ListNode;

//java:合并K个升序链表
class P23MergeKSortedLists{
    public static void main(String[] args){
        Solution solution = new P23MergeKSortedLists().new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);
        ListNode[] lists = new ListNode[3];
        lists[0] = listNode;
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        listNode = solution.mergeKLists(lists);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //暴力解法
       /* for(int i = 1; i < lists.length; i++) {
            lists[0] = mergeTwoNode(lists[0], lists[i]);
        }
        return lists.length == 0 ? null : lists[0];*/
        //分治算法
        return merge(lists, 0, lists.length - 1);
    }
    //分治
    private ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        return mergeTwoNode(merge(lists,left, mid), merge(lists, mid + 1, right));
    }

    //合并两个有序链表
    private ListNode mergeTwoNode(ListNode first, ListNode second) {
        if(first == null) {
            return second;
        }
        if(second == null) {
            return first;
        }
        if (first.val > second.val) {
            second.next = mergeTwoNode(first, second.next);
            return second;

        } else {
            first.next = mergeTwoNode(first.next, second);
            return first;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
