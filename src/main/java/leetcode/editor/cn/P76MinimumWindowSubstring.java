//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2794 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:最小覆盖子串
class P76MinimumWindowSubstring{
    public static void main(String[] args){
        Solution solution = new P76MinimumWindowSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            //滑动指针 左指针指向起点 右指针指向终点, 如果发现t中元素,尝试更新左右指针
            //用来指定所有元素的下标
            Map<Character, Integer> charIndexMap = new HashMap<>();
            //把所有t放进map中
            for(char c : t.toCharArray()) charIndexMap.put(c, charIndexMap.getOrDefault(c, 0) + 1);
            int left = 0;
            int minStart = 0;
            int minLength = Integer.MAX_VALUE;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (charIndexMap.containsKey(c)) {
                    if (charIndexMap.get(c) > 0) {
                        count++;
                    }
                    charIndexMap.put(c, charIndexMap.get(c) - 1);
                }
                while (count == t.length()) {
                    if (i - left + 1 < minLength) {
                        minLength = i - left + 1;
                        minStart = left;
                    }
                    if (charIndexMap.containsKey(s.charAt(left))) {
                        charIndexMap.put(s.charAt(left), charIndexMap.get(s.charAt(left)) + 1);
                        if(charIndexMap.get(s.charAt(left)) > 0)count--;
                    }
                    left++;
                }
            }
            if(minLength == Integer.MAX_VALUE) return "";
            return s.substring(minStart, minStart + minLength);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
