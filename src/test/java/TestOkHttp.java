import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: daipeng
 * Date: 2018-11-21 11:28
 * Project:CodeSnippet
 */

public class TestOkHttp {


    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Map<Integer, Integer> map = new HashMap<>();
        Request request = new Request.Builder().url("https://ptwapmusic3.reader.qq.com/activity/pkg181106/testChances").build();
        Instant now = Instant.now();
        for (int i = 0; i < 10_000; i++) {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String json = response.body().string();
                JSONObject object = JSON.parseObject(json);
                Integer number = object.getInteger("number");
                Integer oldCount = map.get(number);
                map.put(number, oldCount == null ? 1 : ++oldCount);
            }

        }
        Instant end = Instant.now();
        Duration duration = Duration.between(now, end);
        System.err.println(duration.getSeconds());

        map.forEach((k, v) -> System.err.println(k + "=" + v));

    }

}
