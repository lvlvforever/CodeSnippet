/**
 * Description:
 * User: daipeng
 * Date: 2019-02-01 9:51
 * Project:CodeSnippet
 */
package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception{

        Prize a = new Prize();
        a.setName("1");
        Prize b = new Prize();
        b.setName("1");
        List<Prize> prizes = new ArrayList<>();
        prizes.add(a);
        prizes.add(b);
        String json = JSON.toJSONString(prizes);

        ArrayList<Prize> list = (ArrayList<Prize>) JSON.parseArray(json, Prize.class);
        System.err.println(list);

        long total = 1;
        int pageSize = 15;

        int totl =  (int)Math.round(Math.ceil(total / pageSize));
        System.err.println(totl);
    }
}
