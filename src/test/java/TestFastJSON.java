import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

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
    public static void main(String[] args) {
        String[] arr = "1,2,3,4,5,6,7,8,9".split(",");
        List<Integer> list = Arrays.stream(arr).map(Integer::parseInt).collect(toList());
        System.err.println(list);

    }
}
