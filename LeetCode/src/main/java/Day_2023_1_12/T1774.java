package Day_2023_1_12;

import java.util.Arrays;

/**
 * @author wak
 */
public class T1774 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        //基料中最小的，因为基料必须选一种
        int x = Arrays.stream(baseCosts).min().getAsInt();
        //如果最小的已经大于target，那么这已经是最接近的，直接返回
        if (x >= target) {
            return x;
        }
        //can[i]表示开销为i是否存在合法方案
        boolean[] can = new boolean[target + 1];
        //初始化超过target的开销
        int res = 2 * target - x;
        //遍历基料开销，只要不大于target就存在合法方案，can设置为true
        for (int b : baseCosts) {
            if (b <= target) {
                can[b] = true;
            } else {
                //只保存超出target最小的那个
                res = Math.min(res, b);
            }
        }
        //遍历配料开销
        for (int t : toppingCosts) {
            for (int count = 0; count < 2; ++count) {
                for (int i = target; i > 0; --i) {
                    //如果开销为i存在合理方案，且加上配料就超过target，取res和该值的最小值
                    if (can[i] && i + t > target) {
                        res = Math.min(res, i + t);
                    }
                    //如果不存在合理方案，判断减去配料开销是否大于零，大于零就更新can[i]
                    if (i - t > 0) {
                        can[i] = can[i] | can[i - t];
                    }
                }
            }
        }
        //从target开始往左搜索，与大于target的进行比较，选出更接近target的，返回
        for (int i = 0; i <= res - target; ++i) {
            if (can[target - i]) {
                return target - i;
            }
        }
        return res;
    }


}
