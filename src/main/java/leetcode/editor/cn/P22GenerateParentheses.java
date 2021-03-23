//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1649 👎 0


package leetcode.editor.cn;

//括号生成

import java.util.ArrayList;
import java.util.List;

public class P22GenerateParentheses{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P22GenerateParentheses().new Solution();
	 	 solution.generateParenthesis(3);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	 	List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
    	int leftNum = n;
    	int rightNum = n;
    	char[] brackets = new char[2 * n];
    	addLeftBracket(brackets,0,0, 0);
    	return result;
    }
    private void addLeftBracket(char[] brackets,int i, int leftNum, int rightNum) {
    	//如果是到最后了 说明拼完了
    	if (i == brackets.length) {
    		result.add(String.copyValueOf(brackets));
    		return ;
		}
    	if(leftNum == 0 || leftNum == rightNum) {
    		brackets[i] = '(';
    		addLeftBracket(brackets,i+1,leftNum+1, rightNum);
		} else if (leftNum == brackets.length/2) {
    		brackets[i] = ')';
    		addLeftBracket(brackets,i+1,leftNum, rightNum + 1);
		} else {
			brackets[i] = '(';
			addLeftBracket(brackets,i+1,leftNum + 1, rightNum);
			brackets[i] = ')';
			addLeftBracket(brackets,i+1,leftNum, rightNum + 1);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}