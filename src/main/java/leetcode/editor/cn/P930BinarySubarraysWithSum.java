//在由若干 0 和 1 组成的数组 A 中，有多少个和为 S 的非空子数组。 
//
// 
//
// 示例： 
//
// 输入：A = [1,0,1,0,1], S = 2
//输出：4
//解释：
//如下面黑体所示，有 4 个满足题目要求的子数组：
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
// 
//
// 
//
// 提示： 
//
// 
// A.length <= 30000 
// 0 <= S <= A.length 
// A[i] 为 0 或 1 
// 
// Related Topics 哈希表 双指针 
// 👍 87 👎 0


package leetcode.editor.cn;

//和相同的二元子数组

import java.util.HashMap;
import java.util.Map;

public class P930BinarySubarraysWithSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P930BinarySubarraysWithSum().new Solution();
	 	 solution.numSubarraysWithSum(new int[] {1,0,1,0,1}, 2);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int numSubarraysWithSum(int[] A, int S) {
		int N = A.length;
		int[] P = new int[N + 1];
		for (int i = 0; i < N; ++i){
			P[i+1] = P[i] + A[i];
		}

		Map<Integer, Integer> count = new HashMap();
		int ans = 0;
		for (int x: P) {
			ans += count.getOrDefault(x, 0);
			count.put(x+S, count.getOrDefault(x+S, 0) + 1);
		}

		return ans;
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}