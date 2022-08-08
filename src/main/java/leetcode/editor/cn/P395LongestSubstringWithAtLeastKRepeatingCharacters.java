//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文字母组成 
// 1 <= k <= 10⁵ 
// 
// Related Topics 哈希表 字符串 分治 滑动窗口 👍 714 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.util.CollectionUtils;

//java:至少有 K 个重复字符的最长子串
class P395LongestSubstringWithAtLeastKRepeatingCharacters{
    public static void main(String[] args){
        Solution solution = new P395LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        solution.longestSubstring("ababacb", 3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubstring(String s, int k) {
        //不行 未考虑ababacb这种情况
        /*int result = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        int[] temp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            List<Integer> integers = map.get(s.charAt(i));
            if (integers == null) {
                integers = new ArrayList<>();
                integers.add(i);
                map.put(s.charAt(i), integers);
            } else {
                integers.add(i);
            }

        }
        map.values().forEach(list -> {
            if (list.size() >= k) {
                list.forEach(x -> temp[x] = 1);
            }
        });
        int tempResult = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 1) {
                tempResult++;
            } else {
                result = Math.max(result, tempResult);
                tempResult = 0;
            }

        }
        return Math.max(result, tempResult);*/

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
