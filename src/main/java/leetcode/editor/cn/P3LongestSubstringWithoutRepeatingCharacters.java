//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5031 👎 0


package leetcode.editor.cn;

//无重复字符的最长子串

import java.util.HashSet;
import java.util.Set;

public class P3LongestSubstringWithoutRepeatingCharacters{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
		//自己的版本
        /*int p = 0;
        int result = 0;

        int[] charLength = new int[s.length()];
        Boolean[] b = new Boolean[s.length()];

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            char c = chars[i];
            charLength[i] = 1;
            b[i] = true;
            for (int j = 0; j < p; j++) {
                if (b[j]) {
                    if (c == chars[j]) {
                        b[j] = false;
                        for (int x = 0; x < j; x++) {
                            if (b[x]) {
                                charLength[x]--;
                            }
                            b[x] = false;
                        }
                    } else {
                        charLength[j]++;
                    }
                }
            }
            p++;
        }

        for(int i = 0; i < chars.length; i++) {
            if (result < charLength[i]) {
                result = charLength[i];
            }
        }
        return result;*/

		Set<Character> set = new HashSet<>();
		int result = 0, rk = 0;
		int length = s.length();
		char[] ch = s.toCharArray();
		for (int i = 0; i < length; i++) {
			if (i != 0) {
				set.remove(ch[i - 1]);
			}
			while (rk < length && !set.contains(ch[rk])) {
				set.add(ch[rk]);
				rk++;
			}
			result = Math.max(result, set.size());
		}
		return result;

	}

}
//leetcode submit region end(Prohibit modification and deletion)

}