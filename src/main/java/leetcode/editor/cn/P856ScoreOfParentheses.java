//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
// Related Topics 栈 字符串 👍 300 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//java:括号的分数
class P856ScoreOfParentheses{
    public static void main(String[] args){
        Solution solution = new P856ScoreOfParentheses().new Solution();
        System.out.println(solution.scoreOfParentheses("(()(()))"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(-1);
            } else {
                int pre = stack.pop();
                if (pre == -1) { // (
                    pre = 1;
                    stack.push(pre);
                } else { // 1
                    stack.pop();
                    stack.push(pre * 2);
                }
            }
            int a = stack.pop();
            while(!stack.isEmpty() && stack.peek() != -1 && a != -1) {
                a+=stack.pop();
            }
            stack.push(a);
        }
        return stack.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
