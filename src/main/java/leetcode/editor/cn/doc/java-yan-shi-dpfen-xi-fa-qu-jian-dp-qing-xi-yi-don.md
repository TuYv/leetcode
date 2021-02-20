### 解题思路

动态规划

这道题可以归为区间DP；

区间DP模板是三重循环

- 一重循环：区间长度
- 二重循环：区间起点
- 三重循环：区间分割点

- 状态表示：`dp[n + 1][n + 1]`
  - dp[i][j] 表示打印i到j位置字符串的次数；
  - 属性：`Min`；
- 状态计算：k = i ~ j
  - 假设第i个字母后这个区间的每一个字母都不相同，`dp[i][j] = 1 + dp[i + 1][j]`；
  - 假设区间里有字母和区间首部元素相同，那么最小值一定出现在这样的打印方案中。也就是说其他的可以忽略：`if(s[k] == s[i])   dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j])`；
- 初始化：
  - 因为区间是从小到到大来动态规划，所以只需要初始化区间长度为1的就行，一个字母最少也要打印一次，dp[i][i] = 1；

### 代码
```java
class Solution {
    public int strangePrinter(String s) {

        int n = s.length();
        if(n == 0) return 0;
        int[][] dp = new int[n + 1][n + 1];

        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }
        for(int len = 2; len <= n; len++){
            for(int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                dp[i][j] = dp[i + 1][j] + 1;
                for(int k = i + 1; k <= j; k++){
                    if(s.charAt(i) == s.charAt(k))
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
```
---
---

学习y总的Java版LeetCode专题模板与相应题目: [https://github.com/shinezzz/LeetCode-Topic](https://github.com/shinezzz/LeetCode-Topic)
分别是以下专题：1二分专题，2链表专题，3树专题，4背包专题，5动态规划专题，6字符串处理专题，7搜索\_DFS\_BFS专题，8滑动窗口\_双指针\_单调队列，9基本数据结构

我的公众号：**GitKid**。 分享LeetCode题解，分享LeetCode专题模板欢迎大家扫码关注。

![GitKid](https://pic.leetcode-cn.com/a530536ef7072473a17d554a0739fe2df12c585d711a80f2b1e3e4003ee102e8-%E5%BE%AE%E4%BF%A1%E5%85%AC%E4%BC%97%E5%8F%B7.jpg)