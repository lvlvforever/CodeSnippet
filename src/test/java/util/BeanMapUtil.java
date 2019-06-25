/**
 * Description:
 * User: daipeng
 * Date: 2019-05-29 17:46
 * Project:CodeSnippet
 */
package util;

import basic.Local;
import com.sun.javaws.jnl.PropertyDesc;
import org.apache.poi.ss.formula.functions.T;
import redisson.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class BeanMapUtil {
    public static Map<String,String> convertBeanToMap(Object o) {
        Class cls = o.getClass();
        Map<String, String> map = new HashMap<>();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            int modifier = method.getModifiers();
            if ((methodName.startsWith("get") || methodName.startsWith("is"))
                    && ( (modifier & Modifier.FINAL) == 0 )
                    && ( (modifier & Modifier.NATIVE) == 0 )) {
                String propertyName = methodName.substring(3);
                try {
                    map.put(propertyName, method.invoke(o)+"");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
        System.err.println(map);
        return map;
    }

//    public static <T> T convertMapToBean(Class<T> entityClass,Map<String, String> map) {
//
//        try {
//            T entity = entityClass.newInstance();
//            BeanInfo beanInfo = Introspector.getBeanInfo(entityClass);
//            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
//            for (PropertyDescriptor descriptor : propertyDescriptors) {
//
//                String propertyName = descriptor.getName();
//                if (map.containsKey(propertyName)) {
//
//
//
//
//                }
//
//
//
//            }
//
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (IntrospectionException e) {
//
//        }
//
//
//        return T;
//
//
//
//
//    }


    public static void main(String[] args) {
        User user = new User("daipeng", 123);
        user.setScore(123L);
        user.setGood(true);
        user.setText(0.1);
        convertBeanToMap(user);


        LocalDate localDate = LocalDate.parse("2019-01-02");
        System.err.println(localDate.plusDays(30));




































    }
}
