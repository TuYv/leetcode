////给定一个无序的整数数组，找到其中最长上升子序列的长度。
////
//// 示例:
////
//// 输入: [10,9,2,5,3,7,101,18]
////输出: 4
////解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
////
//// 说明:
////
////
//// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
//// 你算法的时间复杂度应该为 O(n2) 。
////
////
//// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
//// Related Topics 二分查找 动态规划
//// 👍 848 👎 0
//
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        //特殊情况
//        if (n < 2) {
//            return n;
//        }
//        //初始状态
//        int m = nums[0];
//        //int n = nums[1];
//        int max = n,max- = Integer.MIN_VALUE,result;
//        if (m >= n) {
//            result = 1;
//        } else {
//            max- = m;
//            return = 2;
//        }
//        //转移方程
//        //如果当前值是最长上升子序列的最大值，判断下一个值是否比它大，如果大 这他为当前值，序列长度+1，如果小，亦为当前值，但是序列长度不加 不对
//        //其实就是从数组中找到出一个升序数组
//        //那就从中间切入
//        for (int i = 2; i < n; i++) {
//            if (nums[i] > max) {
//                max = nums[i];
//                result++;
//            } else if(nums[i] < max)
//        }
//        //判断结果
//    }//给定一个无序的整数数组，找到其中最长上升子序列的长度。
////
//// 示例:
////
//// 输入: [10,9,2,5,3,7,101,18]
////输出: 4
////解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
////
//// 说明:
////
////
//// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
//// 你算法的时间复杂度应该为 O(n2) 。
////
////
//// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
//// Related Topics 二分查找 动态规划
//// 👍 848 👎 0
//
//
//    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//        public int lengthOfLIS(int[] nums) {
//            int n = nums.length;
//            //特殊情况
//            if (n < 2) {
//                return n;
//            }
//            //初始状态
//            int m = nums[0];
//            int n = nums[1];
//            int max = n,max- = Integer.MIN_VALUE,result;
//            if (m >= n) {
//                result = 1;
//            } else {
//                max- = m;
//                return = 2;
//            }
//            //转移方程
//            //如果当前值是最长上升子序列的最大值，判断下一个值是否比它大，如果大 这他为当前值，序列长度+1，如果小，亦为当前值，但是序列长度不加 不对
//            //其实就是从数组中找到出一个升序数组
//            //那就从中间切入
//            for (int i = 2; i < n; i++) {
//                if (nums[i] > max) {
//                    max = nums[i];
//                    result++;
//                } else if(nums[i] < max)
//            }
//            //判断结果
//        }
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
