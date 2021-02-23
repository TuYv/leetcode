//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1378 👎 0

package leetcode.editor.cn;
//java:最长公共前缀
class P14LongestCommonPrefix{
    public static void main(String[] args){
        Solution solution = new P14LongestCommonPrefix().new Solution();

        String[] strs = new String[] {
            "ab","a"
        };
        System.out.println(solution.longestCommonPrefix(strs));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {

        //特殊判断
        int length = strs.length;
        if(length <= 0) {
            return "";
        }

        // ********** 网上实现 不如自己的快 但是胜在简洁
        String startStr = strs[0];

        for(String str : strs) {
            while(!str.startsWith(startStr)) {
                startStr = startStr.substring(0, startStr.length() - 1);
                if(startStr.length() == 0) {
                    return "";
                }
            }
        }

        return startStr;

 // ************  自己实现
        /*
        //记录前缀
        StringBuilder sb = new StringBuilder();

        //取第一个元素的大小
        int strLength = strs[0].length();
        int start = 0;

        //循环第一个元素的大小 最长前缀不会超过这个
        while(strLength > start) {
            char c1 = strs[0].charAt(start);
            for (String str : strs) {
                //第一次提交后添加判断 后续字段可能小于第一个字段
                if(start >= str.length()) {
                    return sb.toString();
                }
                //将所有元素的相同位置和第一个元素做比较 如果有一个不一样结束循环
                char c2 = str.charAt(start);
                if (c2 != c1) {
                    return sb.toString();
                }
            }
            //如果全部一样 加入该元素，累加器+1
            sb.append(c1);
            start++;
        }

        return sb.toString();*/

    }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
