/**
 * Description:
 * User: daipeng
 * Date: 2018-12-29 10:12
 * Project:CodeSnippet
 */
package basic;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BitSetTest {
    public static void main(String[] args) throws Exception {

        List<Integer> middle = new ArrayList<>();
        List<Integer> last = new ArrayList<>();

        int middleSec = 7200;
        int lastSec = 608400;
        int lastHasNumSec = 200000;
        int bookNum = 158;


//
//
        Integer sum = 0;
        for (int i = 1; i <= bookNum; i++) {
            int cur = 474604 + (79 - i) * 234 + (i - 79) * 123 + (i - 74) * 10;
            if (i == 1) {
                cur = cur + 147;
            }
            middle.add(cur);
            sum += cur;
        }
        Collections.shuffle(middle);
        System.err.println(sum);

        System.err.println(middle);


        List<List<Integer>> books = new ArrayList<>();

        for (Integer mid : middle) {
            List<Integer> val = RandomUtils.generateRandomArray(mid, middleSec, 0);
            books.add(val);
        }

        for (int i = 1; i <= bookNum; i++) {
            int cur = 316250 + (79 - i) * 234 + (i - 79) * 123 + (i - 74) * 10;
            if (i == 1) {
                cur = cur + 79;
            }
            last.add(cur);
        }
        Collections.shuffle(last);

        for (int i = 0; i < last.size(); i++) {
            List<Integer> raw = RandomUtils.generateRandomArray(last.get(i), lastHasNumSec, lastSec - lastHasNumSec);
            Integer midValue = books.get(i).get(middleSec - 1);
            System.err.println(i + "==" + midValue);
            List<Integer> val = IntStream.range(0, raw.size()).map(k -> raw.get(k) + midValue).boxed().collect(Collectors.toList());
            books.get(i).addAll(val);
        }

        System.err.println(books.size());

        System.err.println(books.get(0).size());
        for (int i = 7190; i < 7220; i++) {
            System.err.println(books.get(0).get(i));
        }
        Integer value = 0;
        for (int i = 0; i < bookNum; i++) {
            value += books.get(i).get(7199);
        }
        System.err.println(value);
        value = 0;
        for (int i = 0; i < bookNum; i++) {
            value += books.get(i).get(615600 - 1);
        }
        System.err.println(value);







        for (int i = 0; i < bookNum; i++) {
            List<Integer> each = books.get(i);
            File file = new File("e:\\oscar\\oscar-book-" + i + ".txt");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(writer);
            String cmd = "LPUSH db6:BookEventWeb:IPOSCAR:book" + i;
            for (Integer val : each) {
                bWriter.write(cmd + " " + val + "\t\n");
            }
            System.err.println("write " + i);
            bWriter.close();
            writer.close();
        }


    }
}