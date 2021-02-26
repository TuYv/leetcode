//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 501 👎 0


package leetcode.editor.cn;

//组合总和 II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40CombinationSumIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P40CombinationSumIi().new Solution();
		 solution.combinationSum2(new int[] {2,5,2,1,2}, 5);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		combination(result,list,0,candidates,target);

		return result;


    }

    private void combination(List<List<Integer>> result,List<Integer> list,int x, int[] candidates, int target) {
		for (int i = x; i < candidates.length; i++) {
			if(i > x && candidates[i] == candidates[i-1]) continue;
			if(target == candidates[i]) {
				list.add(candidates[i]);
				List<Integer> res = new ArrayList<>(list);
					result.add(res);
				list.remove(list.size() - 1);
				return;
			} else if (target > candidates[i]) {
				list.add(candidates[i]);
				combination(result, list, i + 1, candidates, target - candidates[i]);
				list.remove(list.size() - 1);
			} else {
				break;
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}