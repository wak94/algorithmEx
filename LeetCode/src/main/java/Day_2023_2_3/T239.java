package Day_2023_2_3;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wak
 */
public class T239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        int[] ans = new int[len];
        int index = 0;
        MyQueue q = new MyQueue();
        for (int i = 0; i < k; i++) {
            q.add(nums[i]);
        }
        ans[index++] = q.peek();
        for (int i = k; i < nums.length; i++) {
            q.poll(nums[i-k]);
            q.add(nums[i]);
            ans[index++] = q.peek();
        }
        return ans;
    }
}

class MyQueue {
    Deque<Integer> deque = new LinkedList<>();

    //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
    //同时判断队列当前是否为空
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
    //保证队列元素单调递减
    //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    //队列队顶元素始终为最大值
    int peek() {
        return deque.peek();
    }
}