//给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输入:1
// 
//
// 示例 3: 
//
// 
//输入:s = "bb"
//输入: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只能由小写和/或大写英文字母组成 
// 
// Related Topics 贪心 哈希表 字符串 👍 422 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:最长回文串
class P409LongestPalindrome{
    public static void main(String[] args){
        Solution solution = new P409LongestPalindrome().new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int longestPalindrome(String s) {
        //初版
/*        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        final char[] chars = s.toCharArray();
        for (char c : chars) {
            Integer count = map.getOrDefault(c, 0);
            count+=1;
            //偶数 +1
            if (count%2 == 0) {
                result += 2;
            }
            map.put(c, count);
        }
        return result == s.length() ? result : result + 1;*/

        // 看攻略
        /*int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int v : map.values()) {
            result += v / 2 * 2;
        }
        return result == s.length() ? result : result + 1;*/
        //攻略
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }
        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
        }
        return ans == s.length() ? ans : ans + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}