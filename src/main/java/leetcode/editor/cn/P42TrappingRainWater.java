//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2093 👎 0

package leetcode.editor.cn;
//java:接雨水
class P42TrappingRainWater{
    public static void main(String[] args){
        Solution solution = new P42TrappingRainWater().new Solution();
        solution.trap(new int[] {0});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int result = 0;
    public int trap(int[] height) {
        for (int i = 0; i < height.length; i++) {
            while(i < height.length && height[i] == 0){
                i++;
            }
            int j = i;
            while(j + 1 < height.length && height[j + 1] < height[i]) {
                j++;
            }
            if (j + 1 < height.length) {
                result += sum(height,i,j + 1);
                i = j;
            }
        }

        return result;
    }
    public int sum(int[] height,int i, int j) {
        int low = Math.min(height[i],height[j]);
        int temp = 0;
        for(int x = i + 1; x < j; x++) {
            temp += low - height[x];
        }
        return temp;
    }
    public void left(int[] height, int i) {
        while(i < height.length - 1 && height[i + 1] >= height[i]) {
            i++;
        }
        if(i == height.length - 1) {
            return ;
        }
        right(height,i,height[i]);
    }
    public void right(int[] height, int i, int leftHeight) {
        int temp = 0;
        int time = 0;
        while(i < height.length - 1 && height[i + 1] <= leftHeight){
            temp += (leftHeight - height[i+1]);
            time ++;
            i++;
        }
        if(i == height.length - 1) {
            return ;
        }
        i++;
        if(height[i] < leftHeight) {
            result += temp - time * (leftHeight - height[i]);
        } else {
            result += temp;
        }
        left(height,i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
