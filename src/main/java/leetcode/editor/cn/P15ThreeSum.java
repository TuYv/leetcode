//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2808 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:三数之和
class P15ThreeSum{
    public static void main(String[] args){
        Solution solution = new P15ThreeSum().new Solution();
        int[] nums = new int[]{1,-1,-1,0};
        solution.threeSum(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        int target = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] + target != 0) {
                target =0 - nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                if(nums[i] > 0)
                    break;
                while (left < right) {
                    if(nums[left] + nums[right] == target) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(right > left && nums[right] == nums[right - 1])  right--;
                        left++;
                        right--;
                    } else if(nums[left] + nums[right] < target) left++;
                    else  right--;
                }
            }
        }
        return res;
    }

    //我吐了 我写的终极麻瓜算法
   /* public void getSum(List<Integer> list, int[] nums, int i) {
        if(list.size() > 2) {
            return;
        }
        if(i >= nums.length - 2 && list.size() == 0) {
            return;
        }
        if(i >= nums.length - 1 && list.size() == 1) {
            return;
        }
        if(i >= nums.length) {
            return;
        }
        if(list.size() == 2) {
            //去重判断
            for(List<Integer> temp : resList) {
                if(temp.contains(list.get(0)) && temp.contains(list.get(1)) && list.get(0) != list.get(1)) {
                    return;
                }
                if(list.get(0) == list.get(1)) {
                    int a = 0;
                    for(int n : temp) {
                        if(n == list.get(0)) {
                            a++;
                        }
                    }
                    if(a >= 2) {
                        return;
                    }
                }
            }
            //todo 判断后面能不能拼成0
            for(int j = i; j < nums.length; j++) {
                if(list.get(0) + list.get(1) + nums[j] == 0) {
                    list.add(nums[j]);
                    resList.add(list);
                    return;
                }
            }
        }
        getSum(list, nums, i + 1);
        List<Integer> list2 = new ArrayList<> ();
        for(int num : list) {
            list2.add(num);
        }
        list2.add(nums[i]);
        getSum(list2, nums, i + 1);

    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}
