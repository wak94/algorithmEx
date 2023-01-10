package Day_2023_1_10;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * @author wak
 */
public class T1779 {

    @Test
    public void test() {
        int[][] points = {{5, 4}, {3, 4}, {1, 3}, {3, 2}, {1, 7}, {4, 2}};
        long b = System.currentTimeMillis();
        System.out.println(nearestValidPoint(2, 2, points));
        long m = System.currentTimeMillis();
        System.out.println(nearestValidPoint1(2, 2, points));
        long e = System.currentTimeMillis();
        System.out.println(m - b);
        System.out.println(e - m);
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int d = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                map.put(i, d);
            }
        }
        //没有有效点返回-1
        if (map.isEmpty()) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        int dm = Integer.MAX_VALUE;
        for (Integer index : map.keySet()) {
            int d = map.get(index);
            if (dm == d) {
                //如果距离相等取更小的下标
                ans = Math.min(ans, index);
            } else if (dm > d) {
                dm = d;
                ans = index;
            }
        }
        return ans;
    }

    //改进，在第一次遍历的过程中就进行比较
    //从左向右顺序遍历，只有严格小于才更新，这样就保证了下标最小
    public int nearestValidPoint1(int x, int y, int[][] points) {
        int best = Integer.MAX_VALUE, ans = -1;
        for (int i = 0; i < points.length; i++) {
            int px = points[i][0];
            int py = points[i][1];
            if (px == x) {
                int dist = Math.abs(py - y);
                if (dist < best) {
                    best = dist;
                    ans = i;
                }
            } else if (py == y) {
                int dist = Math.abs(px - x);
                if (dist < best) {
                    best = dist;
                    ans = i;
                }
            }
        }
        return ans;
    }
}
