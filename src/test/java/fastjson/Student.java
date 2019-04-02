/**
 * Description:
 * User: daipeng
 * Date: 2019-02-01 9:51
 * Project:CodeSnippet
 */
package fastjson;

public class Student {
    private String name;

//    public Student(){
//
//    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
