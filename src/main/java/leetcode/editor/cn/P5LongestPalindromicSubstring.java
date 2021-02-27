//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3253 👎 0


package leetcode.editor.cn;

//最长回文子串

public class P5LongestPalindromicSubstring{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P5LongestPalindromicSubstring().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int max = 0;
	public StringBuilder sb = new StringBuilder("");
	public String newS;
	public String longestPalindrome(String s) {
/** 自己的算法
 newS = s;
 if(s.equals("")) {
 return s;
 }

 char[] c = s.toCharArray();
 for (int i = 0; i < c.length; i++) {
 if (i < c.length - 1 && c[i] == c[i+1]) {
 run(c,i,i+1,0);
 }
 }
 for (int i = 0; i < c.length; i++) {
 if (i < c.length - 2 && c[i] == c[i + 2]) {
 run(c,i,i+2,1);
 }
 }

 return max == 0 ? s.substring(0,1) : sb.toString();*/
		// 特判
		int len = s.length();
		if (len < 2) {
			return s;
		}

		int maxLen = 1;
		int begin = 0;

		// dp[i][j] 表示 s[i, j] 是否是回文串
		boolean[][] dp = new boolean[len][len];
		char[] charArray = s.toCharArray();

		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}
		for (int j = 1; j < len; j++) {
			for (int i = 0; i < j; i++) {
				if (charArray[i] != charArray[j]) {
					dp[i][j] = false;
				} else {
					if (j - i < 3) {
						dp[i][j] = true;
					} else {
						dp[i][j] = dp[i + 1][j - 1];
					}
				}

				// 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
				if (dp[i][j] && j - i + 1 > maxLen) {
					maxLen = j - i + 1;
					begin = i;
				}
			}
		}
		return s.substring(begin, begin + maxLen);
	}

	public void run(char[] c, int i, int j, int flag) {
		if (c[i] == c[j]) {
			//如果到了边界值
			if (i == 0 || j == c.length - 1) {
				flag = flag + 2;
				if (flag > max){
					max = flag;
					newS.substring(i,j);
				}
				//如果还没到边界，i和j继续扩容
			} else {
				flag = flag + 2;
				run(c, i - 1, j + 1, flag);
			}
			//如果i,j不相等，
		} else {
			if (flag > max) {
				max = flag;
				sb = new StringBuilder("");
				for (int q = i + 1; q <= j - 1; q++) {
					sb.append(c[q]);
				}
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}