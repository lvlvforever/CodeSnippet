/**
 * Description:
 * User: daipeng
 * Date: 2019-01-15 2:01
 * Project:CodeSnippet
 */
package basic;

import javax.swing.text.Document;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class GodBlessMe {
    public static void main(String[] args) {
        int sec = 1;
        LocalDateTime start = LocalDateTime.of(2019, 1, 13, 21, 0, 0);
        LocalDateTime now =  LocalDateTime.of(2019, 1, 20, 23, 59, 59);

//        LocalDateTime now = LocalDateTime.of(2019, 1, 21, 0, 00, 00);




        Long whichSec = (now.atZone(ZoneId.systemDefault()).toEpochSecond() - start.atZone(ZoneId.systemDefault()).toEpochSecond());
        System.err.println(Duration.between(LocalDateTime.now(),now).toMillis() / 1000);



        System.err.println(whichSec);
    }
}
