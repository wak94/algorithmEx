package Day_2023_2_3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wak
 */
public class T225 {

}

class MyStack {

    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        int size = q.size();
        while (size-- > 1) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
