package Day_2023_2_3;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wak
 */
public class T347 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Integer num : map.keySet()) {
            pq.add(new int[]{num, map.get(num)});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            ans[index++] = pq.poll()[0];
        }
        return ans;
    }

    @Test
    public void test() {
        topKFrequent(null, 0);
    }
}
