//给你两个正整数 n 和 k，二进制字符串 Sn 的形成规则如下： 
//
// 
// S1 = "0" 
// 当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1)) 
// 
//
// 其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 
//0）。 
//
// 例如，符合上述描述的序列的前 4 个字符串依次是： 
//
// 
// S1 = "0" 
// S2 = "011" 
// S3 = "0111001" 
// S4 = "011100110110001" 
// 
//
// 请你返回 Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 1
//输出："0"
//解释：S3 为 "0111001"，其第 1 位为 "0" 。
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 11
//输出："1"
//解释：S4 为 "011100110110001"，其第 11 位为 "1" 。
// 
//
// 示例 3： 
//
// 
//输入：n = 1, k = 1
//输出："0"
// 
//
// 示例 4： 
//
// 
//输入：n = 2, k = 3
//输出："1"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= 2n - 1 
// 
// Related Topics 字符串 
// 👍 12 👎 0


package leetcode.editor.cn;

//找出第 N 个二进制字符串中的第 K 位

public class P1545FindKthBitInNthBinaryString{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1545FindKthBitInNthBinaryString().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public char findKthBit(int n, int k) {
		String pre = "0";
		String now = "";
		while (n-- != 0) {
			now = pre + "1" + reverse(invert(pre));
			pre = now;
		}
		return now.charAt(k - 1);
	}
	public String invert (String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0'){
				sb.append("1");
			}else {
				sb.append("0");
			}
		}
		return sb.toString();
	}

	public String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}