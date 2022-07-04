//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 👍 1887 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//java:最长有效括号
class P32LongestValidParentheses{
    public static void main(String[] args){
        Solution solution = new P32LongestValidParentheses().new Solution();
        solution.longestValidParentheses("(()()");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int longestValidParentheses(String s) {
        /*Stack<Character> stack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        char left = '(';
        char right = ')';
        //不管是左还是右都是可能在一个连续括号内的
        //仅在一次括号既没有存入栈，又没有产生新的有效括号时 一次连续结束

        //上面是错误的思路
        //每移位一步存在三个状态 括号连续 括号待定 括号不连续
        //括号连续存在于 当前位为')'且栈中不为空
        //括号待定存在于 当前位为'('且字符串未结束且有已经开始的连续括号
        //括号不连续存在于 当前位为')'且栈中为空 或者当前位为'('但字符串已结束
        //连续时 结果+2 待定中 上一次连续结果置入栈中 开始新的连续 当新连续把栈取空 则加上上次结果
        int result = 0;
        int temp = 0;
        boolean isRow = false;
        for (int i = 0; i < s.length(); i++) {
            char start = s.charAt(i);
            if (start == right) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    result += 2;
                    if (stack.isEmpty() || isRow) {
                        result += temp;
                    }
                    isRow = true;
                }
            } else {
                stack.push(start);
                isRow = false;
                if (result != 0 && i != s.length() - 1) {
                    temp = result;
                    result = 0;
                }
            }
        }
        return Math.max(result, temp);*/
        //换个思路 试试贪婪 也不行
        //getLongest(s, 0, 1, 0);
        //老老实实 动态规划

        int length = s.length();
        if (length < 2) {return  0;}
        int result = 0;
        int[] dp = new int[length];
        dp[0] = 0;
        if (s.charAt(0) == '(' && s.charAt(1) == ')') { dp[1] = 2; result = 2;}
        for (int i = 2; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                dp[i] = 0;
            } else  {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (dp[i - 1] > 0) {
                    int last = i - dp[i - 1] -1;
                    if (last >= 0 && s.charAt(last) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (last > 0) {
                            dp[i] += dp[last -1];
                        }
                    }

                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
    /*public int getLongest(String s, int left, int right, int max) {
        int length = s.length();
        if (left < 0 || right == length) {return 0;}
        if (s.charAt(left) == '(' && s.charAt(right) == ')') {
            return getLongest(s, left - 1, right + 1, max + 2);
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}