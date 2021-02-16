//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1541 👎 0


//Java：括号生成

import java.util.ArrayList;
import java.util.List;

class A22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new A22_GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    // 算法描述：
    // 时间复杂度：
    // 空间复杂度：
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();

            generateParenthesis(0, 0, n, "", result);

            return result;
        }

        private void generateParenthesis(int left, int right, int max, String str, List<String> result) {
            // terminator
            if (left == max && right == max) {
                result.add(str);
                return;
            }

            // current process

            // drill down
            if (left < max) {
                generateParenthesis(left + 1, right, max, str + "(", result);
            }
            if (right < left) {
                generateParenthesis(left, right + 1, max, str + ")", result);
            }

            // reverse status
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}