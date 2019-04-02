import basic.Local;
import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Description:
 * User: daipeng
 * Date: 2018-12-06 9:52
 * Project:CodeSnippet
 */

public enum Platform {
    ANDROID(0),
    IOS(1),
    TOUCH(2);
    private final Integer value;
    private Platform(Integer value){

        System.err.println("initial " + value);

        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public static Set<Integer> ids = Arrays.stream(Platform.values()).map(k -> k.getValue()).collect(Collectors.toSet());


    public Platform getPlatform(Integer value) {
        Platform platform ;
        switch (value) {
            case 0:
                platform = Platform.ANDROID;
                break;
            case 1:
                platform = Platform.IOS;
                break;
            case 2:
                platform = Platform.TOUCH;
                break;
                default:
                    platform = Platform.ANDROID;
        }
        return platform;
    }


    public String test() {
        String name = "123";

        try {
            File file = new File("d:\\111");
            FileInputStream inputStream = new FileInputStream(file);
            System.err.println("test");
        } catch (Exception e) {

        }
        return name;

    }



    public static void main(String[] args) {

        System.err.println(ANDROID.test());


//        System.err.println(ids);
//
//
//        Instant instant = Instant.now();
//        System.err.println(instant.toEpochMilli());
//        System.err.println(ZoneId.getAvailableZoneIds());
//        LocalDateTime now = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Pontianak"));
//
//        System.err.println(now);


//
//        Student student = new Student();
//        Student student2 = new Student();
//        student.setName("11");
//        student2.setName("222");
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(student);
//        studentList.add(student2);
//
////        List<String> names = studentList.stream().map(k -> (Optional.ofNullable(k).map(v -> v.getName()).orElse("333"))).collect(Collectors.toList());
//
//        List<String> names = new ArrayList<>();
//
//
////        Optional.ofNullable(studentList).flatMap()
//
//
//        System.err.println(names);
//
//        System.err.println(0x010000);
//        System.err.println(0x010100);
//        System.err.println(0x010101);
//        System.err.println(0x030201);
//

//
//        List<String> expression = Arrays.asList(new String[]{"(", "1", "&", "2", "&", ")"});
//
////        middleSuffixToPostSuffix(expression);
//
//        System.err.println( Thread.currentThread().getStackTrace()[1].getClassName());
//
//
//        System.err.println(LocalDate.now());
//
//
//        List<Long> list = new ArrayList<>();
//        list.add(1000L);
//        list.add(10000L);
//        list.add(100000L);
//        list.add(1000000L);
//        list.add(10000000L);
//        boolean flag = list.stream().anyMatch(b -> b < 100L);
//        System.err.println(flag);
//
//
//        short type = 6;
//        System.err.println((type & 2));
//
//
//        Timestamp timestamp = Timestamp.valueOf("2019-03-11 16:47:02.0");

//        System.err.println(UUID.randomUUID().toString().replaceAll("\\-",""));
//
//        String regex = ".*bookatom.*";
//        System.err.println("fdsfdsfds/bookatom/upload?type=image".matches(regex));



        Timestamp timestamp = Timestamp.valueOf("2019-03-11 16:47:02.0");

        LocalDateTime startTime = LocalDate.parse("2019-02-22", DateTimeFormatter.ISO_DATE).atStartOfDay();

        LocalDateTime now = LocalDateTime.now();
        System.err.println(now.plusDays(1));
        Long gap = Duration.between(startTime, now).toDays();
        System.err.println(gap);

        String s = "/api/v1/activity/.*";
        String a = "/api/v1/activity/list";
        System.err.println(a.matches(s));

        System.err.println(2148646448L - Integer.MAX_VALUE);
        System.err.println(Integer.MAX_VALUE);

    }
    private static Map<String, Object> convertBeanToMap(Object bean) {
        Class type = bean.getClass();
        Map<String, Object> map = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : propertyDescriptors) {
                String propertyName = descriptor.getName();
                if (!"class".equals(propertyName)) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    if (result != null) {
                        map.put(propertyName, result);
                    } else {
                        map.put(propertyName, "");
                    }

                }


            }


        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
        return map;
    }

    public static boolean test(String s) {

        char[] charArray = s.toCharArray();
        int sum = 0;
        for (char ch : charArray) {
            if (ch == '(') {
                sum++;
            } else if (ch == ')') {
                sum--;
            }
            if (sum < 0) {
                return false;
            }
        }
        if (sum == 0) {
            return true;
        } else {
            return false;
        }
    }






    public static boolean  middleSuffixToPostSuffix(List<String> middle) {
        Stack<String> operator = new Stack<>();
        List<String> post = new ArrayList<>(

        );
        for (String s : middle) {
            if (s.equals("(")) {
                operator.push(s);
            } else if (StringUtils.isNumeric(s)) {
                post.add(s);
            } else if (s.equals(")")) {

                while (!operator.isEmpty()) {
                    String cur = operator.peek();
                    if (cur.equals("&") || cur.equals("|")) {
                        post.add(cur);
                        operator.pop();
                    } else if (cur.equals("(")) {
                        operator.pop();
                        break;
                    }
                }

            } else if (s.equals("&") || s.equals("|")) {
                operator.push(s);
            }
        }
        if (!operator.isEmpty()) {
            return false;
        }




        System.err.println(post);
        return true;
    }

    public static boolean calcaluatePostSuffix(List<String> post) {
        Stack<String> result = new Stack<>();
        for (String s : post) {

            if (StringUtils.isNumeric(s)) {
                result.push(s);
            } else if (isOperator(s)) {

                if (result.isEmpty()) {
                    return false;
                }
                String first = result.pop();
                if (result.isEmpty()) {
                    return false;
                }
                String second = result.pop();
                result.push(first + second);
            }
        }
        if (result.size() == 1) {
            return true;
        }
        return false;

    }

    public static boolean isOperator(String s) {
        return s.equals("&") || s.equals("|");
    }











}







class Student{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
