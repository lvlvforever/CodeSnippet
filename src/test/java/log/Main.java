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
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "E:\\log\\summary-exposure.json";
        String json = FileUtils.readFileToString(new File(path), Charset.forName("UTF-8"));
        JSONObject obj = JSONObject.parseObject(json);
        System.err.println(obj);


    }

    private Map<String, String> queryKey(JSONObject target) {
        JSONObject query = target.getJSONObject("query");






    }


}
