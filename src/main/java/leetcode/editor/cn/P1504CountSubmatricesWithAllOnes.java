//给你一个 m x n 的二进制矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[1,0,1],[1,1,0],[1,1,0]]
//输出：13
//解释：
//有 6 个 1x1 的矩形。
//有 2 个 1x2 的矩形。
//有 3 个 2x1 的矩形。
//有 1 个 2x2 的矩形。
//有 1 个 3x1 的矩形。
//矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]
//输出：24
//解释：
//有 8 个 1x1 的子矩形。
//有 5 个 1x2 的子矩形。
//有 2 个 1x3 的子矩形。
//有 4 个 2x1 的子矩形。
//有 2 个 2x2 的子矩形。
//有 2 个 3x1 的子矩形。
//有 1 个 3x2 的子矩形。
//矩形数目总共 = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 。
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 150 
// mat[i][j] 仅包含 0 或 1 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 139 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//java:统计全 1 子矩形
class P1504CountSubmatricesWithAllOnes{
    public static void main(String[] args){
        Solution solution = new P1504CountSubmatricesWithAllOnes().new Solution();
        //System.out.println(solution.numSubmat(new int[][]{{1,0,1},{1,1,0},{1,1,0}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> set;
        int result = 0;
        public int numSubmat(int[][] mat) {

            //枚举 + 动态规划
            int n = mat.length;
            int m = mat[0].length;
/*            int[][] row = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j == 0) { row[i][j] = mat[i][j]; }
                    else if (mat[i][j] == 1) { row[i][j] = row[i][j - 1] + 1; }
                    else { row[i][j] = 0; }
                }

            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int col = row[i][j];
                    for (int k = i; k >=0 && col > 0; k--) {
                        col = Math.min(col, row[k][j]);
                        result+=col;
                    }
                }
            }*/

            //数学
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j > 0 && mat[i][j] > 0) { mat[i][j] = mat[i][j - 1] + 1; }
                    int max = 151;
                    for (int k = i; k >= 0; k--) {
                        max = Math.min(max, mat[k][j]);
                        result+=max;
                    }
                }

            }

            //笨比超时解法
            /*if (mat.length == 0 || mat[0].length ==0) {
                return result;
            }
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    set = new HashSet<>();
                    System.out.println("start:high:" + j + ",length:" + i);
                    getSum(mat, j, i,j,i);
                }

            }*/
            return result;
        }
        public void getSum(int[][] mat, int length, int high, int startLength, int startHigh) {
            if (!set.contains(length + ":" + high) && isAllOne(mat, length, high, startLength, startHigh)) {
                System.out.println(high + "," + length);
                result++;
                set.add(length + ":" + high);
                if (length < mat[0].length - 1) {
                    getSum(mat, length + 1, high,startLength,startHigh);
                }
                if (high < mat.length - 1) {
                    getSum(mat, length, high + 1,startLength,startHigh);
                }
            }
        }
        public boolean isAllOne(int[][] mat, int length, int high, int startLength, int startHigh) {
            int tempHigh = high;
            while(length >= startLength) {
                while (high >= startHigh) {
                    if (mat[high][length] != 1) {
                        return false;
                    }
                    high--;
                }
                high = tempHigh;
                length--;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
