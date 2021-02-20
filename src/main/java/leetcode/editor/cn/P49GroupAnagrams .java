//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 566 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//java:字母异位词分组
class P49GroupAnagrams{
    public static void main(String[] args){
        Solution solution = new P49GroupAnagrams().new Solution();
        String[] strs = {
            "eat","tea","tan","ate","huh","tit"
        };
        solution.groupAnagrams(strs);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public Map<Integer, List<String>> map = new HashMap<>();
        public int[] primes = {3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103};

    public List<List<String>> groupAnagrams(String[] strs) {

//        List<List<String> > groupAnagrams = new ArrayList<>();
        int sum = 1;
        for(String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                sum *= primes[Integer.valueOf(str.charAt(i)) - 97];
            }
            if(map.keySet().contains(sum)) {
                map.get(sum).add(str);
            } else {
                List<String> list = new ArrayList<> ();
                list.add(str);
                map.put(sum, list);
            }
            sum = 1;
            //标记有没有装进去
//            boolean flag = true;
//            for(List<String> anagrams : groupAnagrams) {
//                String anagram = anagrams.get(0);
//
//                if(isContains(str, anagram)) {
//                    anagrams.add(str);
//                    flag = false;
//                    break;
//                }
//            }
//
//            if(flag) {
//                List<String> anagrams = new ArrayList<>();
//                anagrams.add(str);
//                groupAnagrams.add(anagrams);
//            }
        }

        return map.values().stream().collect(Collectors.toList());

//        return groupAnagrams;

    }

//    public void init() {
//        int a = 0;
//        for(char c = 'a'; c <= 'z'; c++) {
//            map.put(c, primes[a]);
//            a++;
//        }
//    }

//    public boolean isContains(String str, String anagram) {
//        if(str.length() != anagram.length()){
//            return false;
//        } else {
//            int strCount = 1, anagramCount = 1;
//            for(int i = 0; i < anagram.length(); i++) {
//                strCount *= map.get(str.charAt(i));
//                anagramCount *= map.get(anagram.charAt(i));
//            }
//            if(strCount != anagramCount)  {
//                return false;
//            }
//        }
//
//        return true;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
