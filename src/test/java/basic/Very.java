/**
 * Description:
 * User: daipeng
 * Date: 2019-01-15 0:51
 * Project:CodeSnippet
 */
package basic;

import com.sun.javafx.image.impl.ByteIndexed;

import javax.jnlp.DownloadService;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Very {
    public static void main(String[] args) {
//        int sec = 1;
        LocalDateTime start = LocalDateTime.of(2019, 1, 15, 3, 0, 0);
        LocalDateTime now = LocalDateTime.of(2019, 1, 21, 0, 0, 0);




//        LocalDateTime now = LocalDateTime.of(2019, 1, 21, 0, 00, 00);

//
//
//
//
//
//
//
//
        System.err.println(Duration.between(start,now).toMillis()  / 1000);


    }
}
