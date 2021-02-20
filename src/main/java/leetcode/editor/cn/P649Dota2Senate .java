//Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇) 
//
// Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议
//员都可以行使两项权利中的一项： 
//
// 
// 
// 禁止一名参议员的权利： 
//
// 参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。 
// 
// 
// 宣布胜利： 
// 
// 
//
// 如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。 
//
// 
//
// 给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符
//串的大小将是 n。 
//
// 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。 
//
// 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 Radiant 或 
//Dire。 
//
// 
//
// 示例 1： 
//
// 
//输入："RD"
//输出："Radiant"
//解释：第一个参议员来自 Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。然后在第二轮的时候，
//第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人
// 
//
// 示例 2： 
//
// 
//输入："RDD"
//输出："Dire"
//解释：
//第一轮中,第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利
//第二个来自 Dire 阵营的参议员会被跳过因为他的权利被禁止
//第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利
//因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
// 
//
// 
//
// 提示： 
//
// 
// 给定字符串的长度在 [1, 10,000] 之间. 
// 
//
// 
// Related Topics 贪心算法 
// 👍 126 👎 0

package leetcode.editor.cn;
//java:Dota2 参议院
class P649Dota2Senate{
    public static void main(String[] args){
        Solution solution = new P649Dota2Senate().new Solution();
        solution.predictPartyVictory("RD");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String predictPartyVictory(String senate) {
        //Dire 罢免票数
        int dCount = 0;
        //Radiant 罢免票数
        int rCount = 0;
        // 有问题  不是一轮结束的
        /*for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            if(c == 'R') {
                if (rCount > 0) {
                    rCount--;
                    if (i == senate.length() - 1) return "Dire";
                }
                else dCount++;
            } else {
                if(dCount > 0) {
                    dCount--;
                    if(i == senate.length() - 1) return "Radiant";
                }
                else rCount++;
            }
        }
        if(rCount > dCount) {
            return "Dire";
        } else return "Radiant";*/

        // 先试试暴力吧
        int length = senate.length();
        char[] power = senate.toCharArray();
        for(char c : power) {
            if(c == 'D') dCount++;
            else rCount++;
        }
        //记录下一轮数组长度
        int i = 0;
        //记录下一轮数组d的数量
        int tempD = 0;
        //记录下一轮数组r的数量
        int tempR = 0;
        //记录需要删除的d数量
        int delD = 0;
        //记录需要删除的r数量
        int delR = 0;
        //该轮d r都有 继续循环
        while(dCount > 0 && rCount > 0) {
            for(int j = 0; j < length; j++) {
                if(power[j] == 'D') {
                    //如果这个是d 但是前面有提议 少一个提议
                    if(delD > 0) delD--;
                    //如果没有提议 那么多一个r提议 数组中加一个d
                    else{
                        delR++;
                        power[i] = 'D';
                        tempD++;
                        i++;
                    }
                } else {
                    //如果这个是r 但是前面有提议 少一个提议
                    if(delR > 0) delR--;
                        //如果没有提议 那么多一个r提议 数组中加一个d
                    else{
                        delD++;
                        power[i] = 'R';
                        tempR++;
                        i++;
                    }
                }
            }
            //循环结束后
            //放入了多少字符 循环到哪里 i重置
            length = i;
            i = 0;
            dCount = tempD;
            rCount = tempR;
            tempD = tempR = 0;
        }
        if(dCount == 0) {
            return "Radiant";
        } else return "Dire";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
