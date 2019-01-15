/**
 * Description:
 * User: daipeng
 * Date: 2018-12-11 15:27
 * Project:CodeSnippet
 */
package java8;

import javax.print.DocFlavor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args)  throws Exception{
        User user = new User();
        user.setId(1L);
        user.setName("a");
        User user2 = new User();
        user2.setId(2L);
        user2.setName("a");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);

        List<Long> ids = users.stream().filter(user1 -> user1.getId() != 1L).map(User::getId).collect(Collectors.toList());
        System.err.println(ids);

//        List<Integer> ages = new ArrayList<>();
//        ages.add(1);
//        ages.add(2);
//
//
//        List<Integer> newAges = new ArrayList<>();
//        newAges.add(2);
//        newAges.add(7);
//
//        //ages.retainAll(newAges);
//        ages.removeAll(newAges);
//        System.err.println(ages);

        System.err.println(test());

//        List<String> a = new ArrayList<>();
//        a.add("123");
//        a.add("1234");
//        ArrayList<Long> b = (ArrayList)a.stream().map(x -> Long.valueOf(x)).collect(Collectors.toList());
//
//        System.err.println(b);
//
//        Map<Integer, String> map = Collections.unmodifiableMap(Stream.of(
//                new AbstractMap.SimpleEntry<>(0, "zero"),
//                new AbstractMap.SimpleEntry<>(1, "zero"),
//                new AbstractMap.SimpleEntry<>(2, "zero"),
//                new AbstractMap.SimpleEntry<>(3, "zero"))
//                .collect(Collectors.toMap( (e) -> e.getKey(), (e) -> e.getValue()   )));
//
//
//        System.err.println(map);
//
//
//


        LocalTime cur = LocalTime.of(21, 00, 00);
        LocalTime end = LocalTime.of(23, 00, 00);
        System.err.println(Duration.between(cur, end).toMillis() / 1000);


        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(12);
        Integer sum = c.stream().mapToInt(Integer::intValue).sum();
        System.err.println(sum);


        File file = new File("e:\\oscar\\oscar-remove.txt");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        for (int i = 0; i < 158; i++) {
            writer.write("del db6:BookEventWeb:IPOSCAR:book" + i + "\t\n");
        }
        writer.close();
        fileWriter.close();





    }


    private static String test() {

        String s = "a";

        try {
            File file = new File("c:\\fdfdsfdsfdsfdfds.text");
            FileInputStream inputStream = new FileInputStream(file);
            s = "b";
            return s;


        } catch (Exception e) {
           // s = "c";
            return s;
        }finally {
            s = "d";
            System.err.println("finally " + s);
        }
    }




}
class User{
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
