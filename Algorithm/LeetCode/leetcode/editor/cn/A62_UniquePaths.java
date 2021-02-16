//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数组 动态规划 
// 👍 864 👎 0


//Java：不同路径

class A62_UniquePaths {
    public static void main(String[] args) {
        Solution solution = new A62_UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(7, 3));
        System.out.println(solution.uniquePaths(3, 3));
    }

    // 算法描述：
    // 对角 = 能到达左点的步数+能到达上带你的步数
    // f(m)(n) = f(m)(n-1) + f(m-1)(n); f(m1) = 1,f(n1) = 1;
    // 时间复杂度：O(m*n)
    // 空间复杂度：O(m*n)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            if (m == 1 || n == 1) {
                return 1;
            }

            int[][] f = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        f[i][j] = 1;
                    } else {
                        f[i][j] = f[i - 1][j] + f[i][j - 1];
                    }
                }
            }
            return f[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}