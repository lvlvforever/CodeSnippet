import basic.Local;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Description:
 * User: daipeng
 * Date: 2018-11-21 15:30
 * Project:CodeSnippet
 */

public class TestFastJSON {
    public static void main(String[] args) throws  Exception{
//        String[] arr = "1,2,3,4,5,6,7,8,9".split(",");
//        List<Integer> list = Arrays.stream(arr).map(Integer::parseInt).collect(toList());
//        System.err.println(list);
//
//        LocalDate old = LocalDate.of(2018, 9, 15);
//        LocalDate now = LocalDate.now();
//        System.err.println(now.toEpochDay() - old.toEpochDay());

        String path = "F:\\ad_qq_1979.zip";
        String storePath = "F:\\ad_qq.1979.txt";
        try (ZipArchiveInputStream zipInput = new ZipArchiveInputStream(new FileInputStream(path)); FileOutputStream outputStream = new FileOutputStream(storePath)) {

            ZipArchiveEntry zipEntry = zipInput.getNextZipEntry();
            byte[] buffer = new byte[8192];
            int len = -1;
            while ((len = zipInput.read(buffer)) != -1) {
                outputStream.write(buffer,0,len);
            }
            outputStream.flush();


        } catch (Exception e) {


        }





    }
}
