/**
 * Description:
 * User: daipeng
 * Date: 2019-02-01 9:51
 * Project:CodeSnippet
 */
package fastjson;

import com.alibaba.fastjson.JSON;

public class Test {
    public static void main(String[] args) {
        Student stu = new Student("wang");
        String json = JSON.toJSONString(stu);
        System.err.println(json);

        Student student = JSON.parseObject(json, Student.class);
        System.err.println(student);


        System.err.println(1548989899685L - 1548989891563L > 5 * 1000);

    }
}
