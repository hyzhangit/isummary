//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// 
// Related Topics 数组 
// 👍 862 👎 0


//Java：旋转数组

import java.util.Arrays;

class A189_RotateArray {
    public static void main(String[] args) {
        Solution solution = new A189_RotateArray().new Solution();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);

        Arrays.stream(nums).forEach(System.out::println);
    }

    // 算法描述：数组反转
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            if (len == 1) {
                return;
            }
            k = k % len;
            if (k == 0) {
                return;
            }

            reverse(nums, 0, len - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, len - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    // 算法描述：数组复制
    // 时间复杂度：O(2n)
    // 空间复杂度：O(n)
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k = k % len;
            if (k == 0) {
                return;
            }

            int[] tmp = new int[len];
            for (int i = 0; i < len; i++) {
                tmp[i] = nums[(i + k) % len];
            }
            for (int i = 0; i < len; i++) {
                nums[i] = tmp[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}