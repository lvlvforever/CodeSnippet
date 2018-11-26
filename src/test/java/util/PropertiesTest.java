package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lvlvforever on 2018/11/26.
 */
public class PropertiesTest {
    public static void main(String[] args) throws  Exception {
        String file = "E:\\params.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(file)));
        for (String key : properties.stringPropertyNames()) {
            System.err.println(key + "=" + properties.getProperty(key));
        }
    }
}
