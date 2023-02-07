package Day_2023_1_24;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wak
 */
public class T1828 {

    @Test
    public void test() {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int[][] queries = {{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}};
        System.out.println(Arrays.toString(countPoints(points, queries)));
    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int d;
            for (int j = 0; j < queries.length; j++) {
                int x0 = queries[j][0];
                int y0 = queries[j][1];
                int r0 = queries[j][2];
                d = squareDistance(x0 - x, y0 - y);
                if (d <= r0 * r0) {
                    answer[j]++;
                }
            }
        }
        return answer;
    }

    private int squareDistance(int x, int y) {
        return x * x + y * y;
    }
}
