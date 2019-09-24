package io.lvlvforever.dbi;

import java.util.HashMap;
import java.util.Map;

public class MapHolder {

    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap() {{
            put("123", "123");
        }};
        return map;
    }
}

