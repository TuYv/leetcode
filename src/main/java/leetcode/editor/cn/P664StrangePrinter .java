//有台奇怪的打印机有以下两个特殊要求： 
//
// 
// 打印机每次只能打印同一个字符序列。 
// 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。 
// 
//
// 给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。 
//
// 示例 1: 
//
// 
//输入: "aaabbb"
//输出: 2
//解释: 首先打印 "aaa" 然后打印 "bbb"。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//输出: 2
//解释: 首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。 
//
// 提示: 输入字符串的长度不会超过 100。 
// Related Topics 深度优先搜索 动态规划 
// 👍 92 👎 0

package leetcode.editor.cn;
//java:奇怪的打印机
class P664StrangePrinter{
    public static void main(String[] args){
        Solution solution = new P664StrangePrinter().new Solution();
        solution.strangePrinter("aba");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strangePrinter(String s) {
        //打印次数
        int printTime = 0;
        //左面的指针
        int left = 0;
        //右面的指针
        int right = s.length() - 1;

        while(left <= right) {
            while (left < right && s.charAt(right) == s.charAt(left)) {
                right--;
            }
            while(left < right && s.charAt(left) == s.charAt(left + 1)){
                left++;
            }
            printTime++;
            left++;
        }

        return printTime;

    }

    public boolean isSameChar(String s) {
        char same = s.charAt(0);
        for(char c : s.toCharArray()) {
            if(same != c) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
