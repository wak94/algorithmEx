package Day_2023_1_10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wak
 */
public class T1620 {

    @Test
    public void test() {
        int[][] towers = {{1, 2, 5}, {2, 1, 7}, {3, 1, 9}};
        System.out.println(Arrays.toString(bestCoordinate(towers, 2)));
    }

    public int[] bestCoordinate(int[][] towers, int radius) {
        //x，y为横纵坐标所以能到达的最远点
        int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE;
        for (int[] tower : towers) {
            x = Math.max(x, tower[0]);
            y = Math.max(y, tower[1]);
        }
        int cx = 0, cy = 0;
        int mq = 0;
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                int[] point = new int[]{i, j};
                int q = 0;
                for (int[] tower : towers) {
                    //计算当前点到塔的距离
                    int dist = distance(point, tower);
                    if (dist <= radius * radius) {
                        double d = Math.sqrt(dist);
                        q += (int) Math.floor(tower[2] / (1 + d));
                    }
                }
                if (q > mq) {
                    cx = i;
                    cy = j;
                    mq = q;
                }
            }
        }

        return new int[]{cx, cy};
    }

    public int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }


}
