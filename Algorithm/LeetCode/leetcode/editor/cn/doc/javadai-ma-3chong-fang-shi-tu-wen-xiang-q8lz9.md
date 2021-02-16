
### 1，使用临时数组

可以使用一个临时数组，先把原数组的值存放到一个临时数组中，然后再把临时数组的值重新赋给原数组，重新赋值的时候要保证每个元素都要往后移k位，如果超过数组的长度就从头开始，所以这里可以使用```(i + k) % length```来计算重新赋值的元素下标
![image.png](https://pic.leetcode-cn.com/1610068849-iinvCs-image.png)



```
    public void rotate(int nums[], int k) {
        int length = nums.length;
        int temp[] = new int[length];
        //把原数组值放到一个临时数组中，
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        //然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }
```

<br>

### 2，多次反转
先反转全部数组，在反转前k个，最后在反转剩余的，如下所示

![image.png](https://pic.leetcode-cn.com/1610072480-yiAYFw-image.png)

```
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length - 1);//先反转全部的元素
        reverse(nums, 0, k - 1);//在反转前k个元素
        reverse(nums, k, length - 1);//接着反转剩余的
    }

    //把数组中从[start，end]之间的元素两两交换,也就是反转
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
```
<br>

其实还可以在调整下，先反转前面的，接着反转后面的k个，最后在反转全部，原理都一样

```
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length - k - 1);//先反转前面的
        reverse(nums, length - k, length - 1);//接着反转后面k个
        reverse(nums, 0, length - 1);//最后在反转全部的元素
    }

    //把数组中从[start，end]之间的元素两两交换,也就是反转
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
```

<br>

### 3，环形旋转
类似约瑟夫环一样，把数组看作是环形的，每一个都往后移动k位，这个很好理解
![image.png](https://pic.leetcode-cn.com/1610074370-FCoknu-image.png)
![image.png](https://pic.leetcode-cn.com/1610074381-kyhghn-image.png)
![image.png](https://pic.leetcode-cn.com/1610074389-JbBnZF-image.png)


但这里有一个坑，如果```nums.length%k=0```，也就是数组长度为k的倍数，这个会原地打转，如下图所示

![image.png](https://pic.leetcode-cn.com/1610074663-JRcbFv-image.png)

对于这个问题我们可以使用一个数组visited表示这个元素有没有被访问过，如果被访问过就从他的下一个开始，防止原地打转。


```
    public static void rotate(int[] nums, int k) {
        int hold = nums[0];
        int index = 0;
        int length = nums.length;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            index = (index + k) % length;
            if (visited[index]) {
                //如果访问过，再次访问的话，会出现原地打转的现象，
                //不能再访问当前元素了，我们直接从他的下一个元素开始
                index = (index + 1) % length;
                hold = nums[index];
                i--;
            } else {
                //把当前值保存在下一个位置，保存之前要把下一个位置的
                //值给记录下来
                visited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
            }
        }
    }
```


<br>

>如果觉得有用就给个赞吧，还可以关注我的[LeetCode主页](https://leetcode-cn.com/u/sdwwld/)查看更多的详细题解
