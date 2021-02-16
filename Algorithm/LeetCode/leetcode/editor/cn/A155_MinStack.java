//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 779 👎 0


//Java：最小栈

import java.util.Stack;

class A155_MinStack {
    public static void main(String[] args) {
        MinStack solution = new A155_MinStack().new MinStack();
        // TO TEST
    }

    // 算法描述：使用数组（元祖）存放数据信息，一个保存数据自身，一个保存最小数据
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        /**
         * initialize your data structure here.
         */
        Stack<int[]> stack = new Stack();

        public MinStack() {
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(new int[]{x, x});
            } else {
                stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)


}