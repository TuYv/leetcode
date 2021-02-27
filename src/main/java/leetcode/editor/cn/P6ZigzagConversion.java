//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 
// 👍 1031 👎 0


package leetcode.editor.cn;

//Z 字形变换

import java.util.ArrayList;
import java.util.List;

public class P6ZigzagConversion{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P6ZigzagConversion().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public String convert(String s, int numRows) {
		//特殊情况
		if (s.equals("") || numRows == 1) {
			return s;
		}
		/**       //有两个想法 一个是用一个二维数组直接把z字写出来  --可行但是不优秀
		 char[] chars = s.toCharArray();
		 int[][] z = new int[chars.length][numRows];
		 for(int i = 0; i < s.length(); i++) {
		 for(int j = 0; j < numRows; j++) {
		 z[i][j] = 0;
		 }
		 }
		 int p = 0,q = 1;
		 for(int i = 1; i < chars.length;) {
		 //首先把竖行写入
		 while (q < numRows && i < chars.length) {
		 z[p][q] = i;
		 q++;
		 i++;
		 }
		 //这个时候q = numRows,要偏移
		 q = q - 2;
		 p++;
		 while (q >= 0 && i < chars.length) {
		 z[p][q] = i;
		 q--;
		 p++;
		 i++;
		 }
		 //纠正偏移量
		 p--;
		 q = q + 2;
		 }
		 StringBuilder sb = new StringBuilder();
		 sb.append(chars[0]);
		 for(int j = 0; j < numRows; j++) {
		 for(int i = 0; i < chars.length; i++) {
		 if(z[i][j] != 0) {
		 sb.append(chars[z[i][j]]);
		 }
		 }
		 }
		 return sb.toString();
		 */
/**        //第二个通过算术直接把字符位置写上去  -- 不是很好写
 //首行数字有(s.length() - 1)/(2n - 2) + 1 个
 //尾行数字有(s.length() - n)/(2n - 2) + 1 个
 //中间行数(m)数字为(s.length() - m)/(n - 1) + 1 个
 int i = 0, j = 0;
 while(j < s.length()) {
 chars[i] = s.charAt(j);
 i = (s.length() - 1)/(2 * numRows - 2) + 1;
 j++;
 }*/
/**        //新的想法是分割字符串  -- 也不太行
 //把每一竖列放在一个字符串里面，在把每一斜列放在一个字符串里，最后在拼接
 List<String> listx = new ArrayList<>();
 List<String> listy = new ArrayList<>();
 for (int i = 0; i < s.length(); i = i + 2 * numRows - 2) {
 //得考虑末尾长度不够的情况
 if (i + numRows < s.length()) {
 String x = s.substring(i, numRows);
 } else {
 String x = s.substring(i);
 }
 String y = s.substring(i + numRows, numRows - 2);
 listx.add(x);
 listy.add(y);
 }*/

//网上的解法 用list组替代二维数组
		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < Math.min(numRows, s.length()); i++)
			rows.add(new StringBuilder());

		int curRow = 0;
		boolean goingDown = false;

		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
			curRow += goingDown ? 1 : -1;
		}

		StringBuilder ret = new StringBuilder();
		for (StringBuilder row : rows) ret.append(row);
		return ret.toString();
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}