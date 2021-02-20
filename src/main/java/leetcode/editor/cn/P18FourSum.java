//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 748 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:四数之和
class P18FourSum{
    public static void main(String[] args){
        Solution solution = new P18FourSum().new Solution();
        solution.fourSum(new int[] {-2,-1,-1,1,1,2,2}, 0);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        //这题拿到时没有思路  主要是看leetcode上一位叫有为吴的人的算法写的
        //看到另外一个文章说可以用hashmap解决去除 有机会研究一下
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len < 4) {
            return result;
        }
        Arrays.sort(nums);

        for(int i = 0; i < len - 3; i++ ) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            //开始剪枝
            //如果最小的加在一起都比target大 那后面的毫无意义 直接跳出
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) {
                break;
            }
            //如果当前最大的都比target小 那跳出 走下一个
            int max = nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (max < target) {
                continue;
            }
            for(int j = i + 1; j < len - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int k = j+1;
                int l = len - 1;

                //如果最小的加在一起都比target大 那后面的毫无意义 直接跳出
                min = nums[i] + nums[j] + nums[k] + nums[k + 1];
                if (min > target) {
                    break;
                }
                //如果当前最大的都比target小 那跳出 走下一个
                max = nums[i] + nums[j] + nums[l] + nums[l - 1];
                if (max < target) {
                    continue;
                }

                while (k < l) {
                    int temp = nums[i] + nums[j] + nums[k] + nums[l];
                    if(temp == target) {
                        result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        while (k < l && nums[k] == nums[k-1]) {
                            k++;
                        }
                        l--;
                        while (k < l && nums[l] == nums[l+1]) {
                            l--;
                        }
                    } else if(temp > target) {
                        l--;
                        while (k < l && nums[l] == nums[l+1]) {
                            l--;
                        }
                    } else {
                        k++;
                        while (k < l && nums[k] == nums[k-1]) {
                            k++;
                        }
                    }
                }

            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
