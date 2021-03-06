//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 690 👎 0


//Java：三角形最小路径和

import java.util.Arrays;
import java.util.List;

class A120_Triangle {
    public static void main(String[] args) {
        Solution solution = new A120_Triangle().new Solution();
        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
        System.out.println(solution.minimumTotal(triangle));
    }

    // 算法描述：自底向上 dp[j] = min(dp[j],dp[j+1])+triangle[i][j]
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int level = triangle.size();
            int[] dp = new int[level + 1];

            for (int i = level - 1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}