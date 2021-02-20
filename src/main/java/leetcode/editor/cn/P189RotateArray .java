//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 747 👎 0

package leetcode.editor.cn;
//java:旋转数组
class P189RotateArray{
    public static void main(String[] args){
        Solution solution = new P189RotateArray().new Solution();
        int x = 3;
        while(x-- != 0) {
            System.out.println(x);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        //特殊处理
        //没有考虑到k可能会大于数组长度的情况
        /*while(k >= nums.length) {
            k = k - nums.length;
        }*/
        //网上看到更好的写法
        k = k % nums.length;

        if (nums.length <= 1 || k == 0) {
            return;
        }
        // 第一种解决方案 循环k * n次 时间复杂度 O(kn)
        /*while(k-- != 0) {
            *//* 第一次写错了 右移写成了左移
            // 用来记录最后一位需要变成的值
            int cache = nums[0];
            for(int i = 0; i < nums.length; i++) {
                if(i == nums.length - 1) {
                    nums[i] = cache;
                } else {
                    nums[i] = nums[i + 1];
                }*//*
            int cache = nums[nums.length - 1];
            for(int i = nums.length - 1; i >= 0; i--) {
                if(i == 0) {
                    nums[i] = cache;
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }*/
        // 第二种解决方案  建一个新的数组 循环k次 时间复杂度O(2n) 空间复杂度 O(1)
        /*int[] temp = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        for (int j = 0; j < nums.length; j++) {
            if(j - k > -1) {
                nums[j] = temp[j - k];
            }
            else {
                nums[j] = temp[nums.length - k + j];
            }
        }*/

        //第三种解决方案 不新建数组 直接用temp值更新数组 时间复杂度O(1) 空间复杂度O(1)
        /*有问题  存在两个互相换的话就死掉了 可以考虑增加下标 然后在判断全部更新了 太复杂 不实现了
        int index = 0;
        int temp = nums[index];
        int length = nums.length;
        int i = 0;
        int cache;
        while(i++ < length) {
            //反推nums[index]要放在什么位置
            if(index + k < length) {
                cache = nums[index + k];
                nums[index + k] = temp;
                index = index + k;
            } else{
                cache = nums[index + k - length];
                nums[index + k - length] = temp;
                index = index + k - length;
            }
            temp = cache;
        }*/

        // 第四种解决方案 判断偏移量 直接更新 实现复杂度 O(1) 空间复杂度 O(1)
        /* 还是不如第二种写得好
        int length = nums.length;
        //如果k >= length/2 temp长k  否则长 length - k
        if(k >= length/2) {
            int[] temp = new int[k];

            for(int i = 0; i < k; i++) {
                temp[i] = nums[i + length - k];
                //nums[i + length - k] = nums[i];
            }
            for(int i = k; i < length; i++ ) {
                nums[i] = temp[i - k];
            }
        } else {
            int[] temp = new int[length - k];
            for(int i = k; i < length; i++) {
                temp[i - k] = nums[i];
                nums[i] = nums[i - k];
            }
        }*/

        // 写一下我没想到的算法
        reverse(nums,0,nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public void reverse(int[] nums, int start, int end) {
        while (end > start) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
