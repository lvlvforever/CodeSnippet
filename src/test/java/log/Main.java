/**
 * Description:
 * User: daipeng
 * Date: 2019-04-02 19:07
 * Project:CodeSnippet
 */
package log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "E:\\log\\summary-exposure.json";
        String json = FileUtils.readFileToString(new File(path), Charset.forName("UTF-8"));
        JSONObject obj = JSONObject.parseObject(json);
        System.err.println(obj);
        System.err.println(extractCondition(obj));
        String prefixKey = extractPrefixKey(obj);

        JSONObject log = new JSONObject();
        log.put("activity_id", 11233);
        log.put("stype", "template");
        log.put("template_name", "topic");
        log.put("action_type", 1);


        log.put("date", "2019-04-10");
        log.put("atom_plat", 1);
        log.put("qimei", "12312321");


        String targetKey = parsePrefixKey(prefixKey, log);

        System.err.println(targetKey);


        Map<String, Object> conditionMap = extractCondition(obj);
        System.err.println(conditionMap);
        for (Map.Entry<String, Object> entry : conditionMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Object logValue = log.get(key);
            System.err.println(value.equals(logValue));
        }


        String url = "/usr/local/app/BookEventWebV2/classes/com/qq/reader/activity/atom/statistic/";

       String p = url.substring(0,url.indexOf("classes")+"classes".length());
        System.err.println(p);


        Instant instant = Instant.ofEpochMilli(1554691083000L);
        System.err.println(instant.atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ISO_LOCAL_DATE));


        LocalDate date = LocalDate.now();
        String today = date.format(DateTimeFormatter.ISO_DATE);
        System.err.println(today);




    }

    private static String handleLog(String key, JSONObject log) {


        return "";





    }

    private static String parsePrefixKey(String key, JSONObject object) {

        Pattern pattern = Pattern.compile("\\$\\{([^\\}]*)\\}");
        Matcher matcher = pattern.matcher(key);
        while (matcher.find()) {
            String oldKey = matcher.group(0);
            String newKey = object.getString(matcher.group(1));
            key = key.replace(oldKey, newKey);

        }
        return key;
    }





    private static String extractPrefixKey(JSONObject target) {
        JSONArray prefixKey = target.getJSONArray("prefix_key");
        if (prefixKey == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prefixKey.size(); i++) {
            sb.append(prefixKey.getString(i));
            sb.append(":");
        }
        return sb.toString();

    }

    private static Map<String, Object> extractCondition(JSONObject target) {
        Map<String, Object> conditionMap = new HashMap<>();

        JSONObject condition = target.getJSONObject("condition");
        if (condition == null) {
            return conditionMap;
        }
        conditionMap = condition.getInnerMap();
        return conditionMap;
    }


}
