//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 961 👎 0


package leetcode.editor.cn;

//下一个排列

public class P31NextPermutation {
	public static void main(String[] args) {
		//测试代码
		Solution solution = new P31NextPermutation().new Solution();
		solution.nextPermutation(new int[]{4, 2, 0, 2, 3, 2, 0});
	}

	//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public void nextPermutation(int[] nums) {
			//1想法 从最后向前循环找比这个数字小的 如果全没有就逆过来
			//2失败的想法
			//3不 我没有错 少了一步 替换之后还需要对替换后的数组排个序
			//4上面想法有问题 还是从最后 但是应该往后循环找出比他大的数组里最小的数 替换掉 之后再对后面的数排序
			//5可以进一步把排序的逻辑在换算的时候做出来 去除多余代码
			int length = nums.length;
			if (length <= 1) {
				return;
			}
			boolean flag = true;
			//3
			/*int i = length - 1;
			//只用触发一次 就结束了
			while (flag && i >= 0) {
				int j = i - 1;
				while(flag && j >= 0) {
					if(nums[j] < nums[i]) {
						int temp = nums[j];
						nums[j] = nums[i];
						nums[i] = temp;
						flag = false;
						for(int x = j + 1; x < length; x++) {
							for(int y = x + 1; y < length; y++) {
								if(nums[y] < nums[x]) {
								    int temp2 = nums[y];
								    nums[y] = nums[x];
								    nums[x] = temp2;
								}
							}
						}
					}
					j--;
				}
				i--;
            }*/
			int min = Integer.MAX_VALUE;
			int min_index = length;
			for (int i = length - 2; i >= 0; i--) {
				int j = i + 1;
				while (j < length) {
					if (nums[i] < nums[j] && nums[j] < min) {
						min = nums[j];
						min_index = j;
					}
					j++;
				}
				if (min_index != length) {
					nums[min_index] = nums[i];
					nums[i] = min;
					for (int x = i + 1; x < length; x++) {
						for (int y = x + 1; y < length; y++) {
							if (nums[y] < nums[x]) {
								int temp2 = nums[y];
								nums[y] = nums[x];
								nums[x] = temp2;
							}
						}
					}
					break;
				}
			}

			if (min_index == length) {
				for (int x = 0, y = nums.length - 1; x < y; x++, y--) {
					int temp = nums[x];
					nums[x] = nums[y];
					nums[y] = temp;
				}
			}
		}
//leetcode submit region end(Prohibit modification and deletion)

	}
}