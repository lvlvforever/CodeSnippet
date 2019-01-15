/**
 * Description:
 * User: daipeng
 * Date: 2018-12-29 15:01
 * Project:CodeSnippet
 */
package basic;

import java.time.Instant;
import java.util.*;

public class RandomUtils {
    public static List<Integer> generateRandomArray(int expectedSum, int expectedNum,int paddingNum) {
        /**
         * 为了获取不同位置的刻度，用TreeSet来做处理，set中的内容能够排序。
         */
        Set<Integer> set = new TreeSet<Integer>();
        set.add(0);
        set.add(expectedSum);
        Random random = new Random();
        while (set.size() < expectedNum + 1) {
            set.add(random.nextInt(expectedSum - 1) + 1);
        }
        Integer[] locations = new Integer[set.size()];
        set.toArray(locations);
        List<Integer> last = new ArrayList<>();
        int[] result = new int[expectedNum];
        /**
         * 计算相邻刻度之间的长度，得到的数值就可以认为是随机数:
         */
        for (int i = 0; i < result.length; i++) {
            result[i] = locations[i + 1] - locations[i];
        }
        List<Integer> raw = new ArrayList<>();
        Arrays.stream(result).forEach(k -> raw.add(k));
        for (int i = 0; i < paddingNum; i++) {
            raw.add(0);
        }
        Collections.shuffle(raw);


        Integer sum = 0;
        for (Integer r : raw) {
            sum += r;
            last.add(sum);
        }
        return last;
    }
    public static void main(String[] args) {
        RandomUtils util = new RandomUtils();
        System.out.println("随机产生和为30的5个正整数如下：");
        List<Integer> number = util.generateRandomArray(100, 20,30);
        int sum = 0;
        System.err.println(number);
        System.err.println(number.size());
    }
}
