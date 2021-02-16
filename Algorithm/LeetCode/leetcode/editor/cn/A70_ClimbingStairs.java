//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1434 👎 0


//Java：爬楼梯

class A70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new A70_ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));

    }

    // 算法描述：f(n) = f(n-1)+f(n-2), 循环正推，尽量避免使用递归（存在重复计算（可保存中间结果优化）和栈溢出风险）
    // 时间复杂度：
    // 空间复杂度：
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }

            int fn_2 = 1, fn_1 = 2, fn = 0;
            for (int i = 2; i < n; i++) {
                fn = fn_1 + fn_2;
                fn_2 = fn_1;
                fn_1 = fn;
            }

            return fn;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}