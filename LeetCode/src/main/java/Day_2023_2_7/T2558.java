package Day_2023_2_7;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * @author wak
 */
public class T2558 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(gifts.length, (x, y) -> y - x);
        for (int gift : gifts) {
            pq.offer(gift);
        }
        while (k > 0) {
            int num = pq.poll();
            pq.offer((int) Math.sqrt(num));
        }

        return pq.stream().mapToLong(Integer::intValue).sum();
    }

    @Test
    public void test() {
        int[] gifts = {25, 64, 9, 4, 100};
        System.out.println(pickGifts(gifts, 4));
    }
}
