package Day_2023_3_23;

import org.junit.jupiter.api.Test;

/**
 * @author wak
 */
public class BitMap {

    private int[] bits;
    private final static int DEFAULT_CAPACITY = 10;


    @Test
    public void test() {
        BitMap map = new BitMap(100);
        map.set(1);
        map.set(20);
        map.set(99);

        System.out.println(map.get(1));
        System.out.println(map.get(20));
        System.out.println(map.get(99));
        System.out.println(map.get(100));
    }

    public BitMap() {
        bits = new int[DEFAULT_CAPACITY];
    }

    public BitMap(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);

        bits = new int[(capacity >> 5) + 1];
    }

    public void set(int num) {
        //先判断num在数组中哪个数中
        int num_index = (num >> 5) + 1;
        int count = num & 0x1F;
        bits[num_index] |= 1 << count;
    }

    public boolean get(int num) {
        int num_index = (num >> 5) + 1;
        int count = num & 0x1F;
        return (bits[num_index] & (1 << count)) != 0;
    }
}
