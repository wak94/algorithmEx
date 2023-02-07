package Day_2023_1_22;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wak
 */
public class T1824 {

    @Test
    public void test() {

    }

    private static final int INF = Integer.MAX_VALUE;

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length - 1;
        int[] d = new int[3];
        Arrays.fill(d, 1);
        for (int i = 1; i <= n; i++) {
            int min = INF;
            for (int j = 0; j < 3; j++) {
                if (j == obstacles[i] - 1) {
                    //此时j+1道有障碍
                    d[j] = INF;
                } else {
                    min = Math.min(d[j], min);
                }
            }
            for (int j = 0; j < 3; j++) {
                if (j != obstacles[i] - 1) {
                    //有障碍，需要横移
                    d[j] = Math.min(d[j], min + 1);
                }
            }

        }
        return Math.min(Math.min(d[0], d[1]), d[2]);
    }


}
