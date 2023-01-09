package Day_12_25;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wak
 */
public class T2500 {

    @Test
    public void test() {
        int[][] grid = {{10}};
        System.out.println(deleteGreatestValue(grid));
    }

    public int deleteGreatestValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            Arrays.sort(grid[i]);
        }
        for (int i = col - 1; i >= 0; i--) {
            int temp = grid[0][i];
            for (int j = 0; j < row; j++) {
                if (temp < grid[j][i]) {
                    temp = grid[j][i];
                }
            }
            ans += temp;
        }
        return ans;
    }
}
