####  方法：动态规划
- `dp(i, j)` 指的是打印 `S[i], S[i+1], ..., S[j]` 所需的次数。我们需要按以下顺序进行推断：
- 无论在第几次打印字母 `S[i]`，可能在第一次被打印，也可能单独打印，因为在间隔 `[i，k]` 上的任何后续打印都可以在 `[i+1，k]` 上完成。
- 假设第一次打印在 `[i, k]` 上，则有 `s[i]==s[k]`，因为如果不是，我们可以打印 `[i，k]` 中最后出现的 `s[i]` 以获得相同的结果。
- 当在 `[i，k]` 中正确打印所有内容时（`s[i]==s[k]`），它将采取与在 `[i，k-1]` 中正确打印所有内容相同的步骤。

**算法：**
- 通过以上的推导，算法很简单。
- 计算 `dp(i, j)` ，对于 `S[i] == S[k]` 的每个 `i <= k <= j`，我们有一些候选答案 `dp(i, k-1) + dp(k+1, j)`，我们取这些候选答案中的最小值。当 `k=i` 时，候选答案只有 `1 + dp(i+1, j)`。


```Python [ ]
def strangePrinter(self, S):
    memo = {}
    def dp(i, j):
        if i > j: return 0
        if (i, j) not in memo:
            ans = dp(i+1, j) + 1
            for k in xrange(i+1, j+1):
                if S[k] == S[i]:
                    ans = min(ans, dp(i, k-1) + dp(k+1, j))
            memo[i, j] = ans
        return memo[i, j]

    return dp(0, len(S) - 1)
```

```Java [ ]
class Solution {
    int[][] memo;
    public int strangePrinter(String s) {
        int N = s.length();
        memo = new int[N][N];
        return dp(s, 0, N - 1);
    }
    public int dp(String s, int i, int j) {
        if (i > j) return 0;
        if (memo[i][j] == 0) {
            int ans = dp(s, i+1, j) + 1;
            for (int k = i+1; k <= j; ++k)
                if (s.charAt(k) == s.charAt(i))
                    ans = Math.min(ans, dp(s, i, k-1) + dp(s, k+1, j));
            memo[i][j] = ans;
        }
        return memo[i][j];
    }
}
```

**复杂度分析**

* 时间复杂度：*O(N^3)*。*N* 指的是 `s` 的长度，遍历 `s` 子串的状态需要 *O(N^2)*，执行 *O(N)* 的时间来遍历 `k`。
* 空间复杂度：*O(N^2)*，`memo` 的大小。