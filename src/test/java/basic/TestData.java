/**
 * Description:
 * User: daipeng
 * Date: 2019-01-14 22:38
 * Project:CodeSnippet
 */
package basic;

import sun.awt.geom.AreaOp;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class TestData {
    public static void main(String[] args) throws Exception {

        int sec = 1;
        LocalDateTime start = LocalDateTime.of(2019, 1, 13, 21, 0, 0);
        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime end = LocalDateTime.of(2019, 1, 21, 0, 00, 00);

        sec =(int) Duration.between(start,now).toMillis() / 1000 ;
        System.err.println("sec = " + sec);

        sec = 302360;

        int sum = 0;
        for (int i = 0; i < 158; i++) {
//            System.err.println("handle " + i);
            File file = new File("e:\\oscar\\oscar-book-" + i + ".txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            int index = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                index++;
                if (index == sec) {

                    sum += getValue(line);
                    break;
                }

            }

            bufferedReader.close();
            reader.close();

        }
        System.err.println("sum=" + sum);


    }
    private  static int getValue(String cmd) {

        String[] a = cmd.split(" ");
        Integer value= Integer.valueOf(a[2].substring(0,a[2].length() - 1));


        return value;
    }
}
