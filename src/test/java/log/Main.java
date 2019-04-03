/**
 * Description:
 * User: daipeng
 * Date: 2019-04-02 19:07
 * Project:CodeSnippet
 */
package log;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.CharSet;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "E:\\log\\summary-exposure.json";
        String json = FileUtils.readFileToString(new File(path), Charset.forName("UTF-8"));
        JSONObject obj = JSONObject.parseObject(json);
        System.err.println(obj);


    }

    private Map<String, Object> queryKey(JSONObject target) {
        Map<String, Object> queryKeys = new HashMap<>();

        JSONObject query = target.getJSONObject("query");
        if (query == null) {
            return queryKeys;
        }
        queryKeys = query.getInnerMap();
        return queryKeys;
    }


}
