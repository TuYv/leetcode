//给出一个字符串 s（仅含有小写英文字母和括号）。 
//
// 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。 
//
// 注意，您的结果中 不应 包含任何括号。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "(abcd)"
//输出："dcba"
// 
//
// 示例 2： 
//
// 
//输入：s = "(u(love)i)"
//输出："iloveu"
//解释：先反转子字符串 "love" ，然后反转整个字符串。 
//
// 示例 3： 
//
// 
//输入：s = "(ed(et(oc))el)"
//输出："leetcode"
//解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。 
//
// 示例 4： 
//
// 
//输入：s = "a(bcdefghijkl(mno)p)q"
//输出："apmnolkjihgfedcbq"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 2000 
// s 中只有小写英文字母和括号 
// 题目测试用例确保所有括号都是成对出现的 
// 
// Related Topics 栈 字符串 👍 234 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//java:反转每对括号间的子串
class P1190ReverseSubstringsBetweenEachPairOfParentheses{
    public static void main(String[] args){
        Solution solution = new P1190ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
        System.out.println(solution.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                List<Character> list = new ArrayList<>();
                while(!stack.isEmpty() && stack.peek() != '(') {
                    list.add(stack.pop());
                }
                stack.pop();
                for (char cc : list) {
                    stack.push(cc);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
