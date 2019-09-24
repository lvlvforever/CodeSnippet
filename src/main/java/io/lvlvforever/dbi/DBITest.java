package io.lvlvforever.dbi;

import com.google.common.collect.ImmutableMap;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBITest {
    private String name = "dbiTest";


    public static void main(String[] args) throws Exception{


        Map<String, Object> map = new MapHolder().getMap();

        Field fs = map.getClass().getDeclaredField("this$0");
        System.err.println(fs.get(map).getClass());

        Map<String, Object> imMap = new ImmutableMap.Builder<String,Object>()
                .put("name", "zhangsan")
                .put("age", 14)
                .build();




    }
}
