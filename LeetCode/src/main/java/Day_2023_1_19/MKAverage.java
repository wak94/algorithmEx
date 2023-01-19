package Day_2023_1_19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wak
 */
public class MKAverage {

    private int m;
    private int k;
    private int size;
    List<Integer> list = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.size = 0;
    }

    public void addElement(int num) {
        list.add(num);
        this.size++;
        //入栈操作
        if (stack.isEmpty() || stack.peekFirst() <= num) {
            stack.addFirst(num);
        } else {
            while (!stack.isEmpty() && stack.peekLast() > num) {

            }
        }
    }

    public int calculateMKAverage() {
        if (this.size < this.m) {
            return -1;
        }
        int len = 2 * this.k;
        if (len >= this.m) {
            return 0;
        }

        return 0;
    }
}
