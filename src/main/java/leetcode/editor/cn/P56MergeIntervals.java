//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2185 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//java:合并区间
class P56MergeIntervals{
    public static void main(String[] args){
        Solution solution = new P56MergeIntervals().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            int indicator = i + 1;
            int[] temp = new int[2];
            temp[0] = intervals[i][0];
            while(indicator < intervals.length) {
                if (intervals[i][1] < intervals[indicator][0]) {
                    temp[1] = intervals[i][1];
                    result.add(temp);
                    i = indicator - 1;
                    break;
                }
                if (intervals[i][1] < intervals[indicator][1]) {
                    temp[1] = intervals[indicator][1];
                    result.add(temp);
                    i = indicator;
                    break;
                }
                indicator++;
            }
            //from intervals[0][1] start find the first num which bigger than intervals[0][1]
            //if the num's preindex is 0 put the num into [0][1]
            //else preindex must be 1, put the num and i++
        }
        return result.toArray(new int[0][]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
