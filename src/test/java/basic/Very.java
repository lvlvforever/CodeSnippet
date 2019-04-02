/**
 * Description:
 * User: daipeng
 * Date: 2019-01-15 0:51
 * Project:CodeSnippet
 */
package basic;

import com.alibaba.fastjson.JSON;
import com.sun.javafx.image.impl.ByteIndexed;
import org.apache.commons.lang3.RandomStringUtils;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.jnlp.DownloadService;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Very {
    public static final Long DAY31 = 31 * 24 * 60 * 60 * 1000L;
    public static void main(String[] args) {
//


        LocalDateTime a = LocalDateTime.of(2019, 1, 31, 20, 0, 0);
        LocalDateTime b = LocalDateTime.of(2019, 3, 3, 20, 0, 0);
        long day = Duration.between(a, b).toDays();
        System.err.println(day);


        Long m = Duration.between(LocalDateTime.now(), LocalDate.of(2019, 3, 1).atTime(0, 0, 0)).toMinutes();

        System.err.println(m);

    }
}

