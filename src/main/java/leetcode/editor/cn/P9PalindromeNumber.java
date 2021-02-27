//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1405 👎 0


package leetcode.editor.cn;

//回文数

public class P9PalindromeNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P9PalindromeNumber().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public boolean isPalindrome(int x) {
		//如果是负数直接失败
		if (x < 0) {
			return false;
		} else {
			//int数字不会大于10,用于存放每一位数字
			int[] s = new int[10];
			//判断最后一位数字的位置
			int t = 0;
			//数字写入数组
			while(x > 0) {
				s[t] = x % 10;
				x = x / 10;
				t++;
			}
			t--;
			int q = 0;
			while (t > q) {
				if (s[t] == s[q]){
					t--;
					q++;
				}else {
					return false;
				}
			}
			return true;
		}


	}
}

//leetcode submit region end(Prohibit modification and deletion)

}