//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2211 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//java:有效的括号
class P20ValidParentheses{
    public static void main(String[] args){
        Solution solution = new P20ValidParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        Map<Character,Character> map = new HashMap<Character,Character>(){{put('(',')');put('[',']');put('{','}');}};
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character> (){{add('?');}};
        for (Character c : s.toCharArray()) {
            if(map.containsKey(c)){
                stack.add(map.get(c));
            } else {
                if (stack.removeLast() != c) {
                    return false;
                }
            }
        }
        return stack.size() == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
