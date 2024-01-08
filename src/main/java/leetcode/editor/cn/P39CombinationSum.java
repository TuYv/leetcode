//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1174 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

//java:组合总和
class P39CombinationSum{
    public static void main(String[] args){
        Solution solution = new P39CombinationSum().new Solution();
        System.out.println(solution.combinationSum(new int[] {2,3,5}, 8));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            List<Integer> list = new ArrayList<>();
            getNum(candidates,0, list, target);
            return result;
        }

        public void getNum(int[] candidates,int i, List<Integer>list, int target) {
            if (0 > target) return;
            if(0 == target) {
                result.add(new ArrayList<>(list));
                return;
            }
            for(int j = i; j < candidates.length; j++) {
                list.add(candidates[j]);
                getNum(candidates, j, list, target - candidates[j]);
                list.remove(list.size() - 1);
            }
        }

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(candidates);
//
//        List<Integer> list = new ArrayList<> ();
//        combination(result,list,candidates,0,target);
//
//        return result;
//    }
//
//    public void combination(List<List<Integer>> result,List<Integer> list,int[] candidates,int k, int target) {
//        for (int i = k; i < candidates.length; i++) {
//            if(target == candidates[i]) {
//                list.add(candidates[i]);
//                List<Integer> res = new ArrayList<>(list);
//                result.add(res);
//                list.remove(list.size() - 1);
//                return;
//            } else if (target > candidates[i]) {
//                list.add(candidates[i]);
//                combination(result, list, candidates,i, target - candidates[i]);
//                list.remove(list.size() - 1);
//            } else {
//                return;
//            }
//        }
//    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
