//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 572 👎 0

package leetcode.editor.cn;
//java:二进制求和
class P67AddBinary{
    public static void main(String[] args){
        Solution solution = new P67AddBinary().new Solution();
        solution.addBinary("11","1");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int buffer = 0;
        for(int i = a.length() -1, j = b.length() - 1; i >= 0 || j >= 0; i--,j--) {
            int sum = (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0) + buffer;
            sb.append(sum%2);
            buffer = sum/2;
        }
        sb.append(buffer == 1 ? buffer : "");
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
